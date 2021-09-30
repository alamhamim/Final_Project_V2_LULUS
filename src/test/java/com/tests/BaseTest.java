package com.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.browsers.BrowserConfig;
import com.pages.DressesPage;
import com.pages.HomePage;
import com.pages.NewPage;
import com.util.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    NewPage newPage;
    DressesPage dressesPage;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void testSetup() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("TestReports/test_report_" + SeleniumHelper.getDateAndTime() + ".html");
        extent.attachReporter(spark);
        test = extent.createTest("LULUS test");

    }

    @Parameters({"browserName","url"})
    @BeforeMethod
    public void browserSetup(String browserName, String url) {
        driver = BrowserConfig.startAPP(driver, browserName, url);
    }

    @AfterMethod
    public void testResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(result.getMethod().getMethodName()+" is passed!");

        } else {
            test.fail(result.getMethod().getMethodName()+" is failed!");
            SeleniumHelper.takeScreenShot(driver);
        }
        extent.flush();

        BrowserConfig.closeAPP(driver);
    }


}
