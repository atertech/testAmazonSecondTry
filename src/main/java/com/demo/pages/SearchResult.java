package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.demo.core.base.PageTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends PageTools {
    private By bookTitle = By.xpath("//h2/a/span");
    private By author = By.xpath("//div[@class='a-row a-size-base a-color-secondary']");
    private By searchResult = By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]");

    @Step ("Collect all book info in List")
    public List<String> collectAllBookInfoInOneList() {
        List<SelenideElement> titleElements = getElements(bookTitle);
        List<SelenideElement> authorElements = getElements(author);

        List<String> bookInfoList = new ArrayList<>();

        for (int i = 0; i < titleElements.size(); i++) {
            String bookTitleText = titleElements.get(i).getText();
            String authorText = authorElements.get(i).getText();

            String bookInfo = bookTitleText + " - " + authorText;
            bookInfoList.add(bookInfo);
        }
        return bookInfoList;
    }
    @Step("Search needed book in the list")
    public boolean isBookInTheList(List<String> bookInfoList, CertainBook certainBook){
        List<String> certainBookInfo = certainBook.getBookInformation();
        String certainBookTitle = certainBookInfo.get(0);
        String certainBookAuthor = certainBookInfo.get(1);

        for (String bookInfo : bookInfoList) {
            if (bookInfo.contains(certainBookTitle) && bookInfo.contains(certainBookAuthor)) {
                return true;
            }
        }
        return false;
    }
    @Step("Verify if browser open needed page")
    public boolean searchResultTitleIsDisplayed(){
        return isElementVisible(searchResult);
    }
}
