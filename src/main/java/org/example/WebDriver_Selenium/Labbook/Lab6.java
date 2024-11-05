package org.example.WebDriver_Selenium.Labbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab6 {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Step 1: Login with credentials
        driver.get("https://www.flipkart.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
    }
}
