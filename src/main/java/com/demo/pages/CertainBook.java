package com.demo.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import com.demo.core.config.SelenideConfig;
import com.demo.core.utils.SelenideTools;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;


public class CertainBook {
    private By bookTitle = By.id("productTitle");
    private By author = By.id("bylineInfo");
    public List<String> getBookInformation() {
        List<String> bookInfo = new ArrayList<>();

        Selenide.open("https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_2?dchild=1&keywords=Java&qid=1610356790&s=books&sr=1-2");

        WebElement titleElement = $(bookTitle);
        WebElement authorElement = $(author);

        String title = titleElement.getText();
        String authorName = authorElement.getText();

        bookInfo.add(title);
        bookInfo.add(authorName);

        return bookInfo;
    }

}
