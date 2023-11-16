package pages;

public class Books {
    private String title;
    private String author;
    private String price;

    public Books(String title, String author, String price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPrice(){
        return price;
    }
}
