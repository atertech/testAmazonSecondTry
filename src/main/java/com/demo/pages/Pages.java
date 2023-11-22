package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    /**
     * Pages
     */
    private static NavigationPage navigationPage;
    private static SearchResult searchResult;

    /**
     * This function return an instance of `NavigationPage`
     */
    public static NavigationPage navigationPage() {
        if (navigationPage == null) {
            navigationPage = new NavigationPage();
        }
        return navigationPage;
    }
    public static SearchResult searchResult(){
        if (searchResult == null) {
            searchResult = new SearchResult();
        }
        return searchResult;
    }
}