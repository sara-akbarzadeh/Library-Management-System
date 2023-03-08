import java.util.ArrayList;
import java.util.Scanner;

public class User {
    //User should have a list of books
    //User should have a username and a password
    private String username;
    private String password;

    private ArrayList<Book> borrowedBooks;
    private ArrayList<Book> books = new ArrayList<Book>();

    public User(String password, String username) {
        this.username = username;
        this.password = password;
        borrowedBooks = new ArrayList<Book>();
    }
    public String getPassword() {
        return password;
    }

    public String getuserName() {
        return username;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void rentBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

}
