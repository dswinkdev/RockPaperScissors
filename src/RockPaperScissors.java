import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    RoundManager roundManager = new RoundManager();

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String[] rps = {"🪨", "📃", "✂️"};

    enum RoundResult {
        PLAYER,
        ROBOT,
        TIE
    } // enumeration


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

    String player = players[random.nextInt(players.length)];
    String robot = robots[random.nextInt(robots.length)];
    String noWinner = "❌";

    int currRound = 1;
    int playerWinPoints = 0;
    int robotWinPoints = 0;
    int numOfRounds = 0;
    int numOfRoundsMax = 15;
    int roundWinPts = 25;
    int doubleRoundPts = roundWinPts * 2;
    int playerScore = 0;
    int robotScore = 0;
    int draw = 0;
    int noScore = 0;
    int playerHighScore = 0;
    int robotHighScore = 0;
    int playerTieBreakerPts = 0;
    int robotTieBreakerPts = 0;
    int playerTieMove = 0;

    void rpsMenu() {
        System.out.println("*******************");
        System.out.println("🪨  vs  📄  vs  ✂️");
        System.out.println("*******************");
        System.out.println("ROCK PAPER SCISSORS");
        System.out.println("*******************");
        System.out.println(" Swink 🌊Technology");

        System.out.println("\npress 1) -> Start Game");
        System.out.println("press 2) -> High Score");
        System.out.println("press 3) -> How To Play");
        System.out.println("press 4) -> Exit Game");

        System.out.print("\nenter choice: ");
        String playerChoice = scanner.nextLine();
    }

    void gamePlayers() {
        System.out.println(player + " vs. " + robot);
    }

    void startGame() {
        gamePlayers();

        System.out.print("\nHow many rounds do you want to play? (" + numOfRoundsMax + " max): ");
        numOfRounds = scanner.nextInt();

        numberOfRoundsCheck(); // checks number of rounds for min & max

        while (currRound <= numOfRounds) {
            System.out.println("\n- - - - ROUND " + currRound + " - - - -");
            System.out.print("enter 1 -> 🪨 rock 2 -> 📃 paper 3 -> ✂️ scissors: ");

            try {
                int robotMove = random.nextInt(1, 4);
                int playerMove = random.nextInt(1, 4);

                if (playerMove < 1 || playerMove > 3) {
                    System.out.println("invalid entry (please choose a number between 1-3)");
                } else {
                    System.out.println("\n\n- - - -🏁 ROUND " + currRound + " RESULTS 🏁- - - -");
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

    RoundResult checkWinner(int playerMove, int robotMove) {
        int result = (playerMove * 10 + robotMove);

        switch (result) {
            case 11, 22, 33 -> {
                draw++;
                //System.out.println("tie -> no winner in ROUND " + currRound);
                roundWinner(RoundResult.TIE);
                playerTieBreakerPts++;
                robotTieBreakerPts++;
                tieBreaker();
                return RoundResult.TIE;
            }

            case 21, 13, 32 -> {
                System.out.println(player + " takes ROUND " + currRound);
                playerScore += roundWinPts;
                playerWinPoints++;
                roundWinner(RoundResult.PLAYER);
                return RoundResult.PLAYER;
            }

            case 12, 31, 23 -> {
                System.out.println(robot + " takes ROUND " + currRound);
                robotScore += roundWinPts;
                robotWinPoints++;
                roundWinner(RoundResult.ROBOT);
                return RoundResult.ROBOT;
            }

            default -> {
                return RoundResult.TIE;
            }
        }
    }

    void roundWinner(RoundResult result) {
        switch (result) {
            case PLAYER -> {
                System.out.println("Round " + currRound + " winner -> " + player);
                roundManager.addRound(new Round(currRound, player, playerScore, draw));
            }
            case ROBOT -> {
                System.out.println("Round " + currRound + " winner -> " + robot);
                roundManager.addRound(new Round(currRound, robot, robotScore, draw));
            }
            case TIE -> {
                System.out.println("Round " + currRound + " -> tie");
                roundManager.addRound(new Round(currRound, noWinner, noScore, draw));
            }
        }
    }

    void tieBreaker(){
        RoundResult tie = RoundResult.TIE;
        System.out.println("\n*********** T I E  B R E A K E R ***********");
        System.out.println("\nYou have entered into a TIE BREAKER...");
        System.out.println("Win and take advantage of double the points 😆");
        System.out.println("Lose and lose double the points 😒");
        System.out.println("The choice is yours 🫵🏽\n");

        System.out.print("enter choice: ");
        playerTieMove = scanner.nextInt();
        int robotTieMove = random.nextInt(1,4);

        while (playerTieMove < 1 || playerTieMove > 3 || robotTieMove < 1 || robotTieMove > 3){
            System.out.println("invalid move");
        }

        System.out.println("\n\n- - - -🏁 ROUND " + currRound + " TIE BREAKER RESULTS 🏁- - - -");
        System.out.println(player + " chose " + rps[playerTieMove - 1]);
        System.out.println(robot + " chose " + rps[robotTieMove - 1]);
        System.out.println("----------------------------------------");

        boolean notATie = true;

        while (notATie){
            if (playerTieBreakerPts > robotTieBreakerPts){
                playerScore += doubleRoundPts;
                robotScore -= doubleRoundPts;
                System.out.println(player + " wins tie breaker");
                System.out.println("points added: " + playerScore);
                System.out.println("points lost: " + robotScore);
                notATie = false;
                roundWinner(RoundResult.PLAYER);
            } else if (robotTieBreakerPts > playerTieBreakerPts){
                robotScore += doubleRoundPts;
                playerScore -= doubleRoundPts;
                System.out.println(robot + " wins tie breaker");
                System.out.println("points added: " + robotScore);
                System.out.println("points lost: " + playerScore);
                notATie = false;
                roundWinner(RoundResult.ROBOT);
            } else {
                System.out.println("Tie breaker still going....");
                notATie = false;
            }
        }
    }

    void roundTie(int playerWinPoints, int robotWinPoints){
        if (playerWinPoints == robotWinPoints){
            System.out.println("Round " + currRound + " -> tie");
            roundManager.addRound(new Round(currRound, noWinner, noScore, draw));
        }
    }

    void drawCheck() {
        if (playerScore == robotScore && currRound == numOfRounds) {
            System.out.println("\nGame has officially been declared a draw! 🎰");
        }
    }

    void winSweepCheck() {
        if (playerWinPoints == numOfRounds) {
            System.out.println("\n⭐️" + player + " 🧹sweeps 🧹" + robot + " in " + numOfRounds + " round matchup");
        } else if (robotWinPoints == numOfRounds) {
            System.out.println("\n⭐" + robot + " 🧹sweeps 🧹" + player + " in " + numOfRounds + " round matchup");
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
            if (playerScore > robotScore) {
                System.out.println("\n🏆 GAME WINNER: " + player);
            } else if (robotScore > playerScore) {
                System.out.println("\n🏆 GAME WINNER: " + robot);
            } else {
                System.out.println("\n🤝 GAME ENDS IN A TIE");
            }
        }


        void winDrawPoints() {
        System.out.println("*** PLAYER ***");
        System.out.println(player);
        System.out.println("🏆 Win Pts : " + playerWinPoints);
        System.out.println("🎯 Score   : " + playerScore + " pts.\n");

        System.out.println("*** ROBOT ***");
        System.out.println(robot);
        System.out.println("🏆 Win Pts : " + robotWinPoints);
        System.out.println("🎯 Score   : " + robotScore + " pts.");

        System.out.println("\n🎰 Draws   : " + draw);
    }


    void printTrophy(String winner, String loser) {
        System.out.println("         ╔══════════╗");
        System.out.println("         ║ " + winner);
        System.out.println("         ╚══════════╝");
        System.out.println("             ││");
        System.out.println("          🏆WINNER 🏆");
        System.out.println("          ❌LOSER ❌");
        System.out.println("             ││");
        System.out.println("         ╔══════════╗");
        System.out.println("         ║ " + loser);
        System.out.println("         ╚══════════╝\n");
    }

    void displayHighScore(int playerScore, int robotScore) {
        playerHighScore += playerScore;
        robotHighScore += robotScore;

        System.out.println("════════════════════════════════════════");
        System.out.println("👾             HIGH SCORE             👾");
        System.out.println("════════════════════════════════════════");
        System.out.println(player);
        System.out.println(playerHighScore + " pts.");
        System.out.println("- - - - -");
        System.out.println(robot);
        System.out.println(robotHighScore + " pts.");
    }

    void scoreBoard() {
        System.out.println();
        System.out.println("══════════════════════════════════════════");
        System.out.println("🏁        OFFICIAL GAME SCOREBOARD       🏁");
        System.out.println("══════════════════════════════════════════");

        roundManager.viewAllRounds(); // view each round's outcome

        System.out.println("──────────────────────────────────────────");
        System.out.println("📊           GAMEPLAY SUMMARY           📊");
        System.out.println("──────────────────────────────────────────");

        winDrawPoints();   // calculate win points
        winSweepCheck();   // check for sweep
        declareWinner();   // announce winner

        System.out.println("══════════════════════════════════════════");
        System.out.println("🎉             GAME COMPLETE             🎉");
        System.out.println("══════════════════════════════════════════\n");
    }
}



