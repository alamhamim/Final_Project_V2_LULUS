package com.util;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Helper {

    public static void click(WebElement element) {
        element.click();
    }

    public static Properties readProperties(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        Properties properties = new Properties();
        properties.load(file);
        return properties;
    }

    public static void verifyTotalNumberOfProduct(WebElement element, int givenNumber) {
        int total = Integer.parseInt(element.getText());
        if (total == givenNumber) {
            System.out.println("Verified");
        } else {
            System.out.println("Can not verify");
        }
    }

    public static void verifyTheProductColor(WebElement element, String color) {
        if (element.getText().equals(color)) {
            System.out.println(color + " " + "color is verified");
        } else {
            System.out.println(color+" "+"color can be not verified");
        }
    }

    public static String getDateAndTime() {
        SimpleDateFormat date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return date.format(currentDate);

    }

    public static void takeScreenShot(WebDriver driver) throws IOException {

        //
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        Files.copy(SrcFile, new File("ScreenShots/pic_" + getDateAndTime() + ".png"));
    }
}
