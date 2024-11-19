package TestNG_Pac.API_Assured_usingExcel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class API_Book_Excel1 {

    @Test
    public void processRequestsFromExcel() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\API Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String requestMethod = row.getCell(0).getStringCellValue();
            String url = row.getCell(1).getStringCellValue();
            String name = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null;
            String authorName = row.getCell(3) != null ? row.getCell(3).getStringCellValue() : null;
            String publishedYear = row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null;
            Double price = row.getCell(5) != null ? row.getCell(5).getNumericCellValue() : null;

            String body = "{\n" +
                    "  \"Name\": \"" + name + "\",\n" +
                    "  \"AuthorName\": \"" + authorName + "\",\n" +
                    "  \"PublishedYear\": \"" + publishedYear + "\",\n" +
                    "  \"Price\": " + price + "\n" +
                    "}";

            System.out.println("Request Method: " + requestMethod);
            System.out.println("URL: " + url);
            if (!"GET".equalsIgnoreCase(requestMethod) && !"DELETE".equalsIgnoreCase(requestMethod)) {
                System.out.println("Request Body: " + body);
            }

            if ("POST".equalsIgnoreCase(requestMethod)) {
                RestAssured.given()
                        .contentType(ContentType.JSON)
                        .body(body)
                        .post(url)
                        .then()
                        .statusCode(200);
            } else if ("PATCH".equalsIgnoreCase(requestMethod)) {
                RestAssured.given()
                        .contentType(ContentType.JSON)
                        .body(body)
                        .patch(url)
                        .then()
                        .statusCode(200);
            } else if ("DELETE".equalsIgnoreCase(requestMethod)) {
                RestAssured.given()
                        .delete(url)
                        .then()
                        .statusCode(200);
            } else if ("GET".equalsIgnoreCase(requestMethod)) {
                RestAssured.given()
                        .get(url)
                        .then()
                        .statusCode(200);
            }
        }
        workbook.close();
    }
}
