package com.pages;

import com.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import java.io.IOException;
import java.util.Properties;

public class NewPage extends LoadableComponent<NewPage> {

    WebDriver driver;
    Properties properties;

    public NewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            properties = Helper.readProperties("src/main/resources/Page_Data/newPageData.properties");
        } catch (IOException e) {
            System.out.println("newPageData file not found");
        }
    }

    @FindBy(xpath = "bottoms")
    WebElement dresses;

    @FindBy(xpath = "XS")
    WebElement size_xs;

    @FindBy(xpath = "total number")
    WebElement total_product;

    public void bottom_xs_verify(int givenNumber) {
        Helper.click(dresses);
        Helper.click(size_xs);
        Helper.verifyTotalNumberOfProduct(total_product, givenNumber);
    }

    @Override
    protected void load() {
        System.out.println("Could not verify the NewPage");
        driver.navigate().to(properties.getProperty("url"));
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(driver.getTitle(), properties.getProperty("title"));
    }
}
