package com.pages;

import com.util.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

public class DressesPage extends LoadableComponent<DressesPage> {

    public WebDriver driver;
    Properties properties;

    public DressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            properties = SeleniumHelper.readProperties("src/main/resources/Page_Data/dressesPageData.properties");
        } catch (IOException e) {
            System.out.println("Properties file not found for the DressesPage");
        }
    }


    @FindBy(xpath = "click red")
    WebElement clickRed;

    @FindBy(xpath = "color")
    WebElement getColor;

    public void verifyTheRed(String givenColor) {
        SeleniumHelper.click(clickRed);
        SeleniumHelper.verifyTheProductColor(getColor, givenColor);
    }

    @Override
    protected void load() {
        driver.navigate().to(properties.getProperty("url"));
        //here should be logger class
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(driver.getTitle(), properties.getProperty("title"));
        //here should be logger class
    }
}
