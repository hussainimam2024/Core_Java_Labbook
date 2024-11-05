package TestNG_Pac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_EX {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is the @BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is the @BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is the @BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is @BeforeMethod");
    }

    @Test(dataProvider = "dp")
    public void f(Integer n, String s) {
        System.out.println("This is the test with parameters: " + n + ", " + s);
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                new Object[] { 1, "a" },
                new Object[] { 2, "b" },
        };
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is @AfterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is the @AfterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is the @AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is the @AfterSuite");
    }
}
