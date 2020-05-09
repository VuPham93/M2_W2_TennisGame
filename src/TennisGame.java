public class TennisGame {
    private static final int SCORE_LOVE = 0;
    private static final int SCORE_FIFTEEN = 1;
    private static final int SCORE_THIRTY = 2;
    private static final int SCORE_FORTY = 3;
    private static final int PLAYER1_GET_ADVANTAGE = 1;
    private static final int PLAYER2_GET_ADVANTAGE = -1;
    private static final int PLAYER1_WIN = 2;
    private static final int PLAYER2_WIN = -2;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String result = "";

        if (player1Score >= 4 || player2Score >= 4) {
            result =  checkWin(player1Score, player2Score);
        }
        else if (player1Score == player2Score) {
            result = setScoreForBothPlayer(player1Score);
        }
        else {
            result = setScore(player1Score, player2Score);
        }
        return result;
    }

    private static String checkWin(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        String turnResult;

        if (minusResult == PLAYER1_GET_ADVANTAGE)
            turnResult = "Advantage player1";
        else if (minusResult == PLAYER2_GET_ADVANTAGE)
            turnResult = "Advantage player2";
        else if (minusResult >= PLAYER1_WIN)
            turnResult = "Win for player1";
        else if (minusResult <= PLAYER2_WIN)
            turnResult = "Win for player2";
        else
            turnResult = "Deuce";
        return turnResult;
    }

    private static String setScoreForBothPlayer(int score) {
        return displayScore(score) + "-All";
    }

    private static String setScore(int player1Score, int player2Score) {
        return displayScore(player1Score) + "-" + displayScore(player2Score);
    }

    private static String displayScore(int score) {
        String scoreDisplay = "";
        switch (score) {
            case SCORE_LOVE:
                scoreDisplay = "Love";
                break;
            case SCORE_FIFTEEN:
                scoreDisplay = "Fifteen";
                break;
            case SCORE_THIRTY:
                scoreDisplay = "Thirty";
                break;
            case SCORE_FORTY:
                scoreDisplay = "Forty";
                break;
            default:
                break;
        }
        return scoreDisplay;
    }
}
