import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    RoundManager roundManager = new RoundManager();

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String[] rps = {"🪨", "📃", "✂️"};

    String[] robots = {
            "🤖Axiom",
            "🤖Orion",
            "🤖Zenith",
            "🤖️Helix",
            "🤖Vortex",
            "🤖️Sentinel",
            "🤖Cypher",
            "🤖Neutrino",
            "🤖Atlas",
            "🤖️Omega-X"
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

    String[] randomEmojis = {
            "🧑🏽‍💻", // hacker / coder
            "🧙🏽‍♂️", // mage
            "🦸🏽‍♂️", // hero
            "🥷🏽",   // ninja
            "🧑🏽‍🚀", // astronaut
            "🧑🏽‍🎤", // performer
            "🧑🏽‍🔧", // engineer
            "🧑🏽‍⚕️", // healer
            "🧑🏽‍🏫", // strategist
            "🧑🏽‍🚒",  // tank / defender
            "👩🏿‍💻" // black girl coder
    };


    String[] roundOutcomes = {"📄covers 🪨", "🪨beats ✂️", "✂️cuts 📄"};

    String player = "";
    String robot = robots[random.nextInt(robots.length)];
    String noWinner = "❌";
    String winner = "";

    int currRound = 1;
    int playerWinPoints = 0;
    int robotWinPoints = 0;
    int numOfRounds = 0;
    int numOfRoundsMax = 15;
    int roundWinPts = 25;
    int playerScore = 0;
    int robotScore = 0;
    int draw = 0;
    int noScore = 0;

    void rpsMsg() {
        System.out.println("🪨  vs  📄  vs  ✂️");
        System.out.println("*******************");
        System.out.println("ROCK PAPER SCISSORS");
        System.out.println("*******************");
        System.out.println(" SharkWave 🌊Tech");
    }

    void gamePlayers() {
        System.out.println(player + " vs. " + robot);
    }

    void startGame() {
        gamePlayers();

        System.out.print("How many rounds do you want to play? (" + numOfRoundsMax + " max): ");
        numOfRounds = scanner.nextInt();

        numberOfRoundsCheck(); // checks number of rounds for min & max

        while (currRound <= numOfRounds) {
            System.out.println("\n- - - - ROUND " + currRound + " - - - -");
            System.out.print("enter 1 -> 🪨 rock 2 -> 📃 paper 3 -> ✂️ scissors: ");

            try {
                int robotMove = random.nextInt(1, 4);
                int playerMove = scanner.nextInt();

                if (playerMove < 1 || playerMove > 3) {
                    System.out.println("invalid entry (please choose a number between 1-3)");
                } else {
                    System.out.println("\n- - - -🏁 ROUND " + currRound + " RESULTS 🏁- - - -");
                    System.out.println(player + " chose " + rps[playerMove - 1]);
                    System.out.println(robot + " chose " + rps[robotMove - 1]);
                    System.out.println("----------------------------------------");

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
        RoundManager roundManager = new RoundManager();
        int result = (playerMove * 10 + robotMove);

        // tie
        switch (result) {
            case 11, 22, 33 -> {
                draw++;
                System.out.println("tie -> no winner in ROUND " + currRound);
                roundWinner(playerScore,robotScore);
            }
            // player wins
            case 21 -> {
                System.out.println(roundOutcomes[0] + " -> " + player + " takes ROUND " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                playerWinPoints++;
                roundWinner(playerScore, robotScore);
                winner = player;
            }
            case 13 -> {
                System.out.println(roundOutcomes[1] + " -> " + player + " takes ROUND " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                playerWinPoints++;
                roundWinner(playerScore, robotScore);
                winner = player;
            }
            case 32 -> {
                System.out.println(roundOutcomes[2] + " -> " + player + " takes ROUND " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                playerWinPoints++;
                roundWinner(playerScore, robotScore);
                winner = player;
            }

            // robot wins
            case 12 -> {
                System.out.println(roundOutcomes[0] + " -> " + robot + " takes ROUND " + currRound);
                System.out.println("----------------------------------------");
                robotScore += roundWinPts;
                robotWinPoints++;
                roundWinner(playerScore, robotScore);
                winner = robot;
            }
            case 31 -> {
                System.out.println(roundOutcomes[1] + " -> " + robot + " takes ROUND " + currRound);
                System.out.println("----------------------------------------");
                robotScore += roundWinPts;
                robotWinPoints++;
                roundWinner(playerScore, robotScore);
                winner = robot;
            }
            case 23 -> {
                System.out.println(roundOutcomes[2] + " -> " + robot + " takes ROUND " + currRound);
                System.out.println("-----------------------------------------");
                robotScore += roundWinPts;
                robotWinPoints++;
                roundWinner(playerScore, robotScore);
                winner = robot;
            }
            default -> {
                System.out.println("----------------------------------------");
                System.out.println("no winner determined yet... keep playing!");
            }
        }
        drawCheck();
    }

    void scoreBoard() {
        System.out.println();
        System.out.println("══════════════════════════════════════════");
        System.out.println("🏁        OFFICIAL GAME SCOREBOARD        🏁");
        System.out.println("══════════════════════════════════════════");

        roundManager.viewAllRounds();

        System.out.println("──────────────────────────────────────────");
        System.out.println("📊           GAMEPLAY SUMMARY             📊");
        System.out.println("──────────────────────────────────────────");

        winDrawPoints();   // calculate win points
        winSweepCheck();   // check for sweep
        declareWinner();   // announce winner
        printTrophy(winner); // print winner trophy

        System.out.println("══════════════════════════════════════════");
        System.out.println("🎉             GAME COMPLETE              🎉");
        System.out.println("══════════════════════════════════════════\n");
    }


    void roundWinner(int playerScore, int robotScore) {

        if (playerWinPoints > robotWinPoints) {
            System.out.println("Round " + currRound + " winner -> " + player + " (+" + playerScore + " pts.)");
            roundManager.addRound(new Round(currRound, player, playerScore, draw));
        } else if (robotWinPoints > playerWinPoints){
            System.out.println("Round " + currRound + " winner -> " + robot + " (+" + robotScore + " pts.)");
            roundManager.addRound(new Round(currRound, robot, robotScore, draw));
        } else {
            roundManager.addRound(new Round(currRound, player, playerScore,robot, robotScore,draw));
        }
    }

    void drawCheck() {
        if (playerScore == robotScore && currRound == numOfRounds) {
            System.out.println("\nGame has officially been declared a draw! 🎰");
        }
    }

    void winSweepCheck() {
        if (playerWinPoints == numOfRounds) {
            System.out.println("\n⭐️" + player + " 🧹" + robot);
        } else if (robotWinPoints == numOfRounds) {
            System.out.println("\n" + robot + " 🧹" + player);
        }
    }

    void numberOfRoundsCheck() {
        if (numOfRounds < 1 || numOfRounds > 15) {
            System.out.println("rounds can only be between 1-15");
        }
        System.out.println((numOfRounds == 1) ? "Best of " + numOfRounds + " Round" :
                "Best of " + numOfRounds + " Rounds");
    }

    void declareWinner() {
        if (playerWinPoints > robotWinPoints) {
            System.out.println("\n" + player + " You win!\n");
        } else if (robotWinPoints > playerWinPoints) {
            System.out.println("\n" + robot + " wins!\n");
        } else {
            System.out.println("\nGame ended in a draw\n");
        }
    }

    void winDrawPoints() {
        System.out.println(player + " -> win pts: " + playerWinPoints + " -> "
                + "final SCORE: " + playerScore + " pts.");
        System.out.println(robot + " -> win pts: " + robotWinPoints + " -> "
                + "final SCORE: " + robotScore + " pts.");
        System.out.println("🎰DRAW pts: " + draw);
    }

    void printTrophy(String winner) {
        System.out.println("        ___________");
        System.out.println("       '._==_==_=_.'");
        System.out.println("       .-\\:      /-.");
        System.out.println("      | (|: WINNER :|) |");
        System.out.println("\t\t\t" + winner);
        System.out.println("       '-|:      |-'");
        System.out.println("         \\::.    /");
        System.out.println("          '::. .'");
        System.out.println("            ) (");
        System.out.println("          _.'   '._");
        System.out.println("        \"\"\"\"\"\"\"\"\"");
    }

}

