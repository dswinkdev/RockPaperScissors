public class Game extends Player{

    public Game(){}

    public Game(String playerName, double playerWins, double playerLosses, double totalWinsLosses) {
        super(playerName, playerWins, playerLosses, totalWinsLosses);
    }

    void menu(){
        System.out.println("*******************");
        System.out.println("Rock,Paper,Sci️ssors");
        System.out.println("\t🪨📃✂️");
        System.out.println("*******************");
    }
}
