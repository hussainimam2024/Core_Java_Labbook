package org.example.Datadriven_Framework.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Datadriven_Framework.pageobjects.LOGIN_POM;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class login_ExtentReport {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(("r1.html"));
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("login successfull");


        FileInputStream file = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\src\\main\\java\\org\\example\\Datadriven_Framework\\testdata\\loginsheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("credentials");
        int noofrows = sheet.getPhysicalNumberOfRows();
        System.out.println(noofrows);

        String Url = sheet.getRow(0).getCell(0).getStringCellValue();
        Baseclass bc = new Baseclass();
        bc.setup(Url);
        for (int i = 0; i < noofrows; i++) {

            String Username = sheet.getRow(i).getCell(1).getStringCellValue();
            String Password = sheet.getRow(i).getCell(2).getStringCellValue();

            System.out.println("username" + Username);
            System.out.println("password" + Password);
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            LOGIN_POM obj = new LOGIN_POM(driver);
            driver.get(Url);

            if (driver.getTitle().equals("Account Login")) {
                test.pass("Title is matched");
            } else {
                test.fail("Title is not matched");
                File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(ssfile, new File("s.jpg"));
                test.fail("Title is not found:" + test.addScreenCaptureFromPath("s.jpg"));
            }

            WebElement heading2 = driver.findElement(By.tagName("h2"));
            if (heading2.getText().equals("Existing Customer")) {
                test.pass("Existing Customer sub-heading found.");
            } else {
                test.fail("Existing Customer sub-heading not found.");
                File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(ssfile, new File("s1.jpg"));
                test.fail("heading not found"+test.addScreenCaptureFromPath("s1.jpg"));



            }

//            WebElement heading3 = driver.findElement((By.tagName("h2")));
//            if(heading3.getText().equals("New Customer")){
//                test.pass("New customer heading found.");
//            }
//            else{
//                test.fail("New customer heading not found.");
//                File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(ssfile, new File("s2.jpg"));
//            }

            driver.manage().window().maximize();
            Thread.sleep(2000);
            obj.enterusername(Username);
            Thread.sleep(2000);
            obj.enterpassword(Password);
            Thread.sleep(2000);
            obj.Loginbtn();
            Thread.sleep(2000);
            extent.flush();

        }
        bc.teardown();


    }
}
