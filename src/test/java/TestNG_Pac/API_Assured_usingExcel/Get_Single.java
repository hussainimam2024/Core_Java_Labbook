package TestNG_Pac.API_Assured_usingExcel;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Get_Single {
    public String getUrlFromExcel(String filePath, String sheetName, int rowNum, int colNum) {
        String url = "";
        try (FileInputStream input = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(input);
            Sheet sheet = workbook.getSheet(sheetName);
            url = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
    @Test
    public void getSingleBooks_Excel() {
        String filePath = "C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\API Data.xlsx";
        String url = getUrlFromExcel(filePath, "API", 2, 1);
        Response res = RestAssured.get(url);

        System.out.println("Status code: " + res.getStatusCode());
        System.out.println("Response body: " + res.getBody().asPrettyString());
        System.out.println("Header: " + res.contentType());
        System.out.println("Status line: " + res.getStatusLine());
        System.out.println("Response headers: " + res.headers());
    }
}
