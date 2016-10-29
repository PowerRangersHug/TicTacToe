package is.TicTacToe.presentation.viewmodels;

/*
* View Model for the input from user
* before starting game.
*/
public class ModeInfo {
    private String player1;
    private String player2;
    private int mode;

    public ModeInfo() 
    {
        player1 = "";
        player2 = "";
        mode = 0;
    }

    public String GetPlayer1()
    {
        return player1;
    }

    public void SetPlayer1(String player1)
    {
        this.player1 = player1;
    }

    public String GetPlayer2()
    {
        return player2;
    }

    public void SetPlayer2(String player2)
    {
        this.player2 = player2;
    }

    public int GetMode()
    {
        return mode;
    }

    public void SetMode(int mode)
    {
        this.mode = mode;
    }
}