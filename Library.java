import java.util.ArrayList;
import java.util.*;

public class Library {
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Students> students = new ArrayList<Students>();

    public void addBook(String title, String author, int id) {
        books.add(new Book(title, author, id));
        System.out.println("Book added successfully.");
    }		

    public void removeBook(int id) {
        for (Book book : books) {
            if (book.id == id) {
                books.remove(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void addStudent(String name, int rollNo) {
        Students.add(new Students(name, rollNo));
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNo) {
        for (Students student : students) {
            if (student.rollNo == rollNo) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayBooks() {
        System.out.println("Books in library:");
        for (Book book : books) {
            System.out.println(book.title + " by " + book.author + " (ID: " + book.id + ")");
        }
    }

    public void displayStudents() {
        System.out.println("Students in library:");
        for (Students student : students) {
            System.out.println(student.name + " (Roll No.: " + student.rollNo + ")");
        }
    }
}
