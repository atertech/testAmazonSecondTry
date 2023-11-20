package core.pages;

import core.base.PageTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NavigationPage extends PageTools {

    private By bookCategory=By.xpath("//*[@id=\"searchDropdownBox\"]/option[7]");
    private By dropDownMenu = By.id("searchDropdownBox");
    private By searchFiled = By.id("twotabsearchtextbox");
    private By navigationPageTitle = By.xpath("//*[@id=\"nav-logo-sprites\"]");
    private By searchBtnConfirm = By.id("nav-search-submit-button");


    @Step("Click on dropdown menu")
    public void clickOnDropDownMenu(){
        waitForElementClickable(dropDownMenu);
        click(dropDownMenu);
    }
    @Step("Select 'Book' category")
    public void selectBookCategory(){
        click(bookCategory);
    }
    @Step("Click on search field")
    public void clickOnSearchField(){
        click(searchFiled);
    }
    @Step ("Insert Text In SearchField")
    public void insertText(){
        insertText();
    }
    @Step("Verify if browser open needed page")
    public boolean navigationPageTitleIsDisplayed(){
        return isElementVisible(navigationPageTitle);
    }
    @Step("Start searching")
    public void confirmSearch(){
        click(searchBtnConfirm);
    }

}