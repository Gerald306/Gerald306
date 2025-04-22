import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalQuestions = 5;
        
        System.out.println("Welcome to Geralds Quiz Game!\n");
        
        // Question 1
        System.out.println("1. What is the capital of Uganda?");
        System.out.println("A) Kampala\nB) Nairobi\nC) Kigali\nD) Kinshasha");
        System.out.print("Your answer: ");
        char answer1 = scanner.next().toUpperCase().charAt(0);
        if (answer1 == 'A') {
            score++;
        }
        
        // Question 2
        System.out.println("\n2. Who developed Java?");
        System.out.println("A) Microsoft\nB) Sun Microsystems\nC) Apple\nD) IBM");
        System.out.print("Your answer: ");
        char answer2 = scanner.next().toUpperCase().charAt(0);
        if (answer2 == 'B') {
            score++;
        }
        
        // Question 3
        System.out.println("\n3. What is the longest river in the world?");
        System.out.println("A) River Mississippi\nB) Yellow River\nC) Rhine River\nD) River Nile");
        System.out.print("Your answer: ");
        char answer3 = scanner.next().toUpperCase().charAt(0);
        if (answer3 == 'D') {
            score++;
        }
        
        // Question 4
        System.out.println("\n4. In which year was java founded?");
        System.out.println("A) 1900\nB) 1995\nC) 2000\nD) 2015");
        System.out.print("Your answer: ");
        char answer4 = scanner.next().toUpperCase().charAt(0);
        if (answer4 == 'B') {
            score++;
        }
        
        // Question 5
        System.out.println("\n5. What does RAM stand for?");
        System.out.println("A) Random Access Memory\nB) Read Access Memory\nC) Rapid Access Module\nD) Run Access Memory");
        System.out.print("Your answer: ");
        char answer5 = scanner.next().toUpperCase().charAt(0);
        if (answer5 == 'A') {
            score++;
        }
        
        // Calculate and display score
        double percentage = ((double) score / totalQuestions) * 100;
        System.out.println("\nQuiz Over! Your score: " + score + "/" + totalQuestions);
        System.out.println("Final percentage: " + percentage + "%");
        
        // Feedback using switch-case
        switch (score) {
            case 5:
                System.out.println("Excellent! You got all answers right!");
                break;
            case 3: case 4:
                System.out.println("Good job! But there's room for improvement.");
                break;
            case 1: case 2:
                System.out.println("You need more practice. Try again!");
                break;
            default:
                System.out.println("Better luck next time!");
        }
        
        scanner.close();
    }
}
