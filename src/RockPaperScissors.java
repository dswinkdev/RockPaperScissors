import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors extends Player{

    boolean stillRunning = true;

    int draw = 0;
    int playerWins = 0;
    int playerLosses = 0;
    int cpuWins = 0;
    int cpuLosses = 0;
    int gameRound = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        public RockPaperScissors(){}

        public RockPaperScissors(String playerName, double playerWins, double playerLosses, double totalWinsLosses) {
            super(playerName, playerWins, playerLosses, totalWinsLosses);
        }

        String[] emojis = {"🚀","👽","💵","👀","⚡","️⭐","️👑","⚔️"};
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

        void playGame() {
            HashMap<Integer,String> emojiMoves = new HashMap<>();
            emojiMoves.put(1,"🪨");
            emojiMoves.put(2,"📄");
            emojiMoves.put(3,"✂️");

            while (stillRunning) {
                menu();

                System.out.print("\nenter number (1-4): ");
                int userChoice = scanner.nextInt();

                if (userChoice < 1 || userChoice > 4) {
                    System.out.println("invalid entry");
                }

                switch (userChoice) {
                    case 1 -> {
                        howToPlay();
                        System.out.print("\nready to play? (y/n): ");
                        String readyToPlay = scanner.next();

                        if (readyToPlay.equalsIgnoreCase("y") || readyToPlay.equalsIgnoreCase("yes")){
                            createPlayer();
                            gameRound++; // counts number of games before determining winner

                            while (gameRound != 3) {
                                System.out.print("choose (1) -> 🪨 Rock (2) -> 📃 Paper (3) -> ✂️: ");
                            int userPick = scanner.nextInt();

                            if (userPick < 1 || userPick > 3){
                                System.out.println("invalid entry");
                            } else {

                                    int cpuPick = random.nextInt(1, 4);

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

                            }
                        } else if (readyToPlay.equalsIgnoreCase("n") || readyToPlay.equalsIgnoreCase("no")){
                        return;
                        } else {
                            System.out.println("invalid entry");
                        }
                    }
                    case 2 -> createPlayer();
                    case 3 -> playGame();
                    case 4 -> {
                        System.out.println("exiting game...");
                        return;
                    }
                }
            }
        }

        void createPlayer() {
            System.out.println("\n- - - 👽Create Player - - -");
            System.out.print("enter name: ");
            scanner.nextLine();
            String userName = scanner.nextLine();

                if (userName.length() < 3 || userName.length() > 15) {
                    System.out.println("invalid username");
                } else {
                    setPlayerName(userName);
                    System.out.println("👽" + userName);


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
