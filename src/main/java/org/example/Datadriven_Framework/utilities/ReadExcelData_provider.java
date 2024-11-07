package org.example.Datadriven_Framework.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelData_provider {

    @DataProvider(name = "login")
    public String[][] readdatafromexcel() throws IOException {
        String[][] data = new String[2][2];

        FileInputStream file = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\src\\main\\java\\org\\example\\Datadriven_Framework\\testdata\\loginsheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("credentials");
        int noofrows = sheet.getPhysicalNumberOfRows();
        System.out.println(noofrows);

        for (int i = 0; i < noofrows; i++) {

            //String testUrl = sheet.getRow(i).getCell(0).getStringCellValue();
            String uname = sheet.getRow(i).getCell(0).getStringCellValue();
            String pword = sheet.getRow(i).getCell(1).getStringCellValue();

            data[i][0] = uname;
            data[i][1] = pword;
            System.out.println("username: " + uname);
            System.out.println("password: " + pword);
        }
        return data;

    }
}

