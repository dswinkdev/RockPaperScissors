import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String[] rps = {"🪨", "📃", "✂️"};

    String[] robots = {
            "🧬 Axiom",
            "🌌 Orion",
            "🛰️ Zenith",
            "⚙️ Helix",
            "🔥 Vortex",
            "🛡️ Sentinel",
            "🧿 Cypher",
            "💠 Neutrino",
            "🪐 Atlas",
            "⚔️ Omega-X"
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

    String player = players[random.nextInt(players.length)];
    String robot = robots[random.nextInt(robots.length)];

    int numOfRounds = 3;
    int currRound = 1;
    int roundWin = 25;
    int gameWinnerPts = 75;
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
        while (true) {
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

                    currRound++; // increment round

                    for (int i = 0; i <= numOfRounds; i++) {
                        // check winner logic
                        checkWinner(playerMove, robotMove);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
            }
        }
    }

    void checkWinner(int playerMove, int cpuMove) {

        int result = (playerMove * 10 + cpuMove);

        if (playerScore > robotScore) {
            System.out.println("-------------");
            System.out.println("WINNER -> " + player);
        } else if (robotScore > playerScore) {
            System.out.println("-------------");
            System.out.println("WINNER -> " + robot);
        } else {
            System.out.println("winner has yet to be determined... keep playing!");
        }

        switch (result) {
            case 11, 22, 33 -> {
                System.out.println("----");
                System.out.println("tie");
                System.out.println("----");
                System.out.println("no winner");
                System.out.println("0 points");
            }
            case 21 -> {
                System.out.println("-------------");
                System.out.println("📄 covers 🪨");
                System.out.println("-------------");
                System.out.println(player + " wins!");
                System.out.println("-------------");
                playerScore += roundWin;
                System.out.println(playerScore + "+ points");
            }
            case 13 -> {
                System.out.println("-------------");
                System.out.println("🪨 beats ✂️");
                System.out.println("-------------");
                System.out.println(player + " wins!");
                System.out.println("-------------");
                playerScore += roundWin;
                System.out.println(playerScore + "+ points");
            }
            case 32 -> {
                System.out.println("-------------");
                System.out.println("✂️cuts 📄");
                System.out.println("-------------");
                System.out.println(player + " wins!");
                System.out.println("-------------");
                playerScore += roundWin;
                System.out.println(playerScore + "+ points");
            }
            case 31 -> {
                System.out.println("-------------");
                System.out.println("🪨 beats ✂️");
                System.out.println("-------------");
                System.out.println(robot + " wins!");
                System.out.println("-------------");
                robotScore += roundWin;
                System.out.println(robotScore + "+ points");
            }
            case 12 -> {
                System.out.println("-------------");
                System.out.println("📄 covers 🪨");
                System.out.println("-------------");
                System.out.println(robot + " wins!");
                System.out.println("-------------");
                robotScore += roundWin;
                System.out.println(robotScore + "+ points");
            }
            case 23 -> {
                System.out.println("-------------");
                System.out.println("✂️cuts 📄");
                System.out.println("-------------");
                System.out.println(robot + " wins!");
                System.out.println("-------------");
                robotScore += roundWin;
                System.out.println(robotScore + "+ points");
            }
            default -> {
                System.out.println("-------------");
                System.out.println("no winner determined yet... keep playing!");
            }
        }
        playerScore++;
        robotScore++;
        System.out.println(player + ": " + playerScore + " pts.");
        System.out.println(robot + ": " + robotScore + " pts.");
    }
}
