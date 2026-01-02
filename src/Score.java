public class Score {

    private int playerWins;
    private int playerLosses;
    private int robotWins;
    private int robotLosses;
    private int draw;

    // constructor
    public Score(int playerWins, int playerLosses, int cpuWins, int cpuLosses){
        this.playerWins = playerWins;
        this.playerLosses = playerLosses;
        this.robotWins = cpuWins;
        this.robotLosses = cpuLosses;
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

    public int getRobotWins() {
        return robotWins;
    }

    public void setRobotWins(int robotWins) {
        this.robotWins = robotWins;
    }

    public int getRobotLosses() {
        return robotLosses;
    }

    public void setRobotLosses(int robotLosses) {
        this.robotLosses = robotLosses;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
