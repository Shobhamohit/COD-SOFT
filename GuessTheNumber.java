import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        boolean playAgain = true;
        while (playAgain) {

            int randomNumber = random.nextInt(100) + 1;
            int attemptsLeft = 5;
            boolean hasWon = false;

            System.out.println("\nWelcome to 'Guess the Number' game!");
            System.out.println("I have generated a number between 1 and 100.");
            System.out.println("You have 5 attempts to guess the correct number.");


            while (attemptsLeft > 0) {
                System.out.println("\nAttempts remaining: " + attemptsLeft);
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                // Compare the user's guess with the random number
                if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high!");
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    hasWon = true;
                    break;
                }

                // Decrement the attempts left
                attemptsLeft--;
            }


            if (hasWon) {
                int scoreThisRound = attemptsLeft + 1; // The fewer attempts used, the higher the score
                totalScore += scoreThisRound;
                System.out.println("You won this round! Your score for this round is: " + scoreThisRound);
            } else {
                System.out.println("You ran out of attempts! The correct number was: " + randomNumber);
            }


            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");


            System.out.println("Your total score so far is: " + totalScore);
        }


        System.out.println("\nThank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
