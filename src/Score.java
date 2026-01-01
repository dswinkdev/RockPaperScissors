public class Score {

    private int playerWins;
    private int playerLosses;
    private int cpuWins;
    private int cpuLosses;
    private int draw;

    // constructor
    public Score(int playerWins, int playerLosses, int cpuWins, int cpuLosses){
        this.playerWins = playerWins;
        this.playerLosses = playerLosses;
        this.cpuWins = cpuWins;
        this.cpuLosses = cpuLosses;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public int getPlayerLosses() {
        return playerLosses;
    }

    public void setPlayerLosses(int playerLosses) {
        this.playerLosses = playerLosses;
    }

    public int getCpuWins() {
        return cpuWins;
    }

    public void setCpuWins(int cpuWins) {
        this.cpuWins = cpuWins;
    }

    public int getCpuLosses() {
        return cpuLosses;
    }

    public void setCpuLosses(int cpuLosses) {
        this.cpuLosses = cpuLosses;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
