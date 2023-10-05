import java.util.ArrayList;

public class Library {
    private static Library instance;
    ArrayList<Book> books;
    ArrayList<Student> students;

    Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }
    public static Library getInstance() {
        Library result=instance;
        if (result == null) {
            synchronized (Library.class) {
                result = instance;
                if (result == null)
                    instance = result = new Library();
            }
        }
        return result;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void printBooksInformation() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void printStudentsInformation() {
        for (Student student : students) {
            System.out.println(student.toString());
            student.printBooks();
        }
        System.out.println("Общее количество студентов: " + students.size());
    }

    public int findStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int findBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        return "Library{" +
                "books=" + books.toString() +
                ", students=" + students.toString() +
                '}';
    }
}
