import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    //book related functions
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Librarian> librarians = new ArrayList<Librarian>();
    ArrayList<Book> books = new ArrayList<Book>();

    HashMap<Integer, Integer> ISBNmap = new HashMap<Integer, Integer>();

    public void removeBook(int ISBN) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN() == ISBN) {
                books.remove(i);
                break;
            }
        }
    }

    public void addBook(String name, String author, int year, int ISBN, int count) {
        Book book = new Book(name, author, year, ISBN);
        books.add(book);
        ISBNmap.put(ISBN, count);
    }

    public void updateBook(int ISBN, String name, String author, int yearofpublish) {
        for (Book b : books) {
            if (b.getISBN() == ISBN) {
                b.setName(name);
                b.setYearofpublish(yearofpublish);
                b.setAuthor(author);
            }
        }

    }

    public boolean doesBookExist(int ISBN) {
        for (Book book : books) {
            if (book.getISBN() == ISBN) {
                return true;
            }
        }
        return false;
    }

    public Book searchBook(int ISBN) {
        for (Book book : books) {
            if (book.getISBN() == ISBN) {
                return book;
            }
        }
        return null;
    }

    public void increaseBook(int ISBN) {
        ISBNmap.put(ISBN, ISBNmap.get(ISBN) + 1);
    }

    public void decreaseBook(int ISBN) {
        ISBNmap.put(ISBN, ISBNmap.get(ISBN) - 1);
    }

    //user related functions

    public void addUser(String username, String password, User user) {
        users.add(user);
    }


    public boolean doesUserExist(String username) {
        for (User user : users) {
            if (user.getuserName().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public void removeUser(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getuserName().equals(username)) {
                users.remove(i);
                break;
            }
        }
    }

    public User searchUser(String username){
        for(User user : users){
            if(user.getuserName().equals(username)){
                return user;
            }
        }
        return null;
    }

    public void updateUser(String username, String password) {
        System.out.println("Password is changed now");
    }

    public boolean doesUserExist() {
        for (User user : users) {
            if (user.getuserName().equals(Main.username)) {
                return true;
            }
        }
        return false;
    }

    //librarian related functions

    public void addLibrarian(String username, String password) {
        System.out.println("Librarian added!");
    }

    public void removeLibrarian(String username) {
        for (int i = 0; i < librarians.size(); i++) {
            if (librarians.get(i).getUsername().equals(username)) {
                librarians.remove(i);
                break;
            }
        }
    }

    public Librarian searchLibrarian(String username) {
        for (Librarian librarian : librarians) {
            if (librarian.getUsername().equals(username)) {
                return librarian;
            }
        }
        return null;
    }

    public void updateLibrarian(String username, String oldPassword, String newPassword) {
        for (Librarian librarian : librarians) {
            if (librarian.authenticateLibrarian(username, oldPassword)) {
                librarian.setPassword(newPassword);
            }
        }
    }

    public boolean doesLibrarianExist(String username) {
        for (Librarian librarian : librarians) {
            if (librarian.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}


