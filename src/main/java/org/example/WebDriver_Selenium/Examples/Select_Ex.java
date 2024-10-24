package org.example.WebDriver_Selenium.Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Select_Ex {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        // Open OpenCart website and navigate to Mac Desktops
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        Select sort = new Select(driver.findElement(By.id("input-sort")));
        sort.selectByIndex(5);
        sort.selectByVisibleText("Rating (lowest)");

        List<WebElement> allOptions = sort.getOptions();

        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
        driver.quit();
    }
}
