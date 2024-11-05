package org.example.WebDriver_Selenium.Examples.Test_Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LOGIN_POM {
    WebDriver driver;
    By username=By.id("input-email");
    By password=By.id("input-password");
    By loginbutton=By.xpath("//button[@type='submit' and contains(@class, 'btn btn-primary')]");

    public LOGIN_POM(WebDriver driver) {
        this.driver=driver;
    }

    void enterusername(String name) {
        driver.findElement(username).sendKeys(name);
    }

    void enterpassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    void Loginbtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(loginbutton)); // corrected line
    }
}
