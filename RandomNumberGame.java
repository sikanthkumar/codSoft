import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int totalRoundsWon = 0;

        while (playAgain) {
            int min = 1;
            int max = 100;
            int randomNumber = random.nextInt(max - min + 1) + min;
            int userGuess;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the Random Number between " + min + " and " + max + ": ");

            while (!guessedCorrectly && attempts < 5) {
                attempts++;
                userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    totalRoundsWon++;
                    System.out.println("Congratulations! Your guess is correct.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Sorry, your guess is too low. Try again.");
                } else {
                    System.out.println("Sorry, your guess is too high. Try again.");
                }
            }

            totalAttempts += attempts;

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + randomNumber);
            }

            System.out.println("Your score for this round: " + (guessedCorrectly ? attempts : 0) + " attempts.");

            System.out.println("Do you want to play again? (yes/no)");
            String playAgainChoice = scanner.next();
            if (!playAgainChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Total rounds won: " + totalRoundsWon);
        System.out.println("Your score based on rounds won: " + totalRoundsWon);
        System.out.println("Your score based on total attempts: " + totalAttempts);

        scanner.close();
    }
}
