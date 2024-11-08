package TestNG_Pac.Capstone_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        // Automatically downloads and sets up EdgeDriver
        WebDriverManager.edgedriver().setup();

        // Use the class-level driver and initialize it
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

//    @AfterSuite
//    public void tearDown() {
//            driver.quit();
//     }
}
