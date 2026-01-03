public class Round {

    private String roundWinner;
    private String roundLoser;
    private int roundDraw;
    private int roundNum;

    public Round(){}

    public Round(int roundNum, String roundWinner, String roundLoser, int roundDraw){
        this.roundNum = roundNum;
        this.roundWinner = roundWinner;
        this.roundLoser = roundLoser;
        this.roundDraw = roundDraw;
    }

    public String getRoundWinner() {
        return roundWinner;
    }

    public String getRoundLoser() {
        return roundLoser;
    }

    @Override
    public String toString() {
        return "Round " + roundNum +
                "\nWinner = " + roundWinner +
                "\nLoser = " + roundLoser +
                "\nDraw = " + roundDraw +
                "\n--------------";
    }
}
