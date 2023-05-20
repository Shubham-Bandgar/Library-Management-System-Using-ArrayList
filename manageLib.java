import java.util.ArrayList;
import java.util.Scanner;
public class manageLib {
    public static void main(String[] args) {
       // @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        ArrayList<Admin> admin = new ArrayList<Admin>();

        lib.addStudent("Shubham", 1);
        lib.addStudent("mihir", 2);

        admin.add(new Admin("admin", "pass"));
        admin.add(new Admin("Shubham", "Pass"));

        while (true) {
            System.out.println("=========WELCOME=========");
            System.out.println("1.Admin Sign in");
            System.out.println("2.Admin Sign Up");
            System.out.println("3.Exit");
            System.out.println("-------------------------");

            int choice = sc.nextInt();
            Admin currentAdmin = null;

            switch (choice) {
                case 1:
                    System.out.println("Admin Name-");
                    String adminname = sc.next();
                    boolean isAuthenticated = false;

                    for (Admin admin1 : admin) {
                        if (admin1.name.equals(adminname)) {
                            System.out.println("Password-");
                            String adminPassword = sc.next();
                            isAuthenticated = admin1.authenticate(adminPassword);

                            if (isAuthenticated) {
                                currentAdmin = admin1;
                            }
                            break;
                        }
                    }
                    if (isAuthenticated) {
                        while (true) {
                            System.out.println("1.Add Book");
                            System.out.println("2.Remove book");
                            System.out.println("3.Add students");
                            System.out.println("4.Remove student");
                            System.out.println("5.Display books");
                            System.out.println("6.Display students");
                            System.out.println("7.Log out");
                            choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Enter book title:");
                                    String title = sc.next();
                                    System.out.println("Enter book author:");
                                    String author = sc.next();
                                    System.out.println("Enter book id:");
                                    int id = sc.nextInt();
                                    lib.addBook(title, author, id);
                                    break;

                                case 2:
                                    System.out.println("Enter book id:");
                                    id = sc.nextInt();
                                    lib.removeBook(id);
                                    break;

                                case 3:
                                    System.out.println("Enter student name:");
                                    String name = sc.next();
                                    System.out.println("Enter student roll no:");
                                    int rollNo = sc.nextInt();
                                    lib.addStudent(name, rollNo);
                                    break;

                                case 4:
                                    System.out.println("Enter student roll no:");
                                    rollNo = sc.nextInt();
                                    lib.removeStudent(rollNo);
                                    break;

                                case 5:
                                    lib.displayBooks();
                                    break;

                                case 6:
                                    lib.displayStudents();
                                    break;

                                case 7:
                                    currentAdmin = null;
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                            if (currentAdmin == null) {
                                break;
                            }
                        }

                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 2:
                    System.out.println("Enter admin name:");
                    adminname = sc.next();
                    System.out.println("Enter password:");
                    String adminPassword = sc.next();
                    admin.add(new Admin(adminname, adminPassword));
                    System.out.println("Admin account created successfully.");
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

    }

}
