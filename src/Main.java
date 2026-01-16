import java.util.Scanner;

public static void main(String[] args) {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();

        Scanner scanner = new Scanner(System.in);
        rockPaperScissors.rpsMenu();
        rockPaperScissors.createPlayer();

        do {
            rockPaperScissors.playGame();
            rockPaperScissors.scoreBoard();
            rockPaperScissors.showSponsors();

            System.out.print("play again: y/n");
            String playAgain = scanner.nextLine();

            if (playAgain.equals("y") || playAgain.equals("yes")){
                rockPaperScissors.resetGame(true);
            } else {
                rockPaperScissors.resetGame(false);
                return;
            }
        } while (true);

    }

