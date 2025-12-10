public class Player {

    private String playerName;
    private double playerWins;
    private double playerLosses;
    private double totalWinsLosses;

    public Player(){}

    public Player(String playerName, double playerWins, double playerLosses, double totalWinsLosses){
        this.playerName = playerName;
        this.playerWins = playerWins;
        this.playerLosses = playerLosses;
        this.totalWinsLosses = totalWinsLosses;
    }

    double calculatePlayerWinLossPercentage(double playerWins, double playerLosses) {
        return 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public double getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(double playerWins) {
        this.playerWins = playerWins;
    }

    public double getPlayerLosses() {
        return playerLosses;
    }

    public void setPlayerLosses(double playerLosses) {
        this.playerLosses = playerLosses;
    }

    public double getTotalWinsLosses() {
        return totalWinsLosses;
    }

    public void setTotalWinsLosses(double totalWinsLosses) {
        this.totalWinsLosses = totalWinsLosses;
    }
}
