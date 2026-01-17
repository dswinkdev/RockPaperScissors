import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    RoundManager roundManager = new RoundManager();

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    DecimalFormat df = new DecimalFormat("#,###");

    String[] rps = {"🪨", "📃", "✂️"};

    // enumeration
    enum RoundResult {
        PLAYER,
        ROBOT,
        TIE
    }

    String[] robots = {
            "Terminator-X", "Axiom", "Orion", "Zenith", "Helix", "Vortex", "Sentinel", "Cypher", "Neutrino", "Atlas", "Omega-X",
            "Astro", "Nova", "Quantix", "Synapse", "Vertex", "Pulse", "Nexus", "Flux", "Echo", "Core",
            "Titan", "Aegis", "Bulwark", "Colossus", "Vanguard", "Praetor", "Rampart", "Phalanx", "Centurion", "Overseer",
            "RX-9", "MK-Z", "Unit-404", "AX-13", "Core-7", "NX-Prime", "Q-12", "Xeno-5", "Prothro-X", "Sentrix", "Java-99",
            "Alex 2K", "RainBot 3K", "Yura 4K"
    };

    String[] players = {
            "🧑‍🚀 Maverick", "🔥Blaze", "⚡️Ace", "🎯 Striker", "🌀 Phantom", "🧠 Nova",
            "🏹 Archer", "💥 Raptor", "🌟 Titan", "🎮 Shadow"
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
            "🧑🏽‍🚒", // tank / defender
            "👩🏿‍💻", // black girl coder
            "🧑🏽‍🔬", // scientist
            "🧑🏽‍🎮", // gamer
            "🧑🏽‍✈️", // pilot
            "🧑🏽‍🏭", // industrial / builder
            "🧑🏽‍⚖️", // judge / arbiter
            "🧑🏽‍🌾", // resource gatherer
            "🧑🏽‍🎨", // creative
            "🧑🏽‍🚓", // enforcer
            "🧑🏽‍🦯", // tactician / awareness
            "🧑🏽‍🛠️", // mechanic
            "🧑🏽‍🧠"  // strategist / AI mind
    };

    String[] worldEmojis = {"🌎", "🌍", "🌏"};

    String[] cities = {
            // United States
            "🇺🇸 New York, New York",
            "🇺🇸 Los Angeles, California",
            "🇺🇸 Chicago, Illinois",
            "🇺🇸 Houston, Texas",
            "🇺🇸 Miami, Florida",
            "🇺🇸 Atlanta, Georgia",
            "🇺🇸 Dallas, Texas",
            "🇺🇸 Austin, Texas",
            "🇺🇸 San Francisco, California",
            "🇺🇸 San Diego, California",
            "🇺🇸 Seattle, Washington",
            "🇺🇸 Denver, Colorado",
            "🇺🇸 Phoenix, Arizona",
            "🇺🇸 Las Vegas, Nevada",
            "🇺🇸 New Orleans, Louisiana",
            "🇺🇸 Nashville, Tennessee",
            "🇺🇸 Boston, Massachusetts",
            "🇺🇸 Washington, D.C.",
            "🇺🇸 Honolulu, Hawaii",
            "🇵🇷 San Juan, Puerto Rico",

            // Canada
            "🇨🇦 Toronto, Ontario",
            "🇨🇦 Vancouver, British Columbia",
            "🇨🇦 Montreal, Quebec",

            // Europe
            "🇬🇧 London, England",
            "🇫🇷 Paris, France",
            "🇩🇪 Berlin, Germany",
            "🇮🇹 Rome, Italy",
            "🇪🇸 Madrid, Spain",
            "🇬🇷 Athens, Greece",
            "🇮🇸 Reykjavík, Iceland",
            "🇳🇴 Oslo, Norway",
            "🇸🇪 Stockholm, Sweden",

            // Asia
            "🇯🇵 Tokyo, Japan",
            "🇯🇵 Kyoto, Japan",
            "🇯🇵 Osaka, Japan",
            "🇰🇷 Seoul, South Korea",
            "🇨🇳 Beijing, China",
            "🇨🇳 Shanghai, China",
            "🇮🇳 Mumbai, Maharashtra",
            "🇮🇳 Delhi, India",
            "🇮🇳 Bangalore, Karnataka",
            "🇹🇭 Bangkok, Thailand",
            "🇸🇬 Singapore",
            "🇲🇾 Kuala Lumpur, Malaysia",

            // Middle East
            "🇦🇪 Dubai, UAE",
            "🇦🇪 Abu Dhabi, UAE",
            "🇶🇦 Doha, Qatar",
            "🇹🇷 Istanbul, Turkey",

            // Africa
            "🇪🇬 Cairo, Egypt",
            "🇲🇦 Marrakech, Morocco",
            "🇿🇦 Cape Town, South Africa",
            "🇳🇬 Lagos, Nigeria",

            // South America
            "🇧🇷 Rio de Janeiro, Brazil",
            "🇧🇷 São Paulo, Brazil",
            "🇦🇷 Buenos Aires, Argentina",
            "🇵🇪 Lima, Peru",

            // Australia & Oceania
            "🇦🇺 Sydney, Australia",
            "🇦🇺 Melbourne, Australia",
            "🇳🇿 Auckland, New Zealand",

            // Natural / Regions
            "🌳 Amazon Rainforest",
            "🏜️ Sahara Desert",
            "🏔️ Himalayas",
            "❄️ Antarctica",

            // 🌀 Fictional / Battle World
            "🌀 Ironfall City, Ashen State",
            "🌀 Neo Valor, Titan Province",
            "🌀 Crimson Reach, Warbound Territory",
            "🌀 Obsidian Gate, Blackrock State",
            "🌀 Aether Haven, Skyreach Dominion",
            "🌀 Riftwatch, Fracture Zone",
            "🌀 Nova Bastion, Solar Expanse",
            "🌀 Valkyrie Spire, Stormhold State",
            "🌀 Hexforge City, Quantum Marches",
            "🌀 Last Stand, Endfall Region"
    };

    // names that can't be used
    String[] restrictedPlayerNames = {
            "cpu", "player", "human", "name", "person", "blank", "nobody"
    };

    String[] sponsors = {
            "sponsor1",
            "sponsor2",
            "sponsor3",
            "sponsor4",
            "sponsor5",
            "sponsor6",
            "sponsor7",
            "sponsor8"
    };

    String playerName = "";
    String player = "";
    String robot = "🤖" + robots[random.nextInt(robots.length)];
    String city = "";
    String noWinner = "❌";

    int currRound = 1;
    int playerWinPoints = 0;
    int robotWinPoints = 0;
    int numOfRounds = 0;
    final int numOfRoundsMax = 15;
    final int roundWinPts = 1250;
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
    int fans = random.nextInt(10000, 50001);
    int recordAttendance = random.nextInt(25000, 50001);
    int tieBreakerRounds = 0;

    boolean stillATie = true;

    void rpsMenu() {
        System.out.println("///////////////////");
        System.out.println("ROCK PAPER SCISSORS");
        System.out.println("🪨  vs  📄  vs  ✂️");
        System.out.println("///////////////////");
        System.out.println("⚡️ Powered by ⚡️\nDigiSwink Studios, LLC");
        System.out.println("--------------------------");
        System.out.println("©2026 All rights reserved.");
        System.out.println("--------------------------\n");
        System.out.println("Let's play... 🪨📄✂️\n");
        createPlayer();

        System.out.println("\n-------- MENU --------");
        System.out.println("press (1) -> Play Game");
        System.out.println("press (2) -> High Score");
        System.out.println("press (3) -> How To Play");
        System.out.println("press (4) -> Exit Game");
        System.out.println("----------------------");

        System.out.print("\nenter choice: ");
        int playerChoice = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        switch (playerChoice) {
            case 1 -> {
                System.out.println("\n⚔️Let the BATTLE begin...🪨📄✂️");
                playerMatchUp();
                playGame();
            }
            case 2 -> displayHighScore(playerScore, robotScore);
            case 3 -> howToPlay();
            case 4 -> {
                System.out.println("Exiting game... see ya later! 🐊");
                return;
            }
            default -> {
                System.out.println("invalid entry");
            }
        }
    }

    void battleLocation() {
        city = cities[random.nextInt(cities.length)];
        System.out.println(city);
    }

    void playerMatchUp() {
        System.out.println("\n----------- MATCHUP -----------");
        System.out.println(player + " (YOU) vs. " + robot + " (AI)");
        System.out.println("---------------⚔️--------------");
        battleLocation();
    }

    boolean isValidName = false;

    void createPlayer() {
        while (!isValidName) {
            System.out.print("enter player name: ");
            playerName = scanner.nextLine().trim();

            player = randomEmojis[random.nextInt(randomEmojis.length)] +
                    playerName;

            isValidName = true;

            for (String restrictedPlayerName : restrictedPlayerNames) {
                if (playerName.equalsIgnoreCase(restrictedPlayerName)) {
                    isValidName = false;
                    System.out.println("cannot use '" + restrictedPlayerName.toUpperCase() + "' as player name\n");
                }
            }
        }
    }

    void playGame() {
        System.out.print("\nenter # of rounds to play? (" + numOfRoundsMax + " max): ");
        numOfRounds = scanner.nextInt();

        numberOfRoundsCheck(numOfRounds); // checks number of rounds for min & max

        while (currRound <= numOfRounds) {
            System.out.println("\n- - - - ROUND " + currRound + " - - - -");
            System.out.print("enter (1) 🪨 (2) 📃 (3) ✂️: ");

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

    String[] roundOutcomes = {
            "📄covers 🪨",
            "🪨beats ✂️",
            "✂️cuts 📄",
            "🪨((tie)) 🪨️",
            "📄((tie)) 📄",
            "✂️((tie)) ✂️",
    };

    RoundResult checkWinner(int playerMove, int robotMove) {
        int result = (playerMove * 10 + robotMove);

        switch (result) {
            case 11, 22, 33 -> {
                System.out.println(player + " & " + robot + " have tied...");
                draw++;
                tieBreakerRounds++;
                tieBreaker(playerWinPoints, robotWinPoints);
                roundWinner(RoundResult.TIE);

                if (result == 11) {
                    System.out.println(roundOutcomes[3]);
                } else if (result == 22) {
                    System.out.println(roundOutcomes[4]);
                } else {
                    System.out.println(roundOutcomes[5]);
                }
                return RoundResult.TIE;
            }

            case 21, 13, 32 -> {
                System.out.println(player + " takes ROUND " + currRound);
                playerScore += roundWinPts;
                playerWinPoints++;
                playerTieBreakerPts++;
                roundWinner(RoundResult.PLAYER);

                System.out.print("[");
                if (result == 21) {
                    System.out.print(roundOutcomes[0]);
                } else if (result == 13) {
                    System.out.print(roundOutcomes[1]);
                } else {
                    System.out.print(roundOutcomes[2]);
                }
                System.out.print("]\n");
                return RoundResult.PLAYER;
            }

            case 12, 31, 23 -> {
                System.out.println(robot + " takes ROUND " + currRound);
                robotScore += roundWinPts;
                robotWinPoints++;
                robotTieBreakerPts++;
                roundWinner(RoundResult.ROBOT);

                System.out.print("[");
                if (result == 12) {
                    System.out.print(roundOutcomes[0]);
                } else if (result == 31) {
                    System.out.print(roundOutcomes[1]);
                } else {
                    System.out.print(roundOutcomes[2]);
                }
                System.out.print("]\n");
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
                roundManager.addRound(new Round(currRound, player, playerScore, draw));
            }
            case ROBOT -> {
                roundManager.addRound(new Round(currRound, robot, robotScore, draw));
            }
            case TIE -> {
                if (playerTieBreakerPts > robotTieBreakerPts) {
                    roundManager.addRound(new Round(currRound, player, playerScore, draw, tieBreakerRounds));
                } else if (robotTieBreakerPts > playerTieBreakerPts) {
                    roundManager.addRound(new Round(currRound, robot, robotScore, draw, tieBreakerRounds));
                } else {
                    roundManager.addRound(new Round(currRound, noWinner, noScore, draw, tieBreakerRounds));
                }
            }
        }
    }

    boolean stillInTieBreaker = true;

    void tieBreaker(int playerTieBreakerPts, int robotTieBreakerPts) {
        System.out.println("\n🏁  T I E   B R E A K E R  🏁");
        System.out.println("------------------------------------------");
        System.out.println("WIN   →  +" + doubleRoundPts + " pts  😆");
        System.out.println("LOSE  →  -" + doubleRoundPts + " pts  😒");
        System.out.println("------------------------------------------");
        System.out.println("The choice is yours 🫵🏽\n");

        System.out.print("enter choice: ");
        playerTieMove = scanner.nextInt();
        int robotTieMove = random.nextInt(1, 4);

        while (playerTieMove < 1 || playerTieMove > 3) {
            System.out.println("invalid move");
            System.out.print("enter choice: ");
            playerTieMove = scanner.nextInt();
            robotTieMove = random.nextInt(1, 4);
        }

        System.out.println("\n🏁 ROUND " + currRound + " TIE BREAKER RESULTS 🏁");
        System.out.println(player + " chose " + rps[playerTieMove - 1]);
        System.out.println(robot + " chose " + rps[robotTieMove - 1]);
        System.out.println("-------------------------");

        // check winner logic
        checkWinner(playerTieMove, robotTieMove);
        checkTieWinner();
        System.out.println("\nTie breaker has been broken....");
        stillInTieBreaker = false;
    }

    void checkTieWinner() {

        if (playerTieBreakerPts > robotTieBreakerPts) {

            playerScore += doubleRoundPts;
            robotScore  -= doubleRoundPts;

            System.out.println("\n🏆 TIE BREAKER RESULT 🏆");
            System.out.println(player + " wins the tie breaker!");
            System.out.println("+" + doubleRoundPts + " bonus points added");

            System.out.println("--------------------------------");

            System.out.println(robot + " loses the tie breaker");
            System.out.println("-" + doubleRoundPts + " bonus points reduced");

            printCurrentScore();

            stillATie = false;
            roundWinner(RoundResult.PLAYER);

        } else if (robotTieBreakerPts > playerTieBreakerPts) {

            robotScore  += doubleRoundPts;
            playerScore -= doubleRoundPts;

            System.out.println("\n🏆 TIE BREAKER RESULT 🏆");
            System.out.println(robot + " wins the tie breaker!");
            System.out.println("+" + doubleRoundPts + " bonus points added");

            System.out.println("--------------------------------");

            System.out.println(player + " loses the tie breaker");
            System.out.println("-" + doubleRoundPts + " bonus points reduced");

            printCurrentScore();

            stillATie = false;
            roundWinner(RoundResult.ROBOT);

        } else {

            tieBreakerRounds++;
            System.out.println("\n⚖️ Tie breaker still ongoing...");
            roundWinner(RoundResult.TIE);
        }
    }

    void printCurrentScore() {
        System.out.println("\n*** CURRENT SCORE ***");
        System.out.println(player + ": " + playerScore + " pts");
        System.out.println(robot + ": " + robotScore + " pts");
        System.out.println("*********************");
    }

    void roundTie(int playerWinPoints, int robotWinPoints) {
        if (playerWinPoints == robotWinPoints) {
            System.out.println("Round " + currRound + " -> tie");
            roundManager.addRound(new Round(currRound, noWinner, noScore, draw));
        }
    }

    void showContrastBar(int playerWins, int robotWins) {
        int total = playerWins + robotWins;

        if (total == 0) {
            System.out.println("📊 Win Percentage: No data yet");
            return;
        }

        int barLength = 30; // total bar width

        double playerPct = (double) playerWins / total;
        double robotPct = (double) robotWins / total;

        int playerFill = (int) Math.round(playerPct * barLength);
        int robotFill = barLength - playerFill;

        System.out.println("\n📊 Win Percentage");
        System.out.print(player + " ");

        // Player side
        for (int i = 0; i < playerFill; i++) {
            System.out.print("█");
        }

        // Robot side
        for (int i = 0; i < robotFill; i++) {
            System.out.print("░");
        }

        System.out.println(" " + robot);

        System.out.printf("        %.1f%%", playerPct * 100);
        System.out.printf("            %.1f%%%n", robotPct * 100);
    }

    void drawCheck() {
        if (playerScore == robotScore && currRound == numOfRounds) {
            System.out.println("\nGame has officially been declared a draw! 🎰");
        }
    }

    void resetGame(boolean startOver) {
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
        int fans = random.nextInt(10000, 50001);
        int recordAttendance = random.nextInt(25000, 50001);
        int tieBreakerRounds = 0;
        System.out.println("New game is available to play");
    }

    // sponsorship
    void showSponsors() {
        System.out.println("------------ Support Our Sponsors ------------");

        for (int i = 0; i < sponsors.length; i++) {
            System.out.print(sponsors[i]);

            // Print comma unless it's the last item on the line
            if ((i + 1) % 4 != 0 && i != sponsors.length - 1) {
                System.out.print(" | ");
            }

            // New line every 4 sponsors
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println("----------------------------------------------\n");
    }

    void calculateWinPercentage(int playerScore) {
        if (currRound <= 1) {
            System.out.println("Win Percentage: 0%");
            return;
        }

        double percentage = (double) playerScore / (currRound - 1) * 100;
        System.out.printf("Player Win Percentage: %.2f%%%n", percentage);
    }

    void winSweepCheck() {
        String[] ordinalSuffixes = {"st", "nd", "rd", "th"};
        String ordinal = "";

        if (numOfRounds == 1) {
            ordinal = ordinalSuffixes[0];
        } else if (numOfRounds == 2) {
            ordinal = ordinalSuffixes[1];
        } else if (numOfRounds == 3) {
            ordinal = ordinalSuffixes[2];
        } else {
            ordinal = ordinalSuffixes[3];
        }

        if (playerWinPoints == numOfRounds) {
            System.out.println("\n⭐️" + player + " 🧹sweeps 🧹" + robot + " in " + numOfRounds + ordinal + " round matchup");
        } else if (robotWinPoints == numOfRounds) {
            System.out.println("\n⭐" + robot + " 🧹sweeps 🧹" + player + " in " + numOfRounds + ordinal + " round matchup");
        }
    }

    // round check
    void numberOfRoundsCheck(int numOfRoundsMax) {
        while (numOfRounds < 1 || numOfRounds > 15) {
            System.out.println("rounds can only be between " + currRound + "-" + numOfRoundsMax);

            System.out.print("\nenter # of rounds to play? (" + numOfRoundsMax + " max): ");
            numOfRounds = scanner.nextInt();
            scanner.nextLine(); // consume new line
        }
        System.out.println("\n-------------------");
        System.out.println((numOfRounds == 1) ? "⭐️Best of " + numOfRounds + " Round⭐️" :
                "⭐️Best of " + numOfRounds + " Rounds⭐️");
        System.out.println("-------------------");
    }

    void declareWinner() {
        if (playerScore > robotScore) {
            System.out.println("\n⭐️ GAME WINNER: ⭐️ " + player);
            //winnerPlate(player);
        } else if (robotScore > playerScore) {
            System.out.println("\n⭐️ GAME WINNER: ⭐️ " + robot);
            //winnerPlate(robot);
        } else {
            System.out.println("\n🤝 GAME ENDS IN A TIE");
        }
    }

    void showWinPercentageBars(int playerWins, int robotWins) {
        int totalGames = playerWins + robotWins;

        if (totalGames == 0) {
            System.out.println("No games played yet.");
            return;
        }

        double playerPct = (double) playerWins / totalGames;
        double robotPct = (double) robotWins / totalGames;

        int barLength = 20;

        System.out.println("\n📊 Win Percentage");

        System.out.println(player);
        printBar(playerPct, barLength);

        System.out.println(robot);
        printBar(robotPct, barLength);
    }

    void printBar(double percentage, int barLength) {
        int filled = (int) (percentage * barLength);

        for (int i = 0; i < barLength; i++) {
            if (i < filled) {
                System.out.print("█");
            } else {
                System.out.print("░");
            }
        }
        System.out.printf("%.1f%%%n", percentage * 100);
    }


    void playerStar() {
        if (playerScore > robotScore) {
            System.out.print("✅ ");
        } else {
            System.out.print("❌ ");
        }
    }

    void robotStar() {
        if (robotScore > playerScore) {
            System.out.print("✅ ");
        } else {
            System.out.print("❌ ");
        }
    }

    void gamePlaySummary() {
        System.out.println(city);
        System.out.println((fans >= recordAttendance) ? "*RECORD ATTENDANCE*\n🏟️ " + df.format(fans) + " fans" : "🏟️ " + df.format(fans) + " fans");

        System.out.println("\n*** PLAYER ***");
        playerStar();
        System.out.println(player);
        System.out.println("**************");
        System.out.println("🏆 Win Pts : " + playerWinPoints);
        System.out.println("🎯 Score   : " + df.format(playerScore) + " pts.\n");

        System.out.println("*** ROBOT ***");
        robotStar();
        System.out.println(robot);
        System.out.println("*************");

        System.out.println("🏆 Win Pts : " + robotWinPoints);
        System.out.println("🎯 Score   : " + df.format(robotScore) + " pts.");

        System.out.println("\n🎰 Draws          : " + draw);
        System.out.println("🏁 Tie Breakers   : " + tieBreakerRounds);
        System.out.println("⚡️ Game Rounds    : " + (currRound - 1));

        // total # of rounds
        int totalAmountOfRounds = (tieBreakerRounds + currRound) - 1;
        System.out.println("🔔 Total Rounds   : " + totalAmountOfRounds);

        // win percentage
        showContrastBar(playerWinPoints,robotWinPoints);
    }

    void winnerPlate(String winner) {
        System.out.println("\n\t  🏆GAME WINNER 🏆");
        System.out.println("  ┌────────────────────┐");
        System.out.println("\t\t" + winner);
        System.out.println("  └────────────────────┘");
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

        gamePlaySummary();   // game play summary
        winSweepCheck();   // check for sweep
        declareWinner();   // announce winner

        System.out.println("══════════════════════════════════════════");
        System.out.println("🎉             GAME COMPLETE             🎉");
        System.out.println("══════════════════════════════════════════");
    }

    void howToPlay() {
        System.out.println("══════════════════════════════════════════");
        System.out.println("📘            HOW TO PLAY                📘");
        System.out.println("══════════════════════════════════════════");
        System.out.println("🎮 OBJECTIVE:");
        System.out.println("Defeat the robot by winning more rounds than it.\n");

        System.out.println("🕹️ CONTROLS:");
        System.out.println("Enter a number to make your move:");
        System.out.println("1 → 🪨 Rock");
        System.out.println("2 → 📃 Paper");
        System.out.println("3 → ✂️ Scissors\n");

        System.out.println("⚔️ GAME RULES:");
        System.out.println("• 🪨 Rock beats ✂️ Scissors");
        System.out.println("• ✂️ Scissors beats 📃 Paper");
        System.out.println("• 📃 Paper beats 🪨 Rock");
        System.out.println("• Same moves result in a tie\n");

        System.out.println("🏆 SCORING:");
        System.out.println("• Each round win = +" + roundWinPts + " points");
        System.out.println("• Wins are tracked per round");
        System.out.println("• Ties earn no points\n");

        System.out.println("📊 MATCH FORMAT:");
        System.out.println("• Choose between 1 and " + numOfRoundsMax + " rounds");
        System.out.println("• Highest total score wins the game");
        System.out.println("• A sweep occurs if one player wins every round\n");

        System.out.println("🎉 END OF GAME:");
        System.out.println("• Final scores are displayed on the scoreboard");
        System.out.println("• A trophy is awarded to the winner");
        System.out.println("• Games can end in a tie\n");

        System.out.println("══════════════════════════════════════════");
        System.out.println("Good luck — and may the odds be ever in your favor! 🍀");
        System.out.println("══════════════════════════════════════════\n");
    }

    void viewAllRobots() {
        System.out.println("<----- ROBOTS ----->");
        for (int i = 0; i < robots.length; i++) {
            System.out.println("(" + (i + 1) + ") " + robots[i]);
        }
    }

    void viewAllPlayers() {
        System.out.println("<----- PLAYERS ----->");
        for (int i = 0; i < players.length; i++) {
            System.out.println("(" + (i + 1) + ") " + players[i]);
        }
    }

    void viewAllCities() {
        System.out.println("<----- BATTLE LOCATIONS  ----->");
        for (int i = 0; i < cities.length; i++) {
            System.out.println("(" + (i + 1) + ") " + cities[i]);
        }
    }

    void viewAllWorldEmojis() {
        System.out.println("<----- WORLD EMOJIS  ----->");
        for (int i = 0; i < worldEmojis.length; i++) {
            System.out.println("(" + (i + 1) + ") " + worldEmojis[i]);
        }
    }
}



