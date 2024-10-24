package org.example.WebDriver_Selenium.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class Sendkeys_Ex {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.opencart.com/en-gb?route=account/register");

        driver.manage().window().maximize();

        driver.findElement(By.id("input-firstname")).sendKeys("Imam");
        driver.findElement(By.id("input-firstname")).sendKeys(Keys.TAB);
        driver.findElement(By.id("input-lastname")).sendKeys(Keys.NUMPAD7);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(320,document.body.scrollHeight)");


        Thread.sleep(1000);
        WebElement subscribe = driver.findElement(By.id("input-newsletter"));
        subscribe.click();
        if(subscribe.isSelected()){
            System.out.println("subscribed");
        }
        else{
            System.out.println("unsubscribe");
        }


    }
}
