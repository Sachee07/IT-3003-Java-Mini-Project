import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Database Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by Name");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    dao.insertStudent(new Student(name, age, email));
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    students.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    dao.updateStudent(new Student(id, newName, newAge, newEmail));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    break;

                case 5:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    List<Student> found = dao.searchByName(searchName);
                    found.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
