package TestNG_Pac.Capstone_project;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartActionsPage_POM {
    WebDriver driver;

    // Initialize elements
    public CartActionsPage_POM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='shopify-section-template--16703737233646__eaa56fe8-8f6c-4858-8b1a-5ad4b4fc6238']/div/div[2]/div[1]/img")
    WebElement productImage;

    @FindBy(xpath = "//*[@id='AddToCartText-8017757602030']")
    WebElement addToCartButton;

    @FindBy(id = "HeaderCartTrigger")
    WebElement cartButton;

    @FindBy(id = "minusqty") // Assuming this is the decrement button
    WebElement removeButton;

    @FindBy(xpath = "/html/body/div[2]/main/div/div[3]/header/div/p[1]")
    WebElement emptyCartMessage;

    @FindBy(xpath = "//*[contains(@class, 'header-top_wrapper')]")
    WebElement headerTopWrapper;

    // Click on product image to go to the product details page
    public void clickOnProduct() {
        productImage.click();
    }

    // Method to scroll and add to cart
    public void scrollAndAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));  // Wait for button to be clickable

        // Scrolling and adding to cart
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");  // Scroll down to ensure the button is visible

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));  // Wait for button again to be sure it's clickable
        js.executeScript("arguments[0].click();", addToCartButton);  // Click the add to cart button via JS
        System.out.println("Product has been added to the cart.");
    }


    // Open the cart page
    public void openCart() {
        cartButton.click();
    }

    // Remove the product from the cart
    public void removeProductFromCart() {
        removeButton.click();
    }

    // Verify the empty cart message
    public void verifyEmptyCartMessage() {
        String expectedMessage = "Oops, your cart is feeling a bit light. Time to give it some love and add some goodies!";
        String actualMessage = emptyCartMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The empty cart message does not match!");
        System.out.println("Verified: " + actualMessage);
    }

    // Method to dismiss popup if present
    public void dismissPopupIfPresent() {
        try {
            if (headerTopWrapper.isDisplayed()) {
                headerTopWrapper.click();  // Or handle close if there's a close button
                System.out.println("Popup dismissed.");
            }
        } catch (Exception e) {
            // Handle the case when the element is not present or not displayed
            System.out.println("No popup found.");
        }
    }
}
