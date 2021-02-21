
public class TennisGame3 implements TennisGame {
    
    private int player2Score;
    private int player1Score;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private String getListPoint(Integer playerScore){
        String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return points[playerScore];
    }

    private String draw(){
      return player1Score<3 ? getListPoint(player1Score)+ "-All" : "Deuce";
    }

    public Boolean isSimplePoint(){
        Boolean condition1= player1Score<4 && player2Score<4;
        Boolean condition2= player1Score!=player2Score;
        return condition1 && condition2;
    }

    private String  advantageOWin(String playerName){
       return Math.abs(player1Score - player2Score) == 1 ? "Advantage " + playerName : "Win for " + playerName;
    }



    public String getScore() {
        if (isSimplePoint())
            return getListPoint(player1Score) + "-" + getListPoint(player2Score);

        if(player1Score==player2Score)
            return draw();

        return player1Score>player2Score ? advantageOWin(player1Name): advantageOWin(player2Name);

        }


    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            this.player1Score += 1;
        else
            this.player2Score += 1;
    }

}
