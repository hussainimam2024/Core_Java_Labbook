package com.example.capstone_project_orangehrm.Testcases;



import com.example.capstone_project_orangehrm.POM.LoginPage;
import com.example.capstone_project_orangehrm.base.BaseClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Login_AdminTest extends BaseClass {

    private LoginPage loginPage;

    // Path to the Excel file that contains the test data
    private static final String EXCEL_FILE_PATH = "C:\\Users\\imam.hussain\\IdeaProjects\\Capstone_Project_OrangeHRM\\ExcelData.xlsx";

    // Set up WebDriver and initialize Excel data before each test
    @BeforeEach
    public void setUpTest() {
        setUp(EXCEL_FILE_PATH);  // Initialize WebDriver and load Excel data
        loginPage = new LoginPage(driver);  // Initialize the LoginPage object
    }

    @Test
    public void testValidLogin() {
        // Load test data from Excel sheet
        String baseUrl = getTestData("baseUrl");
        String username = getTestData("Username");
        String password = getTestData("Password");

        driver.get(baseUrl);  // Navigate to the base URL

        // Perform login action
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Assert that the login is successful (assuming dashboard URL contains 'dashboard')
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed for valid credentials.");
    }

    @Test
    public void testInvalidLogin() {
        String baseUrl = getTestData("baseUrl");

        driver.get(baseUrl);  // Navigate to the base URL

        // Perform login action with invalid credentials
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();

        // Assert that the login fails (assuming 'auth' is part of the URL on failure)
        Assertions.assertTrue(driver.getCurrentUrl().contains("auth"), "Login should fail for invalid credentials.");
    }

    @Test
    public void testForgotPassword() {
        String baseUrl = getTestData("baseUrl");

        driver.get(baseUrl);  // Navigate to the base URL

        // Perform forgot password action
        loginPage.clickForgotPassword();

        // Load test data for forgot password from Excel
        String usernameForReset = getTestData("ForgotPasswordUsername");  // **Change: Fetch ForgotPasswordUsername from Excel**
        loginPage.enterUsernameAfterForgot(usernameForReset);  // **Change: Use the retrieved username from Excel**
        loginPage.clickResetButton();

        // Verify the reset password confirmation message from Excel
        String expectedMessage = getTestData("ResetPasswordVerifyText");  // **Change: Fetch expected reset message from Excel**
        String actualMessage = loginPage.getResetPasswordVerifyText();
        Assertions.assertEquals(expectedMessage, actualMessage, "Reset password verification failed.");
    }

    // Clean up after tests
    @Override
    public void tearDown() {
        super.tearDown();  // Close browser and quit WebDriver after tests
    }
}
