package ui;

import model.Student;
import service.StudentManager;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentManager manager = new StudentManager();

    public void start() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addStudent();
                case "2" -> viewAll();
                case "3" -> searchStudent();
                case "4" -> updateStudent();
                case "5" -> deleteStudent();
                case "6" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Grade: ");
        double grade = Double.parseDouble(scanner.nextLine());

        manager.addStudent(new Student(id, name, age, grade));
        System.out.println("Student added.");
    }

    private void viewAll() {
        for (Student s : manager.getAllStudents()) {
            System.out.println(s);
        }
    }

    private void searchStudent() {
        System.out.print("Enter ID to search: ");
        String id = scanner.nextLine();
        Student s = manager.findById(id);
        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void updateStudent() {
        System.out.print("Enter ID to update: ");
        String id = scanner.nextLine();
        Student s = manager.findById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("New Name: ");
        String name = scanner.nextLine();
        System.out.print("New Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("New Grade: ");
        double grade = Double.parseDouble(scanner.nextLine());

        manager.updateStudent(id, name, age, grade);
        System.out.println("Student updated.");
    }

    private void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        String id = scanner.nextLine();
        manager.deleteStudent(id);
        System.out.println("Student deleted.");
    }
}