
public class Books {
    private String authorName;
    private String bookName;
    private boolean availableBook;

    Books(){
        this("unknown","xyz",false );
    }

    public Books( String authorName, String bookName, boolean availableBook) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.availableBook = availableBook;
    }
    @Override
    public String toString() {
        return "Book Name -> "+bookName+" | "+"Author Name -> "+authorName+" | "+"Available -> "+availableBook;
    }

    public boolean matchesName(String name) {
        return bookName.equalsIgnoreCase(name);
    }

    public boolean isAvailableBook(){
        return availableBook;
    }

    public void setAvailableBook(boolean availableBook) {
        this.availableBook = availableBook;
    }

}
