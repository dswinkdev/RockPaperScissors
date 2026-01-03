import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    Round round = new Round();
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


    String[] roundOutcomes = {"📄 covers 🪨", "🪨 beats ✂️", "✂️cuts 📄"};

    String player = "";
    String robot = robots[random.nextInt(robots.length)];
    String noWinner = "❌";

    String[] roundWinner = {player, robot, "tie"};

    int currRound = 1;
    int winPoint = 0;
    int numOfRounds = 3;
    int roundWinPts = 25;
    int playerScore = 0;
    int robotScore = 0;
    int draw = 0;
    int roundWin = 0;
    boolean isRoundWinner = false;

    void rpsMsg() {
        System.out.println("🪨  vs  📄  vs  ✂️");
        System.out.println("*******************");
        System.out.println("ROCK PAPER SCISSORS");
        System.out.println("*******************");
        System.out.println("Best of " + numOfRounds + " Match");
    }

    void gamePlayers() {
        System.out.println(player + " vs. " + robot);
    }

    void startGame() {
        gamePlayers();
        while (currRound <= numOfRounds) {
            System.out.println("\n- - - - ROUND " + currRound + " - - - -");
            System.out.print("enter 1| 🪨 rock 2| 📃 paper 3| ✂️ scissors: ");

            try {
                int robotMove = random.nextInt(1, 4);
                int playerMove = scanner.nextInt();

                if (playerMove < 1 || playerMove > 3) {
                    System.out.println("invalid entry (please choose a number between 1-3)");
                } else {
                    System.out.println("\n- - - - ROUND " + currRound + " Results - - - -");
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
                System.out.println("tie -> no winner in round " + currRound);
                roundWinner(playerScore, robotScore);
                roundManager.addRound(new Round(currRound, player, robot, draw));
            }
            // player wins
            case 21 -> {
                System.out.println(roundOutcomes[0] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                //playerScore += winPoint;
                roundWinner(playerScore, robotScore);
                roundManager.addRound(new Round(currRound, player, robot, draw));
            }
            case 13 -> {
                System.out.println(roundOutcomes[1] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                //playerScore += winPoint;
                roundWinner(playerScore, robotScore);
                roundManager.addRound(new Round(currRound, player, robot, draw));
            }
            case 32 -> {
                System.out.println(roundOutcomes[2] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                //playerScore += winPoint;
                roundWinner(playerScore, robotScore);
                roundManager.addRound(new Round(currRound, player, robot, draw));
            }

            // robot wins
            case 12 -> {
                System.out.println(roundOutcomes[0] + " -> " + robot + " takes round " + currRound);
                System.out.println("----------------------------------------");
                robotScore += roundWinPts;
                //robotScore += winPoint;
                roundWinner(playerScore, robotScore);
                roundManager.addRound(new Round(currRound, robot, player, draw));
            }
            case 31 -> {
                System.out.println(roundOutcomes[1] + " -> " + robot + " takes round " + currRound);
                System.out.println("----------------------------------------");
                robotScore += roundWinPts;
                //robotScore += winPoint;
                roundWinner(playerScore, robotScore);
                roundManager.addRound(new Round(currRound, robot, player, draw));
            }
            case 23 -> {
                System.out.println(roundOutcomes[2] + " -> " + robot + " takes round " + currRound);
                System.out.println("-----------------------------------------");
                robotScore += roundWinPts;
                //robotScore += winPoint;
                roundWinner(playerScore, robotScore);
                roundManager.addRound(new Round(currRound, robot, player, draw));
            }
            default -> {
                System.out.println("----------------------------------------");
                System.out.println("no winner determined yet... keep playing!");
            }
        }

        winSweepCheck();

        if (playerScore > robotScore && currRound == numOfRounds) {
            System.out.println("\nYou win!");
        } else if (robotScore > playerScore && currRound == numOfRounds) {
            System.out.println("\n" + robot + " wins!");
        } else {
            drawCheck(); // checks for game draw
        }
    }

    void scoreBoard() {

        System.out.println("\n- - - - - SCOREBOARD - - - - -");
        roundManager.viewAllRounds();
    }

    void roundWinner(int playerScore, int robotScore) {

        if (playerScore > robotScore) {
            System.out.println("Round " + currRound + " winner -> " + player + " (" + playerScore + "+ pts.)");
            roundManager.addRound(new Round(currRound, player, robot, draw));
        }

        if (robotScore > playerScore) {
            System.out.println("Round " + currRound + " winner -> " + robot + " (" + robotScore + "+ pts.)");
            roundManager.addRound(new Round(currRound, robot, player, draw));
        }

        if (robotScore == playerScore && currRound != numOfRounds) {
            draw++;
            roundManager.addRound(new Round(currRound, noWinner, noWinner, draw));
        }
    }

    void drawCheck() {
        if (playerScore == robotScore && currRound == numOfRounds) {
            System.out.println("\nGame has officially been declared a draw!");
        }
    }

    void winSweepCheck(){
        for (int i = 0; i < numOfRounds; i++){
            if (round.getRoundWinner().equals(player) && round.getRoundLoser().equals(robot)){
                System.out.println("SWEEP!!!🧹");
            } else if (round.getRoundWinner().equals(robot) && round.getRoundLoser().equals(player)){
                System.out.println("SWEEP!!!🧹");
            }
        }
    }
}
