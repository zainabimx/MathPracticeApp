import java.util.Random;
import java.util.Scanner;

public class MathPracticeApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int score = 0;

    public static void main(String[] args) {
        System.out.println("=== 🧮 Math Practice App ===");

        while (true) {
            System.out.println("\n1. Start Practice");
            System.out.println("2. View Score");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": startPractice(); break;
                case "2": System.out.println("Your score: " + score); break;
                case "3": System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void startPractice() {
        System.out.println("\nChoose difficulty:");
        System.out.println("1. Easy (1-10)");
        System.out.println("2. Medium (1-100)");
        System.out.println("3. Hard (1-1000)");
        System.out.print("Choice: ");
        int max = switch (scanner.nextLine()) {
            case "1" -> 10;
            case "2" -> 100;
            case "3" -> 1000;
            default -> {
                System.out.println("Invalid. Defaulting to Easy.");
                yield 10;
            }
        };

        System.out.println("\nChoose operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Choice: ");
        String opChoice = scanner.nextLine();

        char operator = switch (opChoice) {
            case "1" -> '+';
            case "2" -> '-';
            case "3" -> '*';
            case "4" -> '/';
            default -> '+';
        };

        for (int i = 0; i < 5; i++) {
            askQuestion(max, operator);
        }

        System.out.println("✅ Practice session finished!");
    }

    private static void askQuestion(int max, char operator) {
        int a = random.nextInt(max) + 1;
        int b = random.nextInt(max) + 1;

        if (operator == '/' && b == 0) b = 1; // avoid division by zero

        int correctAnswer = switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };

        System.out.print("Q: " + a + " " + operator + " " + b + " = ");
        try {
            int userAnswer = Integer.parseInt(scanner.nextLine());
            if (userAnswer == correctAnswer) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect. Answer: " + correctAnswer);
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Not a valid number.");
        }
    }
}
