import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String[] rps = {"🪨", "📃", "✂️"};

    String[] robots = {
            "🤖 Axiom",
            "🤖 Orion",
            "🤖 Zenith",
            "🤖️ Helix",
            "🤖 Vortex",
            "🤖️ Sentinel",
            "🤖 Cypher",
            "🤖 Neutrino",
            "🤖 Atlas",
            "🤖️ Omega-X"
    };

    String[] players = {
            "🧑‍🚀 Maverick",
            "🔥 Blaze",
            "⚡ Ace",
            "🎯 Striker",
            "🌀 Phantom",
            "🧠 Nova",
            "🏹 Archer",
            "💥 Raptor",
            "🌟 Titan",
            "🎮 Shadow"
    };

    String[] roundOutcomes = {"📄 covers 🪨", "🪨 beats ✂️", "✂️cuts 📄"};

    String player = players[random.nextInt(players.length)];
    String robot = robots[random.nextInt(robots.length)];

    int currRound = 1;
    int roundWin = 25;
    int playerScore = 0;
    int robotScore = 0;

    void rpsMsg() {
        System.out.println("🪨  vs  📄  vs  ✂️");
        System.out.println("*******************");
        System.out.println("ROCK PAPER SCISSORS");
        System.out.println("*******************");
        System.out.println("Best of 3 Rounds\n");
        System.out.println(player + " (YOU) vs " + robot + " (CPU)");
    }

    void gamePlayers() {
        System.out.println(player + " vs. " + robot);
    }

    void startGame() {
        gamePlayers();
        while (currRound <= 3) {
            System.out.println("\n- - - - ROUND " + currRound + " - - - -");
            System.out.print("enter 1| 🪨 rock 2| 📃 paper 3| ✂️ scissors: ");

            try {
                int robotMove = random.nextInt(1, 4);
                int playerMove = scanner.nextInt();

                if (playerMove < 1 || playerMove > 3) {
                    System.out.println("invalid entry (please choose a number between 1-3)");
                } else {
                    System.out.println("\n- - - - results - - - -");
                    System.out.println(player + " chose " + rps[playerMove - 1]);
                    System.out.println(robot + " chose " + rps[robotMove - 1]);
                    System.out.println("- - - - - - - - - - -");
                    // check winner logic
                    checkWinner(playerMove, robotMove);

                    currRound++; // increment round

                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
            }
        }
    }

    void checkWinner(int playerMove, int robotMove) {

        int result = (playerMove * 10 + robotMove);

        // tie
        switch (result) {
            case 11, 22, 33 -> {
                System.out.println("tie");
                System.out.println("-------------");
                System.out.println("No winner in round " + currRound);
                System.out.println("0 points");
            }

            // player wins
            case 21 -> {
                System.out.println(roundOutcomes[0] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWin;
                System.out.println(playerScore + "+ points");
            }
            case 13 -> {
                System.out.println(roundOutcomes[1] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWin;
                System.out.println(playerScore + "+ points");
            }
            case 32 -> {
                System.out.println(roundOutcomes[2] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWin;
                System.out.println(playerScore + "+ points");
            }

            // robot wins
            case 12 -> {
                System.out.println(roundOutcomes[0] + " -> " + robot + " takes round " + currRound);
                System.out.println("----------------------------------------");
                robotScore += roundWin;
                System.out.println(robotScore + "+ points");
            }
            case 31 -> {
                System.out.println(roundOutcomes[1] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                robotScore += roundWin;
                System.out.println(robotScore + "+ points");
            }
            case 23 -> {
                System.out.println(roundOutcomes[2] + " -> " + player + " takes round " + currRound);
                System.out.println("-----------------------------------------");
                robotScore += roundWin;
                System.out.println(robotScore + "+ points");
            }
            default -> {
                System.out.println("----------------------------------------");
                System.out.println("no winner determined yet... keep playing!");
            }
        }
        System.out.println(player + ": " + playerScore + " pts.");
        System.out.println(robot + ": " + robotScore + " pts.");

        if (playerScore > robotScore && currRound == 3) {
            System.out.println("-------------");
            System.out.println("WINNER -> " + player + " (YOU)");
        } else if (robotScore > playerScore && currRound == 3) {
            System.out.println("-------------");
            System.out.println("WINNER -> " + robot + " (CPU)");
        } else {
            System.out.println("winner has yet to be determined... keep playing!");
        }
    }
}
