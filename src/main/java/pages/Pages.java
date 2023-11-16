package pages;

public class Pages {
    public static MainPage mainPage;
    public static SearchResultPage searchResultPage;

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }
    public static SearchResultPage searchResultPage() {
        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }
}
