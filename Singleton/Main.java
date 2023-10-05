import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = Library.getInstance();

        
        library.getStudents().add(new Student(0, "Olegzei", "Ilyev", "CS-2207"));
        library.getStudents().add(new Student(1, "William", "Robertson", "SE-2207"));
        library.getStudents().add(new Student(2, "Dasha", "Puteshesvennica", "IT-2210"));

        library.getBooks().add(new Book("Spring", "He", "1234", 2023));
        library.getBooks().add(new Book("Winter", "She", "2143", 2023));
        library.getBooks().add(new Book("Fall", "It", "1243", 2023));


        Scanner in = new Scanner(System.in);
        int choice = -1;
        Library lib=Library.getInstance();
        System.out.println(lib);
        while (choice != 0) {

            System.out.println("Welcome to the AITU Library");
            System.out.println("1. Add book");
            System.out.println("2. Add student");
            System.out.println("3. Give book to student");
            System.out.println("4. Return book from student");
            System.out.println("5. Print books information");
            System.out.println("6. Print students information");
            System.out.println("7. Print student's books");
            System.out.println("0. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the title:");
                    String title = in.next();
                    System.out.println("Enter the author:");
                    String author = in.next();
                    System.out.println("Enter the ISBN:");
                    String isbn = in.next();
                    System.out.println("Enter the year:");
                    int year = in.nextInt();
                    int indexB = library.findBook(isbn);
                    if (indexB == -1) {
                        library.getBooks().add(new Book(title, author, isbn, year));
                    } else {
                        System.out.println("Such a book already exists");
                    }
                }
                case 2 -> {
                    System.out.println("Enter ID:");
                    int id = in.nextInt();
                    System.out.println("Enter student's name");
                    String name = in.next();
                    System.out.println("Enter student's surname");
                    String surname = in.next();
                    System.out.println("Enter student's group(Major-number of group)");
                    String group = in.next();
                    int indexS = library.findStudent(id);
                    if (indexS == -1) {
                        library.getStudents().add(new Student(id, name, surname, group));
                    } else {
                        System.out.println("Such a student already exists");
                    }
                }
                case 3 -> {
                    System.out.println("Enter ID:");
                    int id = in.nextInt();
                    int indexS = library.findStudent(id);
                    if (indexS == -1) {
                        System.out.println("There is no such student");
                    } else {
                        System.out.println("Enter the ISBN:");
                        String isbn = in.next();
                        int indexB = library.findBook(isbn);
                        if (indexB == -1) {
                            System.out.println("There is no such book");
                        } else {
                            Book book = library.getBooks().get(library.findBook(isbn));
                            library.getStudents().get(indexS).borrowBook(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getYear(), book.getYear(), library);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Enter ID:");
                    int id = in.nextInt();
                    int indexS = library.findStudent(id);
                    if (indexS == -1) {
                        System.out.println("There is no such student");
                    } else {
                        System.out.println("Enter the ISBN:");
                        String isbn = in.next();
                        int indexB = library.getStudents().get(indexS).findBorrowBook(isbn);
                        if (indexB == -1) {
                            System.out.println("There is no such book");
                        } else {
                            Book book = library.getStudents().get(indexS).getBorrowedBooks().get(indexB);
                            library.getStudents().get(indexS).returnBook(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getYear(), library);
                        }
                    }
                }
                case 5 -> {
                    System.out.println( "Title|  Author | ISBN | Year| Quantity");
                    library.printBooksInformation();

                }
                case 6 -> {
                    System.out.println( "USERID |  NAME | Surname | Major-Group");
                    library.printStudentsInformation();

                }
                case 7 -> {

                    System.out.println("Enter ID:");
                    int id = in.nextInt();
                    int indexS = library.findStudent(id);
                    if (indexS == -1) {
                        System.out.println("There is no such student");
                    } else {
                        System.out.println(library.getStudents().get(indexS).toString());
                        library.getStudents().get(indexS).printBooks();
                    }
                }
            }
        }
    }
}
