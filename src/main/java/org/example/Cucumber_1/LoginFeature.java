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

public class LoginFeature {

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
        driver.findElement(By.id("input-email")).sendKeys("hussainengineer2024@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Opencart@2024");
    }

    @When("Click on login button")
    public void click_on_login_button() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        js.executeScript("arguments[0].click();", loginButton);
    }

    @Then("Login should be successful")
    public void login_should_be_successful() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).isDisplayed()) {
//            System.out.println("Login successful");
//        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccountDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nav float-end']//div[@class='dropdown']")));
        myAccountDropdown.click();

        WebElement logoutOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='dropdown-item'][normalize-space()='Logout'])[1]")));
        if (logoutOption.isDisplayed()) {
            System.out.println("Login successful, Logout option is visible.");
        } else {
            System.out.println("Login unsuccessful, Logout option not found.");
        }
    }

    @Then("Login should be unsuccessful")
    public void login_should_be_unsuccessful() {
        if (driver.findElement(By.linkText("Logout")).isDisplayed()) {
            System.out.println("Login unsuccessful");
        } else {
            System.out.println("Login successful");
        }
    }
}
