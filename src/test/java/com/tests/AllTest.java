package com.tests;

import com.pages.HomePage;
import org.testng.annotations.Test;

public class AllTest extends BaseTest{

    @Test(testName = "Size Test")
    public void newPageTest() {
        homePage = new HomePage(driver);
        newPage = homePage.click_on_new().get();
        newPage.bottom_xs_verify(267);
    }

    @Test(testName = "Color Test")
    public void dressesTest() {
        homePage = new HomePage(driver);
        dressesPage = homePage.click_on_dresses().get();
        dressesPage.verifyTheRed("Red");
    }

    @Test(testName = "Search Bar Test")
    public void testSearchBar() {
        homePage = new HomePage(driver);
        homePage.searchBarTest("Shoes", "Shoes");
    }

  /*  @Test
    public void testHeart() {

    }*/

    /*@Test
    public void testPrice() {

    }*/

}
