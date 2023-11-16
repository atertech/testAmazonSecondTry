package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tools.DriverStarter;
import tools.PageTools;

import java.util.List;
import java.util.ResourceBundle;

public class SearchResultPage {
    private WebDriver driver;
    private PageTools pageTools;
    @SneakyThrows
    public SearchResultPage(){
        this.driver= DriverStarter.getDriver();
        this.pageTools = new PageTools(driver);
    }
    By resultPageTitle = By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-wide-grid-style-t1.s-opposite-dir.s-wide-grid-style.sg-row >" +
            " div.sg-col-20-of-24.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > " +
            "span.rush-component.s-latency-cf-section > div.s-main-slot.s-result-list.s-search-results.sg-row > div.a-section.a-spacing-none.s-result-item.s-flex-full-width.s" +
            "-border-bottom-none.s-widget.s-widget-spacing-large > div > span > div > div > span");

    By bookTitle = By.xpath("//h2/a/span");
    By authorName = By.xpath("//div[@class='a-row a-size-base a-color-secondary']");
    By bookPrice = By.xpath("//span[@class='a-price']");

    public List<Books> getListOfBooks(){
        return pageTools.getBooks(bookTitle,authorName,bookPrice);
    }
    public boolean isBookIsPresent(){
        List<Books>booksList=getListOfBooks();
        return pageTools.isNeededBookInTheList(booksList, ResourceBundle.getBundle("constants").getString("searchKeyword"));
    }
    public boolean pageTitleIsDisplayed(){
            return pageTools.checkIfDisplayed(resultPageTitle);
    }
}
