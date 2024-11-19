package TestNG_Pac.API_Assured_usingExcel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Patch_book {

    @Test
    public void updateBookFromExcel() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\API Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String RequestMethod = row.getCell(0).getStringCellValue();
            if ("PATCH".equalsIgnoreCase(RequestMethod)) {
                String url = row.getCell(1).getStringCellValue();
                String name = row.getCell(2).getStringCellValue();
                String authorName = row.getCell(3).getStringCellValue();
                String publishedYear = row.getCell(4).getStringCellValue();
                double price = row.getCell(5).getNumericCellValue();

                String body = "{\n" +
                        "  \"Name\": \"" + name + "\",\n" +
                        "  \"AuthorName\": \"" + authorName + "\",\n" +
                        "  \"PublishedYear\": \"" + publishedYear + "\",\n" +
                        "  \"Price\": " + price + "\n" +
                        "}";

                RestAssured.given()
                        .baseUri(url)
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .patch()
                        .then()
                        .statusCode(200);
            }
        }

        workbook.close();
    }
}
