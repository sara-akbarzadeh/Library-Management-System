import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner input = new Scanner(System.in);
    static  String username;
    static  String password;
    static Library library = new Library();
    static boolean isLibrarian;
    public static void main(String[] args) {
        while (true){
        isLibrarian = false;
            library.addLibrarian("admin","admin");
            showLoginPage();
            int command = input.nextInt();
            if (command == 1){
                login();
                System.out.println(" Hello");
                boolean run = true;
                while(run){
                    String us,ps,name,author;
                    int Isbn, Year, Count;
                    if(isLibrarian){
                        showLibrarianMenu();
                        command = input.nextInt();
                        switch (command){
                        case 1:
                            System.out.print("Enter your username");
                            us=input.next();
                            if(library.doesUserExist(us)){
                                System.out.println(library.searchUser(us));
                            }
                            else{
                                System.out.println("user is not founded");
                            }
                            break;
                        case 2:
                            System.out.print("enter your username");
                           us = input.next();
                            if(library.doesLibrarianExist(us)){
                                System.out.println(library.searchLibrarian(us));
                            }
                            else{
                                System.out.println(" Librarian is not founded");
                            }
                            break;
                        case 3:
                            System.out.print("Enter Isbn:");
                            Isbn = input.nextInt();
                            if(library.doesBookExist(Isbn)){
                                System.out.println(library.searchBook(Isbn));
                            }
                            else{
                                System.out.println("No Such Book");
                            }
                            break;
                        case 4:
                            System.out.print("enter username: ");
                            us= input.next();
                            System.out.print("enter password: ");
                            ps= input.next();
                            if(!library.doesUserExist(us)){
                                System.out.println("welcome to the library");
                            }
                            else{
                                System.out.println("You already have an account");
                            }
                            break;
                        case 5:
                            System.out.print("Enter username: ");
                            us= input.next();
                            if(library.doesUserExist(us)){
                                User userToRemove = library.searchUser(us);
                                library.removeUser(us);
                                System.out.println(userToRemove.getuserName() + " Removed!");
                            }
                            else{
                                System.out.println("There is no such a user");
                            }
                            break;
                        case 6:
                            System.out.print("Enter your username: ");
                            us= input.next();
                            if(library.doesUserExist(us)){
                                User user = library.searchUser(us);
                                System.out.println("Username: "+ user.getuserName());
                                System.out.println("Password: "+ user.getPassword());
                                System.out.print("New Password: ");
                                System.out.println("Password Changed");
                            }
                            else{
                                System.out.println("There is no such a user");
                            }
                            break;
                        case 7:
                            System.out.print("Enter your username: ");
                            us= input.next();
                            System.out.print("Enter your password: ");
                            ps= input.next();
                            if(!library.doesLibrarianExist(us)){
                                library.addLibrarian(us,ps);
                                System.out.println("Librarian Created");
                            }
                            else{
                                System.out.println("You already have an account");
                            }
                            break;
                        case 8:
                            System.out.print("Enter your username: ");
                            us= input.next();
                            if(library.doesLibrarianExist(us)){
                                Librarian librarianToRemove = library.searchLibrarian(us);
                                library.removeLibrarian(us);
                                System.out.println(librarianToRemove.getUsername() + " Removed!");
                            }
                            else{
                                System.out.println("There is no such a librarian");
                            }
                            break;
                        case 9:
                            System.out.print("Enter your username: ");
                            us= input.next();
                            if(library.doesLibrarianExist(us)){
                                Librarian librarian = library.searchLibrarian(us);
                                System.out.println("Username: "+ librarian.getUsername());
                                System.out.println("Password: "+ librarian.getPassword());
                                System.out.print("New Password: ");
                                ps= input.next();
                                library.updateLibrarian(us,librarian.getPassword(),ps);
                                System.out.println("Password changed successfully");
                            }
                            else{
                                System.out.println("There is no such a librarian");
                            }
                            break;
                        case 10:
                            System.out.print("Name: ");
                            name = input.next();
                            System.out.print("Author: ");
                            author = input.next();
                            System.out.print("Year Of Publish: ");
                            Year = input.nextInt();
                            System.out.print("ISBN: ");
                            Isbn = input.nextInt();
                            System.out.print("Count: ");
                            Count = input.nextInt();
                            if(!library.doesBookExist(Isbn)){
                                library.addBook(name,author,Year,Isbn,Count);
                                System.out.println("Book Added!");
                            }
                            else {
                                System.out.println("Book Already Exists");
                            }
                        break;
                        case 11:
                            System.out.print("ISBN: ");
                            Isbn = input.nextInt();
                            if(library.doesBookExist(Isbn)){
                                Book book = library.searchBook(Isbn);
                                library.removeBook(Isbn);
                                System.out.println(book.getName() + " Removed successfully");
                            }
                            else{
                                System.out.println("Book does not exist");
                            }
                            break;
                        case 12:
                            System.out.print("ISBN: ");
                            Isbn = input.nextInt();
                            if(library.doesBookExist(Isbn)){
                                Book book = library.searchBook(Isbn);
                                System.out.print("Name: " + book.getName());
                                System.out.print("Author: " + book.getAuthor());
                                System.out.print("Year of publish: " + book.getYearofpublish());
                                System.out.print("ISBN: " + book.getISBN());
                                System.out.print("Name: ");
                                name = input.next();
                                System.out.print("Author: ");
                                author = input.next();
                                System.out.print("Year of publish: ");
                                Year = input.nextInt();
                                library.updateBook(Isbn, name, author, Year);
                                System.out.println("Book updated");
                            }
                            else {
                                System.out.println("There is no such a book");
                            }
                            break;
                        case 13:
                            run = false;
                            break;
                       }
                    }
                else{
                   showUserMenu();
                        command = input.nextInt();
                        switch (command){
                       case 1:
                           System.out.print("Book name: ");
                           name = input.next();
                           Isbn = input.nextInt();
                           if(library.doesBookExist(Isbn)){
                           System.out.println("You have this book");
                           }
                           else{
                           System.out.println("There is no such a book");
                           }
                           break;
                       case 2:
                           ArrayList<Book> books = library.searchUser(username).getBooks();
                           System.out.println("Which book do you want to return?");
                           for(int i = 0; i < books.size(); i++){
                               System.out.println(i + ". " + books.get(i));
                           }
                           command = input.nextInt();
                           System.out.println("command: " + command);
                           library.increaseBook(books.get(command).getISBN());
                           library.searchUser(username).returnBook(books.get(command));
                           System.out.println("You Returned The Book!");
                           break;
                            case 3:
                                run = false;
                        }
                    }
                }
            }
            else if (command == 2) {
                signUp();
            }
        }
    }



    public static void signUp(){
        System.out.print("Enter Username: ");
        input.nextLine();
        String username = input.nextLine();
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        if(!library.doesUserExist(username)){
            System.out.println("You did it");
        }
        else{
            System.out.println("Username Already Exists!");
        }
    }

    public static void showLibrarianMenu(){
        System.out.print("1.Search a user");
        System.out.print("2.Search a librarian");
        System.out.println("3.Search book");
        System.out.print("4.Add a user ");
        System.out.print("5.Remove a user");
        System.out.println("6.Update a user");
        System.out.print("7.Add librarian");
        System.out.print("8.Remove librarian");
        System.out.println("9.Update librarian");
        System.out.print("10.Add a book");
        System.out.print("11.Remove a book");
        System.out.println("12.Update a book");
        System.out.println("13.Log out");
    }
    public static void showUserMenu(){
        System.out.println("1.Borrow book");
        System.out.println("2.Return book");
        System.out.println("3.Log out");;
    }
    public static void showLoginPage(){
        System.out.println("Login or Sign up?");
        System.out.println("1.Login");
        System.out.println("2.Sign up");

}

    public static void login(){
        while (true){
            System.out.print("\nUsername: ");
            input.nextLine();
            String inputUsername = input.next();
            System.out.print("Password: ");
            String inputPassword = input.next();
            if(library.doesUserExist(inputUsername)){
                    username = inputUsername;
                    password = inputPassword;
                }
                else{
                    System.out.println("Wrong Password");
                }


}
}
}