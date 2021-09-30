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

    @FindBy(xpath = "Search bar")
    WebElement searchBar;

    @FindBy(xpath = "Search Result")
    WebElement searchResult;

    //Clicking on the NEW page from header
    public NewPage click_on_new() {
        SeleniumHelper.click(headerNew);
        return new NewPage(driver);
    }

    //Clicking on the DRESSES from the header
    public DressesPage click_on_dresses() {
        SeleniumHelper.click(headerDresses);
        return new DressesPage(driver);
    }

    //This test case will execute from here because this has to be done from the home page
    public void searchBarTest(String searchText, String expectedResult) {
        SeleniumHelper.type(searchBar, searchText);
        SeleniumHelper.verifyTheRightProduct(searchBar, expectedResult);
    }


}
