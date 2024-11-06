package org.example.WebDriver_Selenium.Examples.Test_Pack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.example.Datadriven_Framework.pageobjects.LOGIN_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_pageFactory {
    public static void main(String[] args) throws InterruptedException, IOException {

        Properties prob = new Properties();
        InputStream input = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\application.properties");
        prob.load(input);

        String test_url = prob.getProperty("url");
        String uname = prob.getProperty("username");
        String pword = prob.getProperty("password");

        // Setup EdgeDriver
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        // Use the PageFactory to initialize elements
        LOGIN_POM obj = PageFactory.initElements(driver, LOGIN_POM.class);

        // Navigate to the webpage
        driver.get(test_url);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Perform login steps
        obj.enterusername(uname);
        Thread.sleep(2000);
        obj.enterpassword(pword);
        Thread.sleep(2000);
        obj.Loginbtn();


        Thread.sleep(2000);

    }
}
