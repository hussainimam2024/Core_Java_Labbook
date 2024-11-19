package TestNG_Pac.API_Assured_usingExcel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class Post_Book_excel {

    // Method to fetch data from Excel
    public Object[][] getDataFromExcel(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip the header row

        // Get the total number of rows and columns
        int rows = sheet.getPhysicalNumberOfRows() - 1;
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows][cols];
        int rowIndex = 0;

        // Iterate through rows and columns
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (int colIndex = 0; colIndex < cols; colIndex++) {
                data[rowIndex][colIndex] = row.getCell(colIndex).toString();
            }
            rowIndex++;
        }
        workbook.close();
        return data;
    }

    @Test
    public void PostBookFromExcel() throws IOException {
        String filePath = "C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\API Data.xlsx";
        String sheetName = "API";  // Replace with your sheet name

        // Get all data from Excel
        Object[][] data = getDataFromExcel(filePath, sheetName);

        // Loop through the data and send POST requests
        for (Object[] row : data) {
            String requestMethod = row[0].toString();
            if ("POST".equalsIgnoreCase(requestMethod)) {
                String url = row[1].toString();
                String name = row[2].toString();
                String authorName = row[3].toString();
                String publishedYear = null;

                // Handle date format and convert to ISO string
                if (row[4] != null && !row[4].toString().isEmpty()) {
                    publishedYear = new SimpleDateFormat("yyyy-MM-dd").format(row[4]);
                }

                // Handle missing price and empty author name
                double price = row[5] != null ? Double.parseDouble(row[5].toString()) : 0.0;
                if (authorName == null || authorName.isEmpty()) {
                    authorName = "Unknown";  // Provide a default value if author is missing
                }

                String body = "{\n" +
                        "  \"Name\": \"" + name + "\",\n" +
                        "  \"AuthorName\": \"" + authorName + "\",\n" +
                        "  \"PublishedYear\": \"" + publishedYear + "\",\n" +
                        "  \"Price\": " + price + "\n" +
                        "}";

                // Send POST request using RestAssured
                Response res = RestAssured.given()
                        .baseUri(url)
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .post("http://192.168.5.80:3000/api/v1/book/getBook/1");

                // Print response details
                System.out.println("Status code: " + res.getStatusCode());
                System.out.println("Response body: " + res.getBody().asPrettyString());
                System.out.println("Header: " + res.contentType());
                System.out.println("Status line: " + res.getStatusLine());
                System.out.println("Response headers: " + res.headers());
            }
        }
    }
}
