package org.example.Datadriven_Framework.testcases;
import org.example.Datadriven_Framework.utilities.ReadExcelData_provider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.example.Datadriven_Framework.pageobjects.LOGIN_POM;
import org.example.Datadriven_Framework.utilities.Readconfig;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

public class login_ExtentReport extends Baseclass {

    @Test(dataProvider="login",dataProviderClass=ReadExcelData_provider.class)
    void loginreport(String uname, String pword) throws InterruptedException, IOException {


        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(("r1.html"));
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Verify the title");
        System.out.println("username" + uname);
        System.out.println("password" + pword);


        Readconfig readconfig = new Readconfig();
        String url1=readconfig.geturl();
        System.out.println("url"+url1);
        setup(url1);


        if(driver.getTitle().equals("Your Store")){
            test.pass("title is matched");
        } else {
            test.fail("Title is not matched");
            File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(ssfile, new File("s.jpg"));
            test.fail("Title is not found:" + test.addScreenCaptureFromPath("s.jpg"));
        }

        LOGIN_POM obj = new LOGIN_POM(driver);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        obj.enterusername(uname);
        Thread.sleep(2000);
        obj.enterpassword(pword);
        Thread.sleep(2000);
        obj.Loginbtn();
        Thread.sleep(2000);
        extent.flush();
        teardown();
    }
}
