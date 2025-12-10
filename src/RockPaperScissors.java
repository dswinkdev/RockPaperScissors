import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors extends Player {

    boolean stillRunning = true;

    int draw = 0;
    int playerWins = 0;
    int playerLosses = 0;
    int cpuWins = 0;
    int cpuLosses = 0;
    int gameRound = 0;

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public RockPaperScissors() {
    }

    public RockPaperScissors(String playerName, double playerWins, double playerLosses, double totalWinsLosses) {
        super(playerName, playerWins, playerLosses, totalWinsLosses);
    }

    String[] emojis = {"🚀", "👽", "💵", "⚡", "️⭐", "️👑", "⚔️"};
    //String[] emojiMoves = {"🪨","📃","✂️"};

    void menu() {
        System.out.println("- - - - - - - - - - - -");
        System.out.println("Rock🪨Paper📃Sci️ssors✂️");
        System.out.println("- - - - - - - - - - - -");

        System.out.println("press 1 -> How to Play");
        System.out.println("press 2 -> Create Player");
        System.out.println("press 3 -> Play Game");
        System.out.println("press 4 -> Exit");
    }

    void gamePlay() {

        HashMap<Integer, String> emojiMoves = new HashMap<>();
        emojiMoves.put(1, "🪨");
        emojiMoves.put(2, "📄");
        emojiMoves.put(3, "✂️");

        System.out.print("\nenter number (1-4): ");
        int userChoice = scanner.nextInt();

        while (true) {
            if (userChoice < 1 || userChoice > 4) {
                System.out.println("invalid entry");
            }

            switch (userChoice) {
                case 1 -> {
                    howToPlay();
                    System.out.print("\nready to play? (y/n): ");
                    String readyToPlay = scanner.next();

                    if (readyToPlay.equalsIgnoreCase("y") || readyToPlay.equalsIgnoreCase("yes")) {
                        createPlayer();

                        while (gameRound != 3) {
                            gameRound++; // counts number of games before determining winner
                            System.out.print("choose (1) -> 🪨 Rock (2) -> 📃 Paper (3) -> ✂️: ");
                            int userPick = scanner.nextInt();

                            while (userPick < 1 || userPick > 3) {
                                System.out.println("invalid entry");
                            }

                            int cpuPick = random.nextInt(1, 4);

                            switch (userPick) {
                                case 1 -> {
                                    // rock game logic
                                    if (emojiMoves.get(userPick).equals("🪨") && emojiMoves.get(cpuPick).equals("🪨")) {
                                        System.out.println("draw");
                                        draw++;
                                        System.out.println("You -> " + emojiMoves.get(userPick) + " | Cpu -> " + emojiMoves.get(cpuPick));
                                    } else if (emojiMoves.get(userPick).equals("🪨") && emojiMoves.get(cpuPick).equals("📃")) {
                                        System.out.println("paper covers rock");
                                        System.out.println("Cpu wins!");
                                        cpuWins++;
                                        playerLosses++;
                                        System.out.println("You -> " + emojiMoves.get(userPick) + " | Cpu -> " + emojiMoves.get(cpuPick));
                                    } else if (emojiMoves.get(userPick).equals("🪨") && emojiMoves.get(cpuPick).equals("✂️")) {
                                        System.out.println("rock beats scissors");
                                        System.out.println("You win!");
                                        playerWins++;
                                        cpuLosses++;
                                        System.out.println("You -> " + emojiMoves.get(userPick) + " | Cpu -> " + emojiMoves.get(cpuPick));
                                    }
                                }

                                case 2 -> {
                                    // paper game logic
                                    if (emojiMoves.get(userPick).equals("📃") && emojiMoves.get(cpuPick).equals("📃")) {
                                        System.out.println("draw");
                                        draw++;
                                    } else if (emojiMoves.get(userPick).equals("📃") && emojiMoves.get(cpuPick).equals("🪨")) {
                                        System.out.println("paper covers rock");
                                        System.out.println("You win!");
                                        playerWins++;
                                        cpuLosses++;
                                    } else if (emojiMoves.get(userPick).equals("📃") && emojiMoves.get(cpuPick).equals("✂️")) {
                                        System.out.println("scissors cut paper");
                                        System.out.println("You loss!");
                                        cpuWins++;
                                        playerLosses++;
                                    }
                                }

                                case 3 -> {
                                    // scissors game logic
                                    if (emojiMoves.get(userPick).equals("✂️") && emojiMoves.get(cpuPick).equals("✂️")) {
                                        System.out.println("draw");
                                        draw++;
                                    } else if (emojiMoves.get(userPick).equals("✂️") && emojiMoves.get(cpuPick).equals("🪨")) {
                                        System.out.println("rock beats scissors");
                                        System.out.println("Cpu wins!");
                                        cpuWins++;
                                        playerLosses++;
                                    } else if (emojiMoves.get(userPick).equals("✂️") && emojiMoves.get(cpuPick).equals("📃")) {
                                        System.out.println("scissors cut paper");
                                        System.out.println("You win!");
                                        playerWins++;
                                        cpuLosses++;
                                    }
                                }
                                default -> {
                                    System.out.println("invalid entry");
                                }
                            }
                        }
                    } else if (readyToPlay.equalsIgnoreCase("n") || readyToPlay.equalsIgnoreCase("no")) {
                        return;
                    } else {
                        System.out.println("invalid entry");
                    }
                }
            }
        }
    }

    void playGame() {
        menu();
        gamePlay();
    }

    void createPlayer() {

        String randomCharacter = emojis[random.nextInt(emojis.length)];
        System.out.println("\n<- - - " + randomCharacter + " Create Player " + randomCharacter + " - - ->");
        System.out.print("enter name: ");
        scanner.nextLine();
        String userName = scanner.nextLine();

        if (userName.length() > 15) {
            System.out.println("invalid username");
        } else {
            setPlayerName(userName);
            System.out.println(randomCharacter + " " + userName + " " + randomCharacter);


        }
    }

    void howToPlay() {
        System.out.println(
                "\nHow to Play:\n" +
                        "1. When prompted, enter rock, paper, or scissors.\n" +
                        "2. The computer will randomly choose its move.\n" +
                        "3. The program compares both choices and determines the winner:\n" +
                        "   - Rock beats Scissors\n" +
                        "   - Paper beats Rock\n" +
                        "   - Scissors beats Paper\n" +
                        "4. The result is displayed instantly, and you can play again or exit."
        );
    }

}
