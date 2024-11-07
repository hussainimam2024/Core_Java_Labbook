package org.example.Datadriven_Framework.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Datadriven_Framework.utilities.Readconfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Baseclass {
    public static WebDriver driver;

    public void setup(String url) throws IOException {
        Readconfig con = new Readconfig();
        String BN = con.getbrowser();

        switch (BN) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(url);
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }
    public void teardown() throws IOException {
        driver.quit();
    }
}
