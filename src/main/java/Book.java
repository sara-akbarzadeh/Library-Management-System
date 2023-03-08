public class Book {
    //Book should contain name,author,year of publish and ISBN
    private int ISBN;
    private String name;
    private String author;
    private int yearofpublish;

    public Book(String name, String author, int ISBN, int yearofpublish) {
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.yearofpublish = yearofpublish;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearofpublish() {
        return yearofpublish;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setYearofpublish(int yearofpublish) {
        this.yearofpublish = yearofpublish;
    }

    public void upadateISBN(int ISBN){
        this.ISBN = ISBN;
    }

    public void updateName(String name){
        this.name = name;
    }

    public void updateYearofpublish(int yearofpublish){
        this.yearofpublish = yearofpublish;
    }

    public void updateAuthorname(String author){
        this.author = author;
    }
}