import java.util.ArrayList;

public class ScoreBoardManager {

    private final ArrayList<MatchUp> matches;

    public ScoreBoardManager(){
        this.matches = new ArrayList<>();
    }

    void addMatch(MatchUp match){
        matches.add(match);
    }
}
