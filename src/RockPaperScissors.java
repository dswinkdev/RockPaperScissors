import java.util.Scanner;

public class RockPaperScissors extends Player{
        boolean stillRunning = true;


        Scanner scanner = new Scanner(System.in);

        public RockPaperScissors(){}

        public RockPaperScissors(String playerName, double playerWins, double playerLosses, double totalWinsLosses) {
            super(playerName, playerWins, playerLosses, totalWinsLosses);
        }

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
                        System.out.print("ready to play? (y/n): ");
                        String readyToPlay = scanner.nextLine();

                        if (readyToPlay.equalsIgnoreCase("y") || readyToPlay.equalsIgnoreCase("yes")){
                            createPlayer();
                        } else if (readyToPlay.equalsIgnoreCase("n") || readyToPlay.equalsIgnoreCase("no")){
                            return;
                        } else {
                            System.out.println("invalid entry");
                        }
                    }
                }
            }
        }

        void createPlayer() {
            System.out.println("- - - 👽Create Player - - -");
            System.out.println("enter name: ");
            String userName = scanner.nextLine();

            while (true) {
                if (userName.isEmpty() || userName.length() > 15) {
                    System.out.println("invalid username");
                }

                System.out.println("👽" + userName);
                System.out.println("\nloading " + userName + "'s stats...");
                System.out.println(userName + ": W " + getPlayerWins() + " | L " + getPlayerLosses());
            }
        }

        void howToPlay() {
            System.out.println(
                    "How to Play:\n" +
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
