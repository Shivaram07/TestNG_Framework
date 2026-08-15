package com.icon.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.icon.utilities.ConfigReader;
import com.icon.utilities.ExtentManager;
import com.icon.utilities.ScreenshotUtil;

public class Base {

    protected WebDriver driver;

    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp(ITestResult result) {

        ConfigReader.loadProperties();

        driver = DriverFactory.createDriver();

        driver.get(ConfigReader.getProperty("url"));

        extent = ExtentManager.getExtentReports();

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test passed successfully");

        } else if (result.getStatus() == ITestResult.FAILURE) {
        	String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            driver,
                            result.getMethod().getMethodName());

            test.fail("Test failed")
                .addScreenCaptureFromPath(screenshotPath);
            

        } else if (result.getStatus() == ITestResult.SKIP) {

            test.skip("Test skipped");
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void generateReport() {

        if (extent != null) {
            extent.flush();
        }
    }
}