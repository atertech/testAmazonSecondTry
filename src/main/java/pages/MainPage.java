package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tools.DriverStarter;
import tools.PageTools;

import java.util.ResourceBundle;

public class MainPage  {
    private WebDriver driver;
    private PageTools pageTools;
    @SneakyThrows
    public MainPage(){
        this.driver= DriverStarter.getDriver();
        this.pageTools = new PageTools(driver);
    }
    By searchFieldMainPage = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    By searchBtn = By.xpath("//*[@id=\"nav-search-submit-button\"]");
    By dropDownMenu = By.xpath("//*[@id=\"searchDropdownBox\"]");
    By bookOptions = By.xpath("//*[@id=\"searchDropdownBox\"]/option[6]");

    public void goToAmazonMainPage() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Thread.sleep(2500);
    }

    public void clickOnDropDown(){
        pageTools.clickOnElement(dropDownMenu);
    }
    public void selectBookCategory(){
        pageTools.clickOnElement(bookOptions);
    }
    public void clickOnSearchField(){
        pageTools.clickOnElement(searchFieldMainPage);
    }
    public void searchNeededBooks(){
        pageTools.sendKeyword(searchFieldMainPage, ResourceBundle.getBundle("constants").getString("searchKeyword"));
    }
    public void clickOnSearchBtn(){
        pageTools.clickOnElement(searchBtn);
    }
}

