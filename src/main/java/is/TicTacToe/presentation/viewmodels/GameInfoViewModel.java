package is.TicTacToe.presentation.viewmodels;

/*
* View Model for the input from user
* before starting game.
* NOTE: the getters and setters
* need to be in Camel casing for the
* sprint framework to work!
*/
public class GameInfoViewModel {
    private String player1;
    private String player2;
    private int mode;
    private final int SIZE = 9;
    private String[] grid;

    public GameInfoViewModel() 
    {
        player1 = "";
        player2 = "";
        mode = 0;
        grid = new String[SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            grid[i] = "";
        }
    }

    public String getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(String player1)
    {
        this.player1 = player1;
    }

    public String getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(String player2)
    {
        this.player2 = player2;
    }

    public int getMode()
    {
        return mode;
    }

    public void setMode(int mode)
    {
        this.mode = mode;
    }

    public String[] getGrid()
    {
        return grid;
    }

    public void setGridSymbol(int index, String symbol)
    {
        grid[index] = symbol;
    }

    public void setGrid(String[] grid)
    {
        this.grid = grid;
    }
}