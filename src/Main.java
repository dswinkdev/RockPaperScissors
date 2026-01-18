import java.util.Scanner;

public static void main(String[] args) {
    RockPaperScissors rockPaperScissors = new RockPaperScissors();

//    rockPaperScissors.viewAllPlayers();
//    rockPaperScissors.viewAllWorldEmojis();
//    rockPaperScissors.viewAllCities();
//    rockPaperScissors.viewAllRobots();
//    rockPaperScissors.viewRestrictedNames();
//    rockPaperScissors.viewAllVenues();
//    rockPaperScissors.venueCount();

    Scanner scanner = new Scanner(System.in);
    rockPaperScissors.rpsMenu();

    do {
        rockPaperScissors.playGame();
        rockPaperScissors.scoreBoard();
        rockPaperScissors.showSponsors();

        System.out.print("play again? y/n: ");
        String playAgain = scanner.nextLine();

        if (playAgain.equals("y") || playAgain.equals("yes")) {
            rockPaperScissors.resetGame(true);
        } else {
            rockPaperScissors.resetGame(false);
            return;
        }
    } while (true);

}

