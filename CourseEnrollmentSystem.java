import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private final String name;
    private final String id;
    private final List<Course> enrolledCourses;
    private final Map<Course, Double> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Course> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses); // Return a copy to preserve encapsulation
    }

    public void enrollInCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            throw new IllegalStateException("Student is already enrolled in " + course.getName());
        }
        if (course.getCurrentEnrollment() >= course.getMaxCapacity()) {
            throw new IllegalStateException("Course " + course.getName() + " is at full capacity");
        }
        enrolledCourses.add(course);
        course.addStudent();
    }

    public void assignGrade(Course course, double grade) {
        if (!enrolledCourses.contains(course)) {
            throw new IllegalStateException("Student is not enrolled in course " + course.getName());
        }
        if (grade < 0.0 || grade > 100.0) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        grades.put(course, grade);
    }

    public double calculateOverallGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return grades.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}

class Course {
    private final String courseCode;
    private final String name;
    private final int maxCapacity;
    private int currentEnrollment;
    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String name, int maxCapacity) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty");
        }
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Maximum capacity must be positive");
        }

        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public void addStudent() {
        if (currentEnrollment >= maxCapacity) {
            throw new IllegalStateException("Course is at maximum capacity");
        }
        currentEnrollment++;
        totalEnrolledStudents++;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}

class CourseManagement {
    private static final Map<String, Course> courses = new HashMap<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        if (courses.containsKey(courseCode)) {
            throw new IllegalArgumentException("Course with code " + courseCode + " already exists");
        }
        Course course = new Course(courseCode, name, maxCapacity);
        courses.put(courseCode, course);
        System.out.println("Course " + name + " added successfully.");
    }

    public static Course getCourse(String courseCode) {
        Course course = courses.get(courseCode);
        if (course == null) {
            throw new IllegalArgumentException("Course with code " + courseCode + " not found");
        }
        return course;
    }

    public static void enrollStudent(Student student, Course course) {
        try {
            student.enrollInCourse(course);
            System.out.println("Successfully enrolled " + student.getName() + " in " + course.getName());
        } catch (IllegalStateException e) {
            System.out.println("Enrollment failed: " + e.getMessage());
        }
    }

    public static void assignGrade(Student student, Course course, double grade) {
        try {
            student.assignGrade(course, grade);
            System.out.println("Grade assigned successfully");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Grade assignment failed: " + e.getMessage());
        }
    }

    public static void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("\nCourse List:");
        courses.values().forEach(course -> System.out.printf("Code: %s, Name: %s, Enrollment: %d/%d%n",
                course.getCourseCode(),
                course.getName(),
                course.getCurrentEnrollment(),
                course.getMaxCapacity()));
    }
}

public class CourseEnrollmentSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            try {
                displayMenu();
                int choice = getValidChoice();

                if (choice == 6) {
                    System.out.println("Exiting program. Goodbye!");
                    break;
                }

                processChoice(choice);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear scanner buffer
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Course Management System ===");
        System.out.println("1. Add Course");
        System.out.println("2. Enroll Student");
        System.out.println("3. Assign Grade");
        System.out.println("4. Calculate Overall Grade");
        System.out.println("5. Display Courses");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getValidChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void processChoice(int choice) {
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> addCourse();
            case 2 -> enrollStudent();
            case 3 -> assignGrade();
            case 4 -> calculateOverallGrade();
            case 5 -> CourseManagement.displayCourses();
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private static void addCourse() {
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine().trim();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine().trim();
        System.out.print("Enter Maximum Capacity: ");
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
    }

    private static void enrollStudent() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine().trim();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine().trim();

        Student student = students.computeIfAbsent(studentId,
                id -> new Student(studentName, id));
        Course course = CourseManagement.getCourse(courseCode);
        CourseManagement.enrollStudent(student, course);
    }

    private static void assignGrade() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine().trim();
        System.out.print("Enter Grade (0-100): ");
        double grade = Double.parseDouble(scanner.nextLine());

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        Course course = CourseManagement.getCourse(courseCode);
        CourseManagement.assignGrade(student, course, grade);
    }

    private static void calculateOverallGrade() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        double overallGrade = student.calculateOverallGrade();
        System.out.printf("Overall grade for %s: %.2f%n",
                student.getName(), overallGrade);
    }
}