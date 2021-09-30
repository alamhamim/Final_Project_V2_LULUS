package com.pages;

import com.logger.GetLogger;
import com.util.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

public class DressesPage extends LoadableComponent<DressesPage> {

    Logger logger = GetLogger.logger(DressesPage.class);
    private WebDriver driver;
    private Properties properties;

    public DressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            properties = SeleniumHelper.readProperties("src/main/resources/Page_Data/dressesPageData.properties");
        } catch (IOException e) {
            logger.debug("Properties file not found for the DressesPage");
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
