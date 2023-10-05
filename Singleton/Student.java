import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private String surname;
    private String group;
    private ArrayList<Book> borrowedBooks;

    Student(int id, String name, String surname, String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
        borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    public void borrowBook(String title, String author, String isbn, int year, int bookYear, Library library) {

        boolean isHere = false;

        for (Book borrowedBook : borrowedBooks) {
            if (borrowedBook.getIsbn().equals(isbn)) {
                System.out.println("Already exist!");
                isHere = true;
                break;
            }
        }

        if (!isHere) {
            int index = library.findBook(isbn);
            if (index == -1) {
                System.out.println("Book does not exist!");
            } else {
                library.getBooks().remove(index);
                borrowedBooks.add(new Book(title, author, isbn, year));
            }
        }

    }

    //this method allows to return book from student to library
    //by removing selected book from arraylist

    public void returnBook(String title, String author, String isbn, int year, Library library) {
        for (int i = 0; i < borrowedBooks.size(); ++i) {
            if (borrowedBooks.get(i).getIsbn().equals(isbn)) {
                System.out.println("Book removed!");
                borrowedBooks.remove(i);
                library.getBooks().add(new Book(title, author, isbn, year));
                break;
            }
        }
    }

    //this method allows to print the list of borrowed books
    public void printBooks() {
        for (Book borrowedBook : borrowedBooks) {
            System.out.println("\t" + borrowedBook.toString());
        }
    }

    public String toString() {
        return id + "|" + name + "|" + surname + "|" + group;
    }

    public int findBorrowBook(String isbn) {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if (borrowedBooks.get(i).getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }

}
