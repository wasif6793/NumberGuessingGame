//# NumberGuessingGame
//A number guessing game developed using java programming.
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 8;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;

        System.out.println("Welcome to Guess the Number! .");


        for (int round = 1; round <= MAX_ROUNDS; round++) {
            System.out.println("Round " + round);
            int targetNumber = random.nextInt(MAX_RANGE) + 1;
            int score = playGame(targetNumber, scanner);
            totalScore += score;

            System.out.println("Round Score: " + score);
            System.out.println("-------------------");
        }

        System.out.println("Game Over!");
        System.out.println("Total Score: " + totalScore);

        scanner.close();
    }

    private static int playGame(int targetNumber, Scanner scanner) {
        int attempts = 0;
        int score = 0;

        while (true) {
            System.out.print("Enter your guess (1-" + MAX_RANGE + "): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the number.");
                score = MAX_ATTEMPTS - attempts + 1;
                break;
            } else if (guess < targetNumber) {
                System.out.println("The number is higher. ");
            } else {
                System.out.println("The number is lower. ");
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("You have reached the maximum number of attempts. The number was: " + targetNumber);
                break;
            }
        }

        return score;
    }
}
