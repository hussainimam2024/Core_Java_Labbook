package com.example.book_hive_project.TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@CucumberOptions(
        features = "C:\\Users\\imam.hussain\\IdeaProjects\\Book_Hive_Project\\src\\test\\java\\com\\example\\book_hive_project\\feature\\BookApi.feature", // Location of your feature files
        glue = {"com.example.book_hive_project.StepDefination"},
        plugin = {"pretty"} // Keep "pretty" for console output
)
public class TestRunner extends AbstractTestNGCucumberTests {

        public static ExtentReports extent;
        public static ExtentTest test;

        @BeforeSuite
        public static void setup() {
                // Initialize the ExtentSparkReporter for generating reports
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-reports/index.html");
                sparkReporter.config().setReportName("Book Hive API Tests");
                sparkReporter.config().setDocumentTitle("Book Hive API Test Execution Report");

                // Attach the ExtentSparkReporter to ExtentReports
                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
        }

        @AfterSuite
        public static void tearDown() {
                // Flush and write the report to the output location
                extent.flush();
        }
}
