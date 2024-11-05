package org.example.WebDriver_Selenium.Examples.Test_Pack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class Login_gettingExcel {
    public static void main(String[] args) throws IOException, InterruptedException {


        FileInputStream file = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\loginsheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("credentials");
        int noofrows = sheet.getPhysicalNumberOfRows();
        System.out.println(noofrows);

        for (int i = 0; i < noofrows; i++) {

            String testUrl = sheet.getRow(i).getCell(0).getStringCellValue();
            String Username = sheet.getRow(i).getCell(1).getStringCellValue();
            String Password = sheet.getRow(i).getCell(2).getStringCellValue();

            System.out.println("username"+Username);
            System.out.println("password"+Password);
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            LOGIN_POM obj = new LOGIN_POM(driver);
            driver.get(testUrl);

            driver.manage().window().maximize();
            Thread.sleep(2000);
            obj.enterusername(Username);
            Thread.sleep(2000);
            obj.enterpassword(Password);
            Thread.sleep(2000);
            obj.Loginbtn();
            Thread.sleep(2000);
        }

    }
}
