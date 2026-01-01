void main() {

    Scanner scanner = new Scanner(System.in);

    boolean isRunning = true;

    RockPaperScissors rockPaperScissors = new RockPaperScissors();

    rockPaperScissors.rpsMsg();

    do {
        System.out.print("\nReady to play (y/n): ");
        String userPlay = scanner.nextLine().toLowerCase();

        if (userPlay.equals("y") || userPlay.equals("yes")) {
            rockPaperScissors.startGame();
        } else if (userPlay.equals("n") || userPlay.equals("no")) {
            System.out.println("take care! 👋🏽");
            isRunning = false;
        } else {
            System.out.println("invalid entry");
        }
    } while (isRunning);

}
