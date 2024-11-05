package TestNG_Pac;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG1_EX {
    WebDriver driver;
    @Test(dataProvider = "dp")
    public void f(String username, String password) throws InterruptedException {
        System.out.println("This is the test");
        if(driver.findElement(By.id("input-email")).isDisplayed()) {
            driver.findElement(By.id("input-email")).sendKeys(username);
            Assert.assertTrue(true); // Assertion passed if the element is displayed
        } else {
            System.out.println("Email input field is not displayed");
            Assert.fail("Email input field is not available for input");
        }


        driver.findElement(By.id("input-email")).sendKeys(username);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(20000); // wait for login to complete
    }
    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        System.out.println("This is the @BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is the @AfterMethod");
        driver.quit();
    }

    @Test(dataProvider = "dp")
    public Object[][] dp() {
        return new Object[][] {
                {"hussainengineer2025@gmail.com", "Opencart@2025"}, // correct email and password combination
                {"hussainengineer2024@gmail.com", "Opencart@2024"},// correct email and password combination
                {"testuser@example.com", "incorrectPassword"} ,      // test with incorrect credentials
        };
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is the @BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is the @AfterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is the @BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is the @AfterTest");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is the @BeforeSuite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("This is the @AfterSuite");
    }
}
