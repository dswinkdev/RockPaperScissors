import java.util.ArrayList;

public class RoundManager {

    private ArrayList<Round> rounds;

    public RoundManager(){
        this.rounds = new ArrayList<>();
    }

    void addRound(Round round){
        rounds.add(round);
    }

    void viewAllRounds(){
        for (Round r : rounds){
            System.out.println(r.toString());
        }
    }
}
