package org.example.WebDriver_Selenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

class Google_Ex1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        /*
        //this is explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //it is used for ignoring the exception
        Wait wait1 = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

        //page wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));


         */
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('testing methods')");
        Thread.sleep(5000);
        //driver.switchTo().alert().accept(); //for automatically handles by selenium


        //scroll by
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight);");


        System.out.println("Title of the web page: " + driver.getTitle());
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Testing method");
        element.submit();

        Thread.sleep(3000);
        System.out.println("Title of the web page: " + driver.getTitle());
        driver.navigate().to("https://www.yahoo.com");
        System.out.println("Title of the web page: " + driver.getTitle());

        driver.navigate().back();
        System.out.println("Title of the web page: " + driver.getTitle());

        driver.navigate().forward();
        System.out.println("Title of the web page: " + driver.getTitle());

        System.out.println("URL of the web page: " + driver.getCurrentUrl());

        System.out.println("page source: " + driver.getPageSource());
        System.out.println("page source is:"+driver.getPageSource().contains("yahoo"));

        //driver.close();
    }
}
