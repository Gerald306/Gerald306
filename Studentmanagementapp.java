package com.example.studentmanagement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentManagementApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Management System");

        // Main layout
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new javafx.geometry.Insets(10));

        // Menu
        MenuBar menuBar = new MenuBar();
        Menu studentMenu = new Menu("Student");
        MenuItem addStudent = new MenuItem("Add Student");
        MenuItem updateStudent = new MenuItem("Update Student");
        MenuItem viewStudents = new MenuItem("View Students");
        studentMenu.getItems().addAll(addStudent, updateStudent, viewStudents);

        Menu courseMenu = new Menu("Course");
        MenuItem enrollStudent = new MenuItem("Enroll Student");
        courseMenu.getItems().add(enrollStudent);

        Menu gradeMenu = new Menu("Grade");
        MenuItem assignGrade = new MenuItem("Assign Grade");
        gradeMenu.getItems().add(assignGrade);

        menuBar.getMenus().addAll(studentMenu, courseMenu, gradeMenu);

        // Event Handlers
        addStudent.setOnAction(e -> showAddStudentForm());
        updateStudent.setOnAction(e -> showUpdateStudentForm());
        viewStudents.setOnAction(e -> showStudentDetails());
        enrollStudent.setOnAction(e -> showEnrollStudentForm());
        assignGrade.setOnAction(e -> showAssignGradeForm());

        mainLayout.getChildren().add(menuBar);

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAddStudentForm() {
        Stage stage = new Stage();
        stage.setTitle("Add Student");

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField idField = new TextField();
        idField.setPromptText("Student ID");

        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        Button addButton = new Button("Add Student");
        addButton.setOnAction(e -> {
            // Add student logic
            stage.close();
        });

        layout.getChildren().addAll(new Label("Add New Student"), nameField, idField, ageField, addButton);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void showUpdateStudentForm() {
        Stage stage = new Stage();
        stage.setTitle("Update Student");

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        TextField idField = new TextField();
        idField.setPromptText("Student ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        Button updateButton = new Button("Update Student");
        updateButton.setOnAction(e -> {
            // Update student logic
            stage.close();
        });

        layout.getChildren().addAll(new Label("Update Student Information"), idField, nameField, ageField, updateButton);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void showStudentDetails() {
        Stage stage = new Stage();
        stage.setTitle("Student Details");

        TableView<Student> table = new TableView<>();
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Student, String> idColumn = new TableColumn<>("Student ID");
        TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");

        table.getColumns().addAll(nameColumn, idColumn, ageColumn);

        // Populate table with student data

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));
        layout.getChildren().addAll(new Label("Student Details"), table);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void showEnrollStudentForm() {
        Stage stage = new Stage();
        stage.setTitle("Enroll Student");

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        ComboBox<String> courseBox = new ComboBox<>();
        courseBox.setPromptText("Select Course");

        ComboBox<String> studentBox = new ComboBox<>();
        studentBox.setPromptText("Select Student");

        Button enrollButton = new Button("Enroll");
        enrollButton.setOnAction(e -> {
            // Enroll student logic
            stage.close();
        });

        layout.getChildren().addAll(new Label("Enroll Student in Course"), courseBox, studentBox, enrollButton);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void showAssignGradeForm() {
        Stage stage = new Stage();
        stage.setTitle("Assign Grade");

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        ComboBox<String> studentBox = new ComboBox<>();
        studentBox.setPromptText("Select Student");

        ComboBox<String> courseBox = new ComboBox<>();
        courseBox.setPromptText("Select Course");

        TextField gradeField = new TextField();
        gradeField.setPromptText("Grade");

        Button assignButton = new Button("Assign Grade");
        assignButton.setOnAction(e -> {
            // Assign grade logic
            stage.close();
        });

        layout.getChildren().addAll(new Label("Assign Grade to Student"), studentBox, courseBox, gradeField, assignButton);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}