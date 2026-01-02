import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    ScoreBoardManager scoreBoardManager = new ScoreBoardManager();

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

    String[] roundWinner = {player, robot, "tie"};

    int currRound = 1;
    int numOfRounds = 3;
    int roundWinPts = 25;
    int playerScore = 0;
    int robotScore = 0;
    int roundWin = 0;
    boolean isRoundWinner = false;


    void rpsMsg() {
        System.out.println("🪨  vs  📄  vs  ✂️");
        System.out.println("*******************");
        System.out.println("ROCK PAPER SCISSORS");
        System.out.println("*******************");
        System.out.println("Best of " + numOfRounds + " Rounds");
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

        int result = (playerMove * 10 + robotMove);

        // tie
        switch (result) {
            case 11, 22, 33 -> System.out.println("tie -> no winner in round " + currRound);

            // player wins
            case 21 -> {
                System.out.println(roundOutcomes[0] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                roundWinner(playerScore, robotScore);
            }
            case 13 -> {
                System.out.println(roundOutcomes[1] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                roundWinner(playerScore, robotScore);
            }
            case 32 -> {
                System.out.println(roundOutcomes[2] + " -> " + player + " takes round " + currRound);
                System.out.println("----------------------------------------");
                playerScore += roundWinPts;
                roundWinner(playerScore, robotScore);
            }

            // robot wins
            case 12 -> {
                System.out.println(roundOutcomes[0] + " -> " + robot + " takes round " + currRound);
                System.out.println("----------------------------------------");
                robotScore += roundWinPts;
                roundWinner(playerScore, robotScore);
            }
            case 31 -> {
                System.out.println(roundOutcomes[1] + " -> " + robot + " takes round " + currRound);
                System.out.println("----------------------------------------");
                robotScore += roundWinPts;
                roundWinner(playerScore, robotScore);
            }
            case 23 -> {
                System.out.println(roundOutcomes[2] + " -> " + robot + " takes round " + currRound);
                System.out.println("-----------------------------------------");
                robotScore += roundWinPts;
                roundWinner(playerScore, robotScore);
            }
            default -> {
                System.out.println("----------------------------------------");
                System.out.println("no winner determined yet... keep playing!");
                roundWinner(playerScore, robotScore);
            }
        }

            if (playerScore > robotScore && currRound == numOfRounds) {
                System.out.println("\nYou win!");
            } else if (robotScore > playerScore && currRound == numOfRounds) {
                System.out.println("\n" + robot + " wins!");
            }
            drawCheck(); // checks for game draw
        }

    void scoreBoard() {
        System.out.println("\n- - - - - SCOREBOARD - - - - -");
        for (int i = 1; i < currRound; i++) {

        System.out.println("Round " + i + " Winner -> " + player);


//            if (playerScore > robotScore && currRound != numOfRounds) {
//                System.out.println("Round " + i + " Winner -> " + player);
//            } else if (robotScore > playerScore && currRound != numOfRounds) {
//                System.out.println("Round " + i + " Winner -> " + player);
//            } else {
//                System.out.println("Round " + i + " Tie");
//            }
        }
    }

        void roundWinner( int playerScore, int robotScore){
            if (playerScore > robotScore) {
                System.out.println("Round " + currRound + " winner -> " + player + " (" + playerScore + "+ pts.)");
            } else {
                System.out.println("Round " + currRound + " winner -> " + robot + " (" + robotScore + "+ pts.)");
            }
        }

        void drawCheck() {
            if (playerScore == robotScore && currRound == numOfRounds) {
                System.out.println("\nGame has officially been declared a draw!");
            }
        }
    }
