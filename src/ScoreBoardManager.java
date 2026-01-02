import java.util.ArrayList;

public class ScoreBoardManager {

    private ArrayList<Scoreboard> scores;

    public ScoreBoardManager(){
        this.scores = new ArrayList<>();
    }

    void addScore(Scoreboard score){
        scores.add(score);
    }
}
