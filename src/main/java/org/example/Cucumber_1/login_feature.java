package org.example.Cucumber_1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login_feature {
    private WebDriver driver;

    @Given("Launch the Browser")
    public void launch_the_browser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Given("Navigate to the URL")
    public void navigate_to_the_url() {
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
    }

    @When("Enter the valid username and password")
    public void enter_the_valid_username_and_password() {
        driver.findElement(By.id("input-email")).sendKeys("hussainimam2024@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Opencart@2024");
    }

    @When("Click on login button")
    public void click_on_login_button() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300);");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[3]/button")).click();
    }

    @Then("Login should be successful")
    public void login_should_be_successful() {
        try {
            if (driver.findElement(By.linkText("Logout")).isDisplayed()) {
                System.out.println("Login successful");
            }
        } catch (Exception e) {
            System.out.println("Login unsuccessful - element not found: " + e.getMessage());
        }
    }

    @Then("Login should be unsuccessful")
    public void login_should_be_unsuccessful() {
        try {
            if (driver.findElement(By.linkText("Logout")).isDisplayed()) {
                System.out.println("Login unsuccessful");
            } else {
                System.out.println("Login successful");
            }
        } catch (Exception e) {
            System.out.println("Login unsuccessful - expected logout link not found.");
        }
    }
}
