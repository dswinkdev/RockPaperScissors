import java.util.Random;
import java.util.Scanner;

void main() {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    boolean isRunning = true;

    do {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();

        rockPaperScissors.rpsMsg();

        System.out.print("\nReady to play (yes/no): ");
        String userPlay = scanner.nextLine().toLowerCase();

        System.out.print("enter player name: ");
        rockPaperScissors.player = rockPaperScissors.randomEmojis
                [random.nextInt(rockPaperScissors.randomEmojis.length)]
                + scanner.nextLine();

        if (userPlay.equals("y") || userPlay.equals("yes")) {
            rockPaperScissors.startGame();
            rockPaperScissors.scoreBoard();

            System.out.print("play again? (yes/no): ");
            String playAgain = scanner.nextLine();

            if (playAgain.equals("y") || playAgain.equals("yes")){
                isRunning = true;
                System.out.println("resetting game...");
            } else {
                isRunning = false;
                System.out.println("Thanks for playing!");
                break;
            }

        } else if (userPlay.equals("n") || userPlay.equals("no")) {
            System.out.println("take care! 👋🏽");
            isRunning = false;
        } else {
            System.out.println("invalid entry");
        }
    } while (isRunning);

    scanner.close(); // close scanner
}
