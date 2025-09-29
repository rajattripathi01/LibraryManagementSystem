import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        lib.addBooks();
        boolean running = true;

        while (running){
            showMenu();
            String choice =sc.nextLine();
            switch (choice){
                case "1":
                    lib.showAllBooks();
                    break;

                case "2":
                    String searchBook = getBookNameFromUser(sc, "Enter the book name you want to search: ");
                    Books foundBook = lib.userBook(searchBook);
                    if (foundBook != null) {
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case "3":
                    String issueBook = getBookNameFromUser(sc, "Enter the book name you want to issue: ");
                    Books foundIssueBook = lib.userBook(issueBook);
                    if (foundIssueBook != null) {
                        handleIssueBook(sc, lib);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case "4":
                    String returnBook = getBookNameFromUser(sc, "Enter the book name you want to return: ");
                    if (!returnBook.isEmpty()) {
                        lib.returnBook(returnBook);
                    }
                    break;

                case "5":
                    System.out.println("Goodbye! Have a great day.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

    }

    private static void showMenu(){
        System.out.println("\n===== Library Menu ===== ");
        System.out.println("1. View all books");
        System.out.println("2. Search a book");
        System.out.println("3. Issue a book");
        System.out.println("4. Return a book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static String getBookNameFromUser(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    private static void handleIssueBook(Scanner sc, Library lib) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter your full name: ");
            String studentName = sc.nextLine();
            System.out.print("Please enter your roll number: ");
            String rollInput = sc.nextLine().trim();
            int rollNo = Integer.parseInt(rollInput);
            try {
                if (!studentName.isEmpty() && rollNo > 0) {
                    lib.issueMethod(studentName, rollNo);
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Roll number must be a number. Try again.");
            }
        }
    }
}
