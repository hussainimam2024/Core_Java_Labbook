package TestNG_Pac.Capstone_project;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Extent_reportss {
    static ExtentReports extent;
    private static ExtentTest test;
    private WebDriver driver;

    public Extent_reportss(WebDriver driver) {
        this.driver = driver;
    }

    public static void setupExtentReport() {
        // Create an instance of ExtentSparkReporter with the report file path
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Test Report");
        sparkReporter.config().setReportName("Cart Functionality Test");
        sparkReporter.config().setTheme(Theme.STANDARD);

        // Attach the Spark reporter to the ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public void logFailure(String message) throws IOException {
        test.fail(message);
        File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ssfile, new File("s.jpg"));
        test.fail("Message is not correct:" + test.addScreenCaptureFromPath("s.jpg"));
    }

    private String captureScreenshot(String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static void tearDown() {
        if (extent != null) {
            extent.flush();
        }
    }

    public void setTest(ExtentTest test) {
        Extent_reportss.test = test;
    }
}
