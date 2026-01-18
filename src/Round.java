public class Round {

    private String roundWinner;
    private String roundLoser;
    private String drawWinner1;
    private String drawWinner2;
    private int roundWinnerPts;
    private int roundDraw;
    private int roundNum;
    private int roundTie;

    public Round() {
    }

    public Round(int roundNum, String roundWinner, int roundWinnerPts, int roundDraw) {
        this.roundNum = roundNum;
        this.roundWinner = roundWinner;
        this.roundWinnerPts = roundWinnerPts;
        this.roundDraw = roundDraw;
    }

    public Round(int roundNum, String roundWinner, int roundWinnerPts, int roundDraw, int roundTie) {
        this.roundNum = roundNum;
        this.roundWinner = roundWinner;
        this.roundWinnerPts = roundWinnerPts;
        this.roundDraw = roundDraw;
        this.roundTie = roundTie;
    }

    public String getRoundWinner() {
        return roundWinner;
    }

    public String getRoundLoser() {
        return roundLoser;
    }

    RockPaperScissors rockPaperScissors = new RockPaperScissors();

    @Override
    public String toString() {
        if (roundDraw == 0 && roundTie == 0) {
            return "Round " + roundNum +
                    "\nWinner = " + roundWinner +
                    "\nScore = " + roundWinnerPts + " pts." +
                    "\n--------------";
        } else if (roundDraw > 0 && roundTie == 0) {
            return "Round " + roundNum +
                    "\nWinner = " + roundWinner +
                    "\nScore = " + roundWinnerPts + " pts." +
                    "\nDraw = " + roundDraw +
                    "\n--------------";
        } else {
            return "Round " + roundNum +
                    "\nWinner = " + roundWinner +
                    "\nScore = " + roundWinnerPts + " pts." +
                    "\nDraw = " + roundDraw +
                    "\nTie Breaker = " + roundTie +
                    "\n--------------";
        }
    }
}
