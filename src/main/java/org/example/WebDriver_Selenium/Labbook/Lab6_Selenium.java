package org.example.WebDriver_Selenium.Labbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab6_Selenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Step 1: Login with credentials
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys("hussainengineer2026@gmail.com");  // Email from Lab 1
        driver.findElement(By.id("input-password")).sendKeys("Opencart@2025");               // Password from Lab 1

        //login
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class, 'btn btn-primary')]")));
        js.executeScript("arguments[0].click();", loginButton);


        // Go to Components tab and click
        WebElement componentsTab = driver.findElement(By.xpath("//a[text()='Components']"));
        componentsTab.click();


        // Step 3: Select 'Monitors' from the dropdown
        WebElement monitorsLink = driver.findElement(By.xpath("//a[text()='Monitors (2)']"));
        js.executeScript("arguments[0].click();", monitorsLink);

        WebElement element1 = driver.findElement(By.xpath("(//select[@id='input-limit'])[2]"));
        element1.click();
        Thread.sleep(7000);


        //click on add to cart
        WebElement cartButton = driver.findElement(By.xpath("//button[@aria-label='Add to Cart']//i[@class='fa-solid fa-shopping-cart']"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", cartButton);



    }
}
