import java.util.ArrayList;

public class Scoreboard {

    private String roundWinner;

    public Scoreboard(String roundWinner){
        this.roundWinner = roundWinner;
    }

    public String getRoundWinner() {
        return roundWinner;
    }

    public void setRoundWinner(String roundWinner) {
        this.roundWinner = roundWinner;
    }
}
