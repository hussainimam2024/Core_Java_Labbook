package org.example.keyword_driven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Keyword_Driven {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileInputStream file = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\Opencart.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Getting data from Module sheet
        XSSFSheet sheet = workbook.getSheet("Module");
        int noofrows = sheet.getPhysicalNumberOfRows();
        System.out.println("No of rows: " + noofrows);

        for (int i = 0; i < noofrows; i++) {
            String moduleexe = sheet.getRow(i).getCell(2).getStringCellValue();
            if (moduleexe.equals("Y")) {
                String moduleid = sheet.getRow(i).getCell(0).getStringCellValue();
                System.out.println("moduleid:" + moduleid);

                // Getting data from Testcase sheet
                XSSFSheet testcasesheet = workbook.getSheet("Testcase");
                int noofrows1 = testcasesheet.getPhysicalNumberOfRows();
                System.out.println("No of rows: " + noofrows1);

                for (int j = 0; j < noofrows1; j++) {
                    String testcase_moduleid = testcasesheet.getRow(j).getCell(3).getStringCellValue();
                    String testexe = testcasesheet.getRow(j).getCell(2).getStringCellValue();

                    if (testcase_moduleid.equals(moduleid) && testexe.equals("Y")) {
                        String testcaseid = testcasesheet.getRow(j).getCell(0).getStringCellValue();
                        System.out.println(testcaseid);

                        // Getting data from Teststep
                        XSSFSheet teststepsheet = workbook.getSheet("Teststep");
                        int noofrows2 = teststepsheet.getPhysicalNumberOfRows();
                        System.out.println("No of rows: " + noofrows2);
                        for (int k = 0; k < noofrows2; k++) {
                            String teststep_testcaseid = teststepsheet.getRow(k).getCell(4).getStringCellValue();
                            String keyword = teststepsheet.getRow(k).getCell(3).getStringCellValue();
                            if (teststep_testcaseid.equals(testcaseid)) {
                                switch (keyword) {
                                    case "ln":
                                        login();
                                    case "ca":
                                        closeapp();

                                }
                                System.out.println("Total Teststep: "+teststep_testcaseid);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void login() throws IOException, InterruptedException {
        login_extentReports loginReport = new login_extentReports();
        loginReport.main(null);
    }

    private static void closeapp() {
        WebDriver driver = new EdgeDriver();
        driver.close();
        System.out.println("Closing app");
    }
}
