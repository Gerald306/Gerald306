import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private Map<Course, Double> enrolledCourses;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, null);
        }
    }

    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
        }
    }
}

class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
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

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    public static void incrementTotalEnrolledStudents() {
        totalEnrolledStudents++;
    }
}

class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course course = new Course(courseCode, name, maxCapacity);
        courses.add(course);
    }

    public static void enrollStudent(Student student, Course course) {
        if (course.getMaxCapacity() > Course.getTotalEnrolledStudents()) {
            student.enrollInCourse(course);
            Course.incrementTotalEnrolledStudents();
            students.add(student);
        } else {
            System.out.println("Course is full. Cannot enroll student.");
        }
    }

    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }

    public static double calculateOverallGrade(Student student) {
        double totalGrade = 0;
        int courseCount = 0;
        for (Double grade : student.getEnrolledCourses().values()) {
            if (grade != null) {
                totalGrade += grade;
                courseCount++;
            }
        }
        return courseCount > 0 ? totalGrade / courseCount : 0;
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static List<Student> getStudents() {
        return students;
    }
}

public class AdministratorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Course Enrollment and Grade Management System");
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll a student");
            System.out.println("3. Assign a grade");
            System.out.println("4. Calculate overall grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    enrollStudent(scanner);
                    break;
                case 3:
                    assignGrade(scanner);
                    break;
                case 4:
                    calculateOverallGrade(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
        int maxCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
        System.out.println("Course added successfully.");
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        Student student = new Student(studentName, studentId);
        Course course = findCourseByCode(courseCode);

        if (course != null) {
            CourseManagement.enrollStudent(student, course);
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void assignGrade(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            CourseManagement.assignGrade(student, course, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Student or course not found.");
        }
    }

    private static void calculateOverallGrade(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = findStudentById(studentId);

        if (student != null) {
            double overallGrade = CourseManagement.calculateOverallGrade(student);
            System.out.println("Overall grade for student " + student.getName() + ": " + overallGrade);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudentById(String studentId) {
        for (Student student : CourseManagement.getStudents()) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
