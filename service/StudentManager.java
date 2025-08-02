package service;

import model.Student;
import java.io.*;
import java.util.*;

public class StudentManager {
    private final String FILE_PATH = "data/students.csv";
    private List<Student> students = new ArrayList<>();

    public StudentManager() {
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public void deleteStudent(String id) {
        students.removeIf(s -> s.getId().equalsIgnoreCase(id));
        saveToFile();
    }

    public void updateStudent(String id, String name, int age, double grade) {
        Student s = findById(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setGrade(grade);
            saveToFile();
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    students.add(new Student(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3])));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing student data found.");
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }
}