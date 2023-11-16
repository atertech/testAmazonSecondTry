package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.Pages;
import pages.SearchResultPage;

public class firstTest extends BaseTest {

    @Test
    public void goToMainPage() throws InterruptedException {
        MainPage mainPage = Pages.mainPage();
        SearchResultPage searchResultPage= Pages.searchResultPage();
        mainPage.goToAmazonMainPage();
        mainPage.clickOnDropDown();
        mainPage.selectBookCategory();
        mainPage.clickOnSearchField();
        mainPage.searchNeededBooks();
        mainPage.clickOnSearchBtn();
        Assert.assertTrue(searchResultPage.pageTitleIsDisplayed());
    }

    @Test
    public void getBookList(){
        SearchResultPage searchResultPage= Pages.searchResultPage();
        searchResultPage.getListOfBooks();
    }
    @Test
    public void VerifyThatNeededBookIsPresentOrUnPresentInTheList(){
        SearchResultPage searchResultPage= Pages.searchResultPage();
        searchResultPage.isBookIsPresent();
    }
}
