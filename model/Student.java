package model;

public class Student {
    private String id;
    private String name;
    private int age;
    private double grade;

    public Student(String id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(double grade) { this.grade = grade; }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + grade;
    }
}