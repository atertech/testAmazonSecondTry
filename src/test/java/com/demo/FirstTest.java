package com.demo;

import com.demo.core.base.BaseTest;
import com.demo.pages.NavigationPage;
import com.demo.pages.Pages;
import com.demo.testrail.CustomStepResult;
import com.demo.testrail.TestRailAssert;
import com.demo.testrail.TestRailIssue;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class FirstTest extends BaseTest {

    @Test(priority = 1, description = "Verify if driver open needed page")
    public void goToAmazon() throws InterruptedException {
        Thread.sleep(10000);
        boolean isTitleDisplayed = Pages.navigationPage().navigationPageTitleIsDisplayed();
        Assert.assertTrue(isTitleDisplayed, "Title");
    }
    @Test (priority = 2)
    public void selectNeededCategory(){
        Pages.navigationPage().clickOnDropDownMenu();
        Pages.navigationPage().selectBookCategory();
    }
    @Test (priority = 3)
    public void searchNeededCategoryOfBooks(){
        Pages.navigationPage().clickOnSearchField();
        Pages.navigationPage().insertTextInSearchField();
        Pages.navigationPage().confirmSearch();
    }}
    /*@Test(priority = 4)
    public void collectAllBookInfoInOneList(){
        List<String> bookInfoList = Pages.searchResult().collectAllBookInfoInOneList();
        Assert.assertNotNull(bookInfoList, "The result of collectAllBookInfoInOneList is not null");    }
}*/