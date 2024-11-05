package org.example.WebDriver_Selenium.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MouseHover_Ex {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://snapdeal.com/");
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"leftNavMenuRevamp\"]/div[1]/div[2]/ul/li[1]/a/span[2]"));

        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(3000);

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"category1Data\"]/div[3]/div/div/p[2]/a/span"));
        element1.click();
        Thread.sleep(3000);

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"668637584109\"]/div[1]/a/picture/img"));
        element2.click();
        Thread.sleep(3000);



    }
}
