import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Library {
    Map<Integer,Books> booksmap  = new HashMap<>();
    Map<Student,Books> issueBookMap  = new HashMap<>();
    Books userBookData;

    void addBooks(){
        booksmap.put( 100,new Books("Arundhati Roy","The God of Small Things",true));
        booksmap.put(101, new Books("Jane Austen","Pride and Prejudice",true));
        booksmap.put(102, new Books("Leo Tolstoy","War and Peace",true));
        booksmap.put(103,new Books("Toni Morrison","Beloved",true));
    }


    void showAllBooks(){
        System.out.println("Book: ");
        booksmap.forEach((key, value) -> System.out.println(" Id: " + key + " " + value));
    }

    Books userBook(String userBookChoice){
        userBookData = null;
        for (Books value : booksmap.values()) {
            if (value.matchesName(userBookChoice)) {
                userBookData = value;
                break;
            }
        }
        return userBookData;
    }

    void issueMethod(String name,int rollNo){
        assert userBookData != null;
        if(userBookData.isAvailableBook()){
            issueBookMap.put(new Student(name,rollNo),userBookData);
            userBookData.setAvailableBook(false);
            System.out.println("Book successfully issued");
        }else {
            System.out.println("book is not Available");
        }
        viewIssueBook(name);
    }


    void viewIssueBook(String userName){
        Iterator<Map.Entry<Student, Books>> it = issueBookMap.entrySet().iterator();
        boolean status = true;
        while (status){
            if(it.hasNext()) {
                Map.Entry<Student, Books> entry = it.next();
                if(entry.getKey().matchesName(userName)){
                    System.out.println(entry);
                    status = false;
                    System.out.println("This is your issued book details");
                }
            }else {
                System.out.println("There is no issued book available: ");
            }
        }

    }

    void returnBook(String bookName){
        Iterator<Map.Entry<Student, Books>> it = issueBookMap.entrySet().iterator();
        boolean status = true;
        while (status){
            if(it.hasNext()) {
                Map.Entry<Student, Books> entry = it.next();
                if(entry.getValue().matchesName(bookName)){
                    it.remove();
                    userBookData.setAvailableBook(true);
                    status = false;
                    System.out.println("Book Successfully return: ");
                }
            }else {
                System.out.println("Book not found: ");
                break;
            }

        }
    }

}
