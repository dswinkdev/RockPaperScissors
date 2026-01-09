import java.util.Random;
import java.util.Scanner;

void main() {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    boolean isRunning = true;

    RockPaperScissors rockPaperScissors = new RockPaperScissors();

    rockPaperScissors.rpsMenu();
    System.out.print("enter player name: ");
    rockPaperScissors.player = rockPaperScissors.randomEmojis
            [random.nextInt(rockPaperScissors.randomEmojis.length)]
            + scanner.nextLine();

    do {
            rockPaperScissors.startGame();
            rockPaperScissors.scoreBoard();

            System.out.print("play again? (yes/no): ");
            String playAgain = scanner.nextLine();

            if (playAgain.equals("y") || playAgain.equals("yes")){
                System.out.println("resetting game...");
            } else {
                System.out.println("Thanks for playing!");
                isRunning = false;
            }
    } while (isRunning);

    scanner.close(); // close scanner
}
