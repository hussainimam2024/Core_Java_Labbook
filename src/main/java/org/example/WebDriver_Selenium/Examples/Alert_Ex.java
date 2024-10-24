package org.example.WebDriver_Selenium.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Alert_Ex {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.id("login1")).sendKeys("Imam");
        driver.findElement(By.name("proceed")).click();

        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert message"+alert1.getText());
        alert1.accept();

        //simple alert
        driver.navigate().to("https://letcode.in/alert");
        driver.findElement(By.id("accept")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Alert message"+alert2.getText());
        alert2.accept();

        Thread.sleep(2000);
        //confirm alert
        driver.findElement(By.id("confirm")).click();
        Alert alert3 = driver.switchTo().alert();
        System.out.println("Alert message"+alert3.getText());
        alert3.accept();
        Thread.sleep(2000);

        //prompt alert
        driver.findElement(By.id("prompt")).click();
        Alert alert4 = driver.switchTo().alert();
        System.out.println("Alert message"+alert4.getText());
        Thread.sleep(1000);
        alert4.sendKeys("Imam Hussain");
        alert4.accept();
        Thread.sleep(2000);

        //Modern alert
        driver.findElement(By.id("modern")).click();
        Alert alert5 = driver.switchTo().alert();
        System.out.println("Alert message"+alert5.getText());
        alert5.accept();




    }
}
