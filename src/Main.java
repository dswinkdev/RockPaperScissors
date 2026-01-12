import java.util.Random;
import java.util.Scanner;

void main() {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    boolean isRunning = true;

    RockPaperScissors rockPaperScissors = new RockPaperScissors();
//    rockPaperScissors.viewAllCities();
//    rockPaperScissors.viewAllPlayers();
//    rockPaperScissors.viewAllRobots();
    rockPaperScissors.viewAllWorldEmojis();

    rockPaperScissors.rpsMenu();

    // start game
    while (isRunning) {
        rockPaperScissors.createPlayer();
        rockPaperScissors.playGame();
        rockPaperScissors.scoreBoard();

        do {
            System.out.print("play again? (yes/no): ");
            String playAgain = scanner.nextLine();

            if (playAgain.equals("y") || playAgain.equals("yes")) {
                System.out.println("resetting game...");
            } else {
                System.out.println("Thanks for playing!");
                isRunning = false;
            }
        } while (isRunning);

        scanner.close(); // close scanner
    }
}
