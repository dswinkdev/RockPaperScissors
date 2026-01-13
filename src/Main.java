import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        rockPaperScissors.rpsMenu();

        while (isRunning) {

            rockPaperScissors.createPlayer();
            rockPaperScissors.scoreBoard();

            System.out.print("Play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (playAgain.equals("y") || playAgain.equals("yes")) {
                System.out.println("Resetting game...\n");
            } else {
                System.out.println("Thanks for playing!");
                isRunning = false; // ✅ exit loop
            }
        }

        scanner.close();
    }
}
