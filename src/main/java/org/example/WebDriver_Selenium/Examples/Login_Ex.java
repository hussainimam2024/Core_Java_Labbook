package org.example.WebDriver_Selenium.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class Login_Ex {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("MyAccount")).click();
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        driver.findElement(By.id("user_email_login"));

        driver.findElement(By.linkText("Login")).click();



    }
}
