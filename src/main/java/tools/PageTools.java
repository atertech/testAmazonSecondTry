package tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Books;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class PageTools {
    private WebDriver driver;
    private WebDriverWait wait;

    public PageTools(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
    }

    public void sendKeyword(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.sendKeys(text);
    }

    public List<Books> getBooks(By titleLocator, By authorLocator, By priceLocator) {
        List<Books> booksList = new ArrayList<>();
        List<WebElement> bookTitle = driver.findElements(titleLocator);
        List<WebElement> authorName = driver.findElements(authorLocator);
        List<WebElement> bookPrice = driver.findElements(priceLocator);
        int booksCount = Math.min(Math.min(bookTitle.size(), authorName.size()), bookPrice.size());
        for (int i = 0; i < bookTitle.size(); i++) {
            String title = bookTitle.get(i).getText();
            String author = authorName.get(i).getText();
            String price = bookPrice.get(i).getText();

            Books book = new Books(title, author, price);
            booksList.add(book);
        }
        for (Books books : booksList) {
            System.out.println(" title " + books.getTitle());
            System.out.println(" author " + books.getAuthor());
            System.out.println("price " + books.getPrice());
        }
        return booksList;
    }

    public boolean isNeededBookInTheList(List<Books> booksList, String text) {
        for (Books books : booksList) {
            if (books.getTitle().equals(text)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfDisplayed(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
