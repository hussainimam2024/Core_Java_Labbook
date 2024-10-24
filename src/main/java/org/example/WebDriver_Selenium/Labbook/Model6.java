package org.example.WebDriver_Selenium.Labbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Model6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Step 1: Login with credentials
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys("hussainengineer2026@gmail.com");  // Email from Lab 1
        driver.findElement(By.id("input-password")).sendKeys("Opencart@2025");               // Password from Lab 1

        // Login
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].click();", loginButton);

        Thread.sleep(2000);

        // Step 2: Go to Components tab and click
        WebElement componentsTab = driver.findElement(By.xpath("//a[text()='Components']"));
        componentsTab.click();

        Thread.sleep(2000);

        // Step 3: Select 'Monitors'
        WebElement monitorsLink = driver.findElement(By.xpath("//a[text()='Monitors (2)']"));
        js.executeScript("arguments[0].click();", monitorsLink);

        // Step 4: Select 25 from 'Show' dropdown
        WebElement limitDropdown = driver.findElement(By.id("input-limit"));
        js.executeScript("arguments[0].value='https://demo.opencart.com/en-gb/catalog/component/monitor?limit=25';", limitDropdown);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", limitDropdown);

        Thread.sleep(2000);

        // Step 5: Click on 'Add to cart' for the first item
        WebElement cartButton = driver.findElement(By.xpath("//*[@id='product-list']/div[1]/div/div[2]/form/div/button[1]"));
        js.executeScript("arguments[0].click();", cartButton);

        // Step 6: Click on 'Specification' tab
        WebElement specificationTab = driver.findElement(By.xpath("//a[@href='#tab-specification']"));
        js.executeScript("arguments[0].click();", specificationTab);

        // Step 7: Click on 'Add to Wish list' button
        WebElement wishListButton = driver.findElement(By.xpath("//button[@data-bs-original-title='Add to Wish List']"));
        js.executeScript("arguments[0].click();", wishListButton);

        // Verify message 'Success: You have added Apple Cinema 30" to your wish list!'
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(),'Success: You have added Apple Cinema 30\" to your wish list!')]"));
        if (successMessage.isDisplayed()) {
            System.out.println("Item added to wish list successfully.");
        }

        // Step 8: Search for 'Mobile'
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Mobile");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']"));
        js.executeScript("arguments[0].click();", searchButton);

        // Step 9: Select 'Search in product descriptions'
        WebElement searchDescriptionCheckbox = driver.findElement(By.name("description"));
        if (!searchDescriptionCheckbox.isSelected()) {
            js.executeScript("arguments[0].click();", searchDescriptionCheckbox);
        }

        // Step 10: Click on 'HTC Touch HD' for mobile
        WebElement htcLink = driver.findElement(By.linkText("HTC Touch HD"));
        js.executeScript("arguments[0].click();", htcLink);

        // Step 11: Update quantity to 3 and add to cart
        WebElement quantityBox = driver.findElement(By.id("input-quantity"));
        quantityBox.clear();
        quantityBox.sendKeys("3");

        WebElement addToCartButton = driver.findElement(By.id("button-cart"));
        js.executeScript("arguments[0].click();", addToCartButton);

        // Verify success message for adding to cart
        WebElement successCartMessage = driver.findElement(By.xpath("//div[contains(text(),'Success: You have added HTC Touch HD to your shopping cart!')]"));
        if (successCartMessage.isDisplayed()) {
            System.out.println("HTC Touch HD added to shopping cart successfully.");
        }

        // Step 12: View cart
        WebElement viewCartButton = driver.findElement(By.xpath("//a[@title='Shopping Cart']"));
        js.executeScript("arguments[0].click();", viewCartButton);

        // Verify Mobile name added to the cart
        WebElement cartItem = driver.findElement(By.xpath("//a[text()='HTC Touch HD']"));
        if (cartItem.isDisplayed()) {
            System.out.println("HTC Touch HD is in the cart.");
        }

        // Step 13: Logout
        WebElement myAccountDropdown = driver.findElement(By.xpath("//a[@title='My Account']"));
        js.executeScript("arguments[0].click();", myAccountDropdown);

        WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
        js.executeScript("arguments[0].click();", logoutLink);

        // Verify 'Account Logout' heading
        WebElement logoutHeading = driver.findElement(By.xpath("//h1[text()='Account Logout']"));
        if (logoutHeading.isDisplayed()) {
            System.out.println("Logged out successfully.");
        }

        // Step 14: Click on 'Continue' button after logout
        WebElement continueButton = driver.findElement(By.xpath("//a[text()='Continue']"));
        js.executeScript("arguments[0].click();", continueButton);
    }
}
