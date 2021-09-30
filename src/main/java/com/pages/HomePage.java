package com.pages;

import com.util.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  public  WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "NEW from header")
    WebElement headerNew;

    @FindBy(xpath = "DRESSES from the header")
    WebElement headerDresses;

    public NewPage click_on_new() {
        SeleniumHelper.click(headerNew);
        return new NewPage(driver);
    }

    public DressesPage click_on_dresses() {
        SeleniumHelper.click(headerDresses);
        return new DressesPage(driver);
    }

}
