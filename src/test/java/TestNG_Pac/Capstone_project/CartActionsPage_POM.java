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
    public CartActionsPage_POM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='shopify-section-template--16703737233646__eaa56fe8-8f6c-4858-8b1a-5ad4b4fc6238']/div/div[2]/div[1]/img")
    WebElement productImage;

    @FindBy(xpath = "//*[@id='AddToCartText-8017757602030']")
    WebElement add_Button;

    @FindBy(id = "HeaderCartTrigger")
    WebElement cart_btn;

    @FindBy(id = "minusqty")
    WebElement removeButton;

    @FindBy(xpath = "//div[@class='rte text-spacing']/p[1]")
    WebElement emptyCartMessage;

    @FindBy(xpath = "//*[contains(@class, 'header-top_wrapper')]")
    WebElement headerTopWrapper;

    public void click_Product() {
        productImage.click();
    }
    public void Add_Cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(add_Button));  // Wait for button to be clickable

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");  // Scroll down to ensure the button is visible

        wait.until(ExpectedConditions.elementToBeClickable(add_Button));  // Wait for button again to be sure it's clickable
        js.executeScript("arguments[0].click();", add_Button);  // Click the add to cart button via JS
        System.out.println("Product added in cart.");
    }
    public void openCart() {
        cart_btn.click();
    }
    public void removeProductFromCart() {
        removeButton.click();
        System.out.println("Oops, your cart is feeling a bit light. Time to give it some love and add some goodies!");
    }
    public void verifyEmptyCartMessage() {
        String expectedMessage = "Oops, your cart is feeling a bit light. Time to give it some love and add some goodies!";
        String actualMessage = emptyCartMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The empty cart message does not match!");
        System.out.println("Verified: " + actualMessage);
    }
    public void dismissPopupIfPresent() {
        try {
            if (headerTopWrapper.isDisplayed()) {
                headerTopWrapper.click();
                System.out.println("Popup dismissed.");
            }
        } catch (Exception e) {
            System.out.println("No popup found.");
        }
    }
}
