
public class TennisGame3 implements TennisGame {
    
    private int player2Points;
    private int player1Points;
    private String player1Name;
    private String player2Name;
    private static String[] PointsNames = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        boolean isGameOver = ((player1Points < 4 && player2Points < 4) && !(player1Points + player2Points == 6));
        if (isGameOver) {
            String score = PointsNames[player1Points];
            if (player1Points == player2Points) {
                return score + "-All";
            } else {
                return score + "-" + PointsNames[player2Points];

            }} else {
                if (player1Points == player2Points)
                    return "Deuce";
            }

            String leader;
            if (player1Points > player2Points) {
                leader = player1Name;
            } else {
                leader = player2Name;
            }

            boolean isAdvantage = (player1Points - player2Points) * (player1Points - player2Points) == 1;
            if (isAdvantage) {
                return "Advantage " + leader;
            } else {
                return "Win for " + leader;
            }
        }
    
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.player1Points++;
        else
            this.player2Points++;
    }

}
