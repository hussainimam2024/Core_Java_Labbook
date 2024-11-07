package TestNG_Pac.Capstone_project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CartFunctionalityTest extends Baseclass {
    CartActionsPage_POM cartActionsPage;

    @BeforeMethod
    public void setupTest() {
        cartActionsPage = new CartActionsPage_POM(driver);
    }

    public void clickUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Test
    public void testAddAndRemoveFromCart() {
        driver.get("https://supertails.com/");

        cartActionsPage.clickOnProduct();
        cartActionsPage.scrollAndAddToCart();

        clickUsingJS(cartActionsPage.cartButton);  // Using JS to click if standard click fails

        cartActionsPage.removeProductFromCart();
        cartActionsPage.verifyEmptyCartMessage();
    }
}