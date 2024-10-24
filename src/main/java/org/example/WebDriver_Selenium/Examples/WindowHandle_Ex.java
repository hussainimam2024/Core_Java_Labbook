package org.example.WebDriver_Selenium.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowHandle_Ex {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://letcode.in/windows");
        System.out.println("windows title"+ driver.getWindowHandle());
        driver.findElement(By.id("multi")).click();
        List<String> wh = new ArrayList(driver.getWindowHandles());
        for(String s : wh){
            System.out.println(s);
        }
        driver.switchTo().window(wh.get(0));
        System.out.println("url is"+ driver.getCurrentUrl());

        driver.switchTo().window(wh.get(1));
        System.out.println("url is"+ driver.getCurrentUrl());

        driver.switchTo().window(wh.get(2));
        System.out.println("url is"+ driver.getCurrentUrl());


    }
}
