package org.example.WebDriver_Selenium.Examples.Test_Pack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Datadriven_Framework.pageobjects.LOGIN_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test_Login {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        LOGIN_POM obj = new LOGIN_POM(driver);

        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        driver.manage().window().maximize();


        //driver.findElement(By.id("input-email")).sendKeys("hussainengineer2024@gmail.com");
        obj.enterusername("hussainengineer2024@gmail.com");

        //driver.findElement(By.id("input-password")).sendKeys("Opencart@2024");
        obj.enterpassword("Opencart@2024");

        obj.Loginbtn();

    }
}
