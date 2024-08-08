public class TennisGame6 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame6(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String getScore(){
        if (player1Score == player2Score) {
            return tieScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return endGameScore();
        } else {
            return regularScore();
        }
    }

    // tie score
    private String tieScore() {
        return switch (player1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    // end-game score
    private String endGameScore() {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) {
            return "Advantage " + player1Name;
        } else if (scoreDifference == -1) {
            return "Advantage " + player2Name;
        } else if (scoreDifference >= 2) {
            return "Win for " + player1Name;
        } else {
            return "Win for " + player2Name;
        }
    }

    // regular score
    private String regularScore() {
        String score1 = regularScoreDescription(player1Score);
        String score2 = regularScoreDescription(player2Score);
        return score1 + "-" + score2;
    }

    private String regularScoreDescription(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Deuce";
        };
    }
}
