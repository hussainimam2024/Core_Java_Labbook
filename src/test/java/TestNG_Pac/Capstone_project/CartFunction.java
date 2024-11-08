package TestNG_Pac.Capstone_project;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartFunction extends Baseclass {
    CartActionsPage_POM cartActionsPage;
     Extent_reportss extentReport;
    ExtentTest test;

    @BeforeSuite
    public void setupSuite() {
        Extent_reportss.setupExtentReport();
    }

    @BeforeMethod
    public void setupTest() {
        cartActionsPage = new CartActionsPage_POM(driver);
        extentReport = new Extent_reportss(driver);
        test = Extent_reportss.extent.createTest("Action_Cart Test", "Testing cart actions and verifying empty cart message");
        extentReport.setTest(test);
    }

    public void click_btn(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Test
    public void Action_Cart() throws IOException {
        test.info("Navigating to Supertails website.");
        driver.get("https://supertails.com/");

        try {
            cartActionsPage.click_Product();
            test.pass("Clicked on product.");

            cartActionsPage.Add_Cart();
            test.pass("Product added to cart.");

            click_btn(cartActionsPage.cart_btn);
            test.pass("Opened the cart.");

            cartActionsPage.removeProductFromCart();
            test.pass("Product removed from cart.");

            cartActionsPage.dismissPopupIfPresent();
            test.pass("Popup dismissed if present.");

            cartActionsPage.verifyEmptyCartMessage();
            test.pass("Verified empty cart message.");
        } catch (Exception e) {
            extentReport.logFailure("Failed during Action_Cart test execution.");
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        Extent_reportss.tearDown();
        driver.quit();
    }
}
