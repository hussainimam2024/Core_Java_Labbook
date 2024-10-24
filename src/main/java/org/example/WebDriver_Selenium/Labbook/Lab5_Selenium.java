package org.example.WebDriver_Selenium.Labbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab5_Selenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.opencart.com/en-gb?route=account/register");

        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("content.h1"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(320,document.body.scrollHeight)");

        Thread.sleep(1000);




    }

}

