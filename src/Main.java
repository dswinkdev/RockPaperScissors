void main() {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    boolean isRunning = true;

    RockPaperScissors rockPaperScissors = new RockPaperScissors();

    rockPaperScissors.rpsMsg();

    do {
        System.out.print("\nReady to play (yes/no): ");
        String userPlay = scanner.nextLine().toLowerCase();

        System.out.print("enter player name: ");
        rockPaperScissors.player = rockPaperScissors.randomEmojis
                [random.nextInt(rockPaperScissors.randomEmojis.length)]
                + scanner.nextLine();

        if (userPlay.equals("y") || userPlay.equals("yes")) {
            rockPaperScissors.startGame();
            break;
        } else if (userPlay.equals("n") || userPlay.equals("no")) {
            System.out.println("take care! 👋🏽");
            isRunning = false;
        } else {
            System.out.println("invalid entry");
        }
    } while (isRunning);

}
