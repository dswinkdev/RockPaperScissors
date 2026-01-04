public class Round {

    private String roundWinner;
    private String roundLoser;
    private String drawWinner1;
    private String drawWinner2;
    private int roundWinnerPts;
    private int roundDraw;
    private int roundNum;
    private int drawWinner1Pts;
    private int drawWinner2Pts;
    private boolean isDrawRound;

    public Round() {
    }

    public Round(int roundNum, String roundWinner, int roundWinnerPts, int roundDraw) {
        this.roundNum = roundNum;
        this.roundWinner = roundWinner;
        this.roundWinnerPts = roundWinnerPts;
        this.roundDraw = roundDraw;
    }

    public Round(int roundNum, String drawWinner1, int drawWinner1Pts, String drawWinner2, int drawWinner2Pts, int roundDraw) {
        this.roundNum = roundNum;
        this.drawWinner1 = drawWinner1;
        this.drawWinner1Pts = drawWinner1Pts;
        this.drawWinner2 = drawWinner2;
        this.drawWinner2Pts = drawWinner2Pts;
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
                    "\nScore = " + roundWinnerPts + " pts." +
                    "\nDraw = " + roundDraw +
                    "\n--------------";
    }
}
