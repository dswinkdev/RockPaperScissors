import java.text.DecimalFormat;
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
            "Alex 2K", "RainBot 3K", "Yura 4K", "AI5K", "Striper-770"
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

    String[] worldCities = {
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
    };

    // Famous Streets
    String[] famousStreets = {
            "🏙️ Main Street",
            "🎭 Broadway",
            "🗽 Fifth Avenue",
            "🎬 Hollywood Boulevard",
            "🌇 Sunset Boulevard",
            "🎷 Beale Street",
            "🎉 Bourbon Street",
            "🏬 Michigan Avenue",
            "🏛️ Pennsylvania Avenue",
            "💰 Wall Street",
            "💎 Rodeo Drive",
            "🌴 Ocean Drive",
            "🎰 Las Vegas Boulevard",
            "🍑 Peachtree Street",
            "🚋 Market Street",
            "🌀 Lombard Street",
            "🌄 Mulholland Drive",
            "🛣️ Colfax Avenue",
            "🏫 State Street",
            "✨ Magnificent Mile",
            "🏛️ Congress Avenue"
    };

    // fictional venues
    String[] fictionalVenues = {
            // 🌀 Fictional / Battle World Inspired by Texas & Atlanta Roads
            "🌀 Katy Crossing, Ironfall State",
            "🌀 Peachtree Bastion, Dawnspire Province",
            "🌀 Memorial Gate, Emberhold Territory",
            "🌀 Buford Pinnacle, Skyreach Marches",
            "🌀 Shepherd’s Hollow, Verdant Expanse",
            "🌀 Howell Creek, Tempest Vale",
            "🌀 Westheimer Spire, Shadowfen State",
            "🌀 Roswell Summit, Celestial Reach",
            "🌀 Beltline Harbor, Emberfall Dominion",
            "🌀 Eldridge Gardens, Moonmist Territory",
            "🌀 Springvale Falls, Sapphire Expanse",
            "🌀 Cobbwatch Keep, Starveil Province",
            "🌀 Mason Ridge, Stormspire Marches",
            "🌀 Brookhaven Crossing, Windspire Territory",
            "🌀 Richmond Hollow, Frostveil Fields",
            "🌀 Riverwood Bastion, Emberpeak Province",
            "🌀 I-85 Gate, Skyfall Dominion",
            "🌀 Loop Nine Spire, Crystalbrook Marches",
            "🌀 Peachtree Glade, Verdant Harbor",
            "🌀 Katy Mills Citadel, Sunpetal Vale"
    };

    // MLB
    String[] mlbVenues = {
            "⚾ Truist Park (Atlanta Braves)",
            "⚾ Minute Maid Park (Houston Astros)",
            "⚾ Dodger Stadium (Los Angeles Dodgers)",
            "⚾ Yankee Stadium (New York Yankees)",
            "⚾ Fenway Park (Boston Red Sox)",
            "⚾ Wrigley Field (Chicago Cubs)",
            "⚾ Oracle Park (San Francisco Giants)",
            "⚾ Petco Park (San Diego Padres)",
            "⚾ Busch Stadium (St. Louis Cardinals)",
            "⚾ Citi Field (New York Mets)",
            "⚾ Progressive Field (Cleveland Guardians)",
            "⚾ PNC Park (Pittsburgh Pirates)",
            "⚾ Comerica Park (Detroit Tigers)",
            "⚾ Coors Field (Colorado Rockies)",
            "⚾ T-Mobile Park (Seattle Mariners)",
            "⚾ Globe Life Field (Texas Rangers)",
            "⚾ American Family Field (Milwaukee Brewers)",
            "⚾ Kauffman Stadium (Kansas City Royals)",
            "⚾ Guaranteed Rate Field (Chicago White Sox)",
            "⚾ Nationals Park (Washington Nationals)",
            "⚾ Camden Yards (Baltimore Orioles)"
    };

    // NBA
    String[] nbaVenues = {
            "🏀 State Farm Arena (Atlanta Hawks)",
            "🏀 Toyota Center (Houston Rockets)",
            "🏀 Madison Square Garden (New York Knicks)",
            "🏀 Crypto.com Arena (Los Angeles Lakers)",
            "🏀 TD Garden (Boston Celtics)",
            "🏀 Chase Center (Golden State Warriors)",
            "🏀 United Center (Chicago Bulls)",
            "🏀 American Airlines Center (Dallas Mavericks)",
            "🏀 Footprint Center (Phoenix Suns)",
            "🏀 Kaseya Center (Miami Heat)",
            "🏀 Ball Arena (Denver Nuggets)",
            "🏀 Fiserv Forum (Milwaukee Bucks)",
            "🏀 Gainbridge Fieldhouse (Indiana Pacers)",
            "🏀 Wells Fargo Center (Philadelphia 76ers)",
            "🏀 Rocket Mortgage FieldHouse (Cleveland Cavaliers)",
            "🏀 Moda Center (Portland Trail Blazers)",
            "🏀 Scotiabank Arena (Toronto Raptors)",
            "🏀 Smoothie King Center (New Orleans Pelicans)",
            "🏀 Little Caesars Arena (Detroit Pistons)",
            "🏀 Paycom Center (Oklahoma City Thunder)",
            "🏀 Target Center (Minnesota Timberwolves)"
    };

    // NFL
    String[] nflVenues = {
            "🏈 Mercedes-Benz Stadium (Atlanta Falcons)",
            "🏈 NRG Stadium (Houston Texans)",
            "🏈 AT&T Stadium (Dallas Cowboys)",
            "🏈 Lambeau Field (Green Bay Packers)",
            "🏈 Arrowhead Stadium (Kansas City Chiefs)",
            "🏈 Levi’s Stadium (San Francisco 49ers)",
            "🏈 SoFi Stadium (Los Angeles Rams)",
            "🏈 Gillette Stadium (New England Patriots)",
            "🏈 Hard Rock Stadium (Miami Dolphins)",
            "🏈 Soldier Field (Chicago Bears)",
            "🏈 MetLife Stadium (New York Giants)",
            "🏈 MetLife Stadium (New York Jets)",
            "🏈 U.S. Bank Stadium (Minnesota Vikings)",
            "🏈 Lucas Oil Stadium (Indianapolis Colts)",
            "🏈 Paycor Stadium (Cincinnati Bengals)",
            "🏈 Heinz Field (Pittsburgh Steelers)",
            "🏈 M&T Bank Stadium (Baltimore Ravens)",
            "🏈 Lumen Field (Seattle Seahawks)",
            "🏈 Empower Field at Mile High (Denver Broncos)",
            "🏈 Allegiant Stadium (Las Vegas Raiders)",
            "🏈 State Farm Stadium (Arizona Cardinals)"
    };

    // APPLE
    String[] appleVenues = {
            "🖥️ MacBook Way",
            "🖥️ MacBook Pro Drive",
            "🖥️ Mac Studio Circle",
            "🖥️ iMac Avenue",
            "🖥️ iPad Air Road",
            "🖥️ iPad Pro Parkway",
            "🖥️ AirPods Alley",
            "🖥️ AirPods Max Lane",
            "🖥️ Apple Watch Way",
            "🖥️ Ultra Loop Boulevard",
            "🖥️ Vision Pro Drive",
            "🖥️ M-Series Avenue",
            "🖥️ Neural Engine Way",
            "🖥️ Retina Display Road",
            "🖥️ Liquid Retina Lane",
            "🖥️ Thunderbolt Pass",
            "🖥️ Magic Keyboard Court",
            "🖥️ Space Gray Street",
            "🖥️ Midnight Avenue",
            "🖥️ Aluminum Unibody Way",
            "🖥️ One More Thing Blvd"
    };

    String[] techVenues = {
            "💻 Silicon Arena",
            "🌐 Quantum Coliseum",
            "🧠 Neural Nexus Stadium",
            "⚙️ Circuit Core Park",
            "🖥️ Mainframe Dome",
            "📡 Data Stream Pavilion",
            "🔋 Power Grid Arena",
            "🛰️ Satellite Summit",
            "🔌 Voltage Field",
            "📊 Algorithm Amphitheater",
            "🧬 Binary Loop Grounds",
            "🛜 Fiber Optic Stadium",
            "🧪 Innovation Hub",
            "📱 Smart Systems Park",
            "🔐 Encryption Vault Arena",
            "🤖 Robotics Coliseum",
            "☁️ Cloud Compute Center",
            "🚀 Launchpad Arena",
            "🧩 Modular Systems Stadium",
            "⚡ Hyperlink Pavilion",
            "🧭 Digital Frontier Park",
    };

    // different locations for games 🛫
    String city = worldCities[random.nextInt(worldCities.length)];
    String mlb = mlbVenues[random.nextInt(mlbVenues.length)];
    String nba = nbaVenues[random.nextInt(nbaVenues.length)];
    String nfl = nflVenues[random.nextInt(nflVenues.length)];
    String apple = appleVenues[random.nextInt(appleVenues.length)];
    String tech = techVenues[random.nextInt(nflVenues.length)];
    String usStreet = famousStreets[random.nextInt(famousStreets.length)];
    String fictional = fictionalVenues[random.nextInt(fictionalVenues.length)];

    String[] battleLocations = {city, mlb, nba, nfl, apple, tech, usStreet, fictional};

    String venueForMatchup = battleLocations[random.nextInt(battleLocations.length)];

    // names that can't be used
    String[] restrictedPlayerNames = {
            "cpu", "player", "human", "name", "person", "blank", "nobody", "matchup", "game"
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
    String noWinner = "❌";

    int currRound = 1;
    int playerWinPoints = 0;
    int robotWinPoints = 0;
    int numOfRounds = 0;
    final int numOfRoundsMax = 15;
    final int roundWinPts = 500;
    final int doubleRoundPts = roundWinPts * 2;
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

    void playerMatchUp() {
        System.out.println("\n----------- MATCHUP -----------");
        System.out.println(player + " (YOU) vs. " + robot + " (AI)");
        System.out.println("---------------⚔️--------------");
        System.out.println(venueForMatchup);
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

    int resetNegativeScore(int score, String player) {
        if (score < 0) {
            score = 0;
            System.out.println("adjusting " + player + "'s score to 0");
        }
        return score;
    }

    void playGame() {
        System.out.print("\nenter # of rounds to play? (" + numOfRoundsMax + " max): ");
        numOfRounds = scanner.nextInt();
        scanner.nextLine(); // consume new line

        numberOfRoundsCheck(); // checks number of rounds for min & max

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
            // tie
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
            // player wins
            case 21, 13, 32 -> {
                System.out.println(player + " takes ROUND " + currRound);

                playerScore += roundWinPts;
                playerScore = resetNegativeScore(playerScore, player);

                playerWinPoints++;
                playerTieBreakerPts++;
                roundWinner(RoundResult.PLAYER);

                System.out.print("[");
                if (result == 21) System.out.print(roundOutcomes[0]);
                else if (result == 13) System.out.print(roundOutcomes[1]);
                else System.out.print(roundOutcomes[2]);
                System.out.print("]\n");

                return RoundResult.PLAYER;
            }
            // robot wins
            case 12, 31, 23 -> {
                System.out.println(robot + " takes ROUND " + currRound);

                robotScore += roundWinPts;
                robotScore = resetNegativeScore(robotScore, robot);

                robotWinPoints++;
                robotTieBreakerPts++;
                roundWinner(RoundResult.ROBOT);

                System.out.print("[");
                if (result == 12) System.out.print(roundOutcomes[0]);
                else if (result == 31) System.out.print(roundOutcomes[1]);
                else System.out.print(roundOutcomes[2]);
                System.out.print("]\n");

                return RoundResult.ROBOT;
            }
        }
        return RoundResult.TIE;
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
        System.out.println("WIN   →  +" + doubleRoundPts + " pts  🤑");
        //System.out.println("LOSE  →  -" + doubleRoundPts + " pts  😡");
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
            robotScore -= doubleRoundPts;

            // ✅ FIX: assign returned values
            playerScore = resetNegativeScore(playerScore, player);
            robotScore = resetNegativeScore(robotScore, robot);

            System.out.println("\n🏆 TIE BREAKER RESULT 🏆");
            System.out.println(player + " wins the tie breaker!");
            System.out.println("+" + doubleRoundPts + " bonus points added");

            printCurrentScore();
            stillATie = false;
            roundWinner(RoundResult.PLAYER);

        } else if (robotTieBreakerPts > playerTieBreakerPts) {

            robotScore += doubleRoundPts;
            playerScore -= doubleRoundPts;

            // ✅ FIX
            playerScore = resetNegativeScore(playerScore, player);
            robotScore = resetNegativeScore(robotScore, robot);

            System.out.println("\n🏆 TIE BREAKER RESULT 🏆");
            System.out.println(robot + " wins the tie breaker!");
            System.out.println("+" + doubleRoundPts + " bonus points added");

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

        playerScore = resetNegativeScore(playerScore, player);
        robotScore = resetNegativeScore(robotScore, robot);

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
        currRound = 1;
        playerWinPoints = 0;
        robotWinPoints = 0;
        numOfRounds = 0;
        playerScore = 0;
        robotScore = 0;
        draw = 0;
        playerTieBreakerPts = 0;
        robotTieBreakerPts = 0;
        tieBreakerRounds = 0;
        if (startOver) {
            System.out.println("resetting gameplay...");
        } else {
            System.out.println("Thanks for playing!👋🏽");
        }
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
    void numberOfRoundsCheck() {
        while (numOfRounds < 1 || numOfRounds > 15) {
            System.out.println("rounds can only be between " + currRound + "-" + numOfRoundsMax);

            System.out.print("\nenter # of rounds to play? (" + numOfRoundsMax + " max): ");
            numOfRounds = scanner.nextInt();
            scanner.nextLine(); // consume new line
        }
        System.out.println("\n-------------------");
        System.out.println((numOfRounds == 1) ? "⭐️Best of " + numOfRounds + " Round ⭐️" :
                "⭐️Best of " + numOfRounds + " Rounds ⭐️");
        System.out.println("-------------------");
    }

    void declareWinner() {
        if (playerScore > robotScore) {
            System.out.println("\n******* GAME WINNER *******");
            System.out.println("🎉⭐🎉️ " + player + "  🎉⭐🎉️");
            //winnerPlate(player);
        } else if (robotScore > playerScore) {
            System.out.println("\n******* GAME WINNER *******");
            System.out.println("🎉⭐🎉️️ " + robot + "  🎉⭐🎉️");
            //winnerPlate(robot);
        } else {
            System.out.println("\n******* NO WINNER *******");
            System.out.println("🤝 Game ends in a TIE");
        }
        //System.out.println("***************************");
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

        playerScore = resetNegativeScore(playerScore, player);
        robotScore = resetNegativeScore(robotScore, robot);

        System.out.println(venueForMatchup);
        System.out.println((fans >= recordAttendance)
                ? "*RECORD ATTENDANCE*\n🏟️ " + df.format(fans) + " fans"
                : "🏟️ " + df.format(fans) + " fans");

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

        System.out.println("\n*** MATCHUP BREAKDOWN ***");
        System.out.println("🎰 Draws          : " + draw);
        System.out.println("🏁 Tie Breakers   : " + tieBreakerRounds);
        System.out.println("⚡️ Game Rounds    : " + (currRound - 1));

        int totalAmountOfRounds = (tieBreakerRounds + currRound) - 1;
        int totalPointsScored = playerScore + robotScore;
        System.out.println("🔔 Total Rounds   : " + totalAmountOfRounds);
        System.out.println("💯 Total Points   : " + df.format(totalPointsScored));
        System.out.println("**************************");

        showContrastBar(playerWinPoints, robotWinPoints);
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
        System.out.println("✔️             GAME COMPLETE             ✔️");
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
        System.out.println("<----- RANDOM BATTLE LOCATIONS  ----->"); // picks one for each in array
        for (int i = 0; i < battleLocations.length; i++) {
            System.out.println("(" + (i + 1) + ") " + battleLocations[i]);
        }
    }

    void viewAllWorldEmojis() {
        System.out.println("<----- WORLD EMOJIS  ----->");
        for (int i = 0; i < worldEmojis.length; i++) {
            System.out.println("(" + (i + 1) + ") " + worldEmojis[i]);
        }
    }

    void viewRestrictedNames() {
        System.out.println("<----- RESTRICTED NAMES  ----->");
        for (int i = 0; i < restrictedPlayerNames.length; i++) {
            System.out.println("(" + (i + 1) + ") " + restrictedPlayerNames[i]);
        }
    }

    int venues = mlbVenues.length + nflVenues.length + nbaVenues.length +
            appleVenues.length + worldCities.length + techVenues.length +
            fictionalVenues.length + famousStreets.length + worldCities.length;


    void viewAllVenues() {
        System.out.println("<----- ALL BATTLE VENUES  ----->");
        for (int i = 0; i < mlbVenues.length; i++) {
            System.out.println("(" + (i + 1) + ") " + mlbVenues[i]);
        }
        System.out.println("-------------------");
        for (int i = 0; i < nbaVenues.length; i++) {
            System.out.println("(" + (i + 1) + ") " + nbaVenues[i]);
        }
        System.out.println("-------------------");
        for (int i = 0; i < nflVenues.length; i++) {
            System.out.println("(" + (i + 1) + ") " + nflVenues[i]);
        }
        System.out.println("-------------------");
        for (int i = 0; i < appleVenues.length; i++) {
            System.out.println("(" + (i + 1) + ") " + appleVenues[i]);
        }
        System.out.println("-------------------");
        for (int i = 0; i < techVenues.length; i++) {
            System.out.println("(" + (i + 1) + ") " + techVenues[i]);
        }
        System.out.println("-------------------");
        for (int i = 0; i < famousStreets.length; i++) {
            System.out.println("(" + (i + 1) + ") " + famousStreets[i]);
        }
        System.out.println("-------------------");
        for (int i = 0; i < worldCities.length; i++) {
            System.out.println("(" + (i + 1) + ") " + worldCities[i]);
        }
        System.out.println("-------------------");
        String randomWorldEmoji = worldEmojis[random.nextInt(worldEmojis.length)];
        System.out.println(randomWorldEmoji + venues + " total venues");
        System.out.println("-------------------");
    }
}



