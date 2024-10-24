package org.example.WebDriver_Selenium.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class findelements_ex {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.opencart.com/en-gb?route=account/register");
        List<WebElement> element = driver.findElements(By.xpath("//input[@class='form-control']"));
        for (WebElement i :element){
            System.out.println("Webelement: "+element);
        }
    }
}
