package com.icon.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String fileName = testName + "_" + timestamp + ".png";

        // Actual location where screenshot will be saved
        Path screenshotDirectory =
                Path.of("test-output", "screenshots");

        Path destination =
                screenshotDirectory.resolve(fileName);

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        try {

            Files.createDirectories(screenshotDirectory);

            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Path relative to ExtentReport.html
        return "screenshots/" + fileName;
    }
}