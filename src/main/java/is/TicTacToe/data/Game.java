package is.TicTacToe.data;

import is.TicTacToe.data.Board;
import is.TicTacToe.data.Player;

public class Game {

    private Board board;
    private Player p1, p2;

    /**
    * Initialize new instance of Game class with params.
    * @param b Board
    * @param p1, Player 1
    * @param p2, Player 2
    */
    public Game(Board b, Player p1, Player p2)
    {
        this.board = b;
        this.p1 = p1;
        this.p2 = p2;
    }

    public Board GetBoard() 
    { 
        return board; 
    }
    
    /**
    * Get player with name 'name'.
    * @param name, Player name
    * @return Player
    */
    public Player GetPlayer(String name) 
    {
        if (p1.GetName() == name)
        {
            return p1;
        }
        else if (p2.GetName() == name)
        {
            return p2;
        }
        else 
        {
            return null;
        }
    }

    /**
    * Make a move from Player with playerName on cell x,y.
    * @param x the x coordinate on the board 
    * @param y the y coordinate on the board
    * @param playerName name of the player that is making the move
    */
    public void MakeMove(int x, int y, String playerName)
    {
        Player player = GetPlayer(playerName);
        if (player == null)
        {
            throw new IllegalArgumentException("Invalid Player Name!");
        }

        String symbol = player.GetSymbol();
        try 
        {
            board.SetSymbol(x, y, symbol);
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    /**
    * Checks if we have a winner (has three in a row).
    * @return boolean true if we have a winner, else false
    */
    public boolean IsDone() 
    { 
        return board.HasThreeInRow();
    }

    /**
    * Gets the symbol that occurs three times in a row.
    * @return the player with the corresponding symbol if the symbol is
    * not an empty string, null otherwise  
    */
    public Player GetWinner() 
    { 
        String symbol = board.getThreeInRowSymbol();
        if(symbol == "")
        {
            return null;
        }
        Player player = GetPlayerBySymbol(symbol);
        return player;
    }

    private Player GetPlayerBySymbol(String symbol)
    {
        if(p1.GetSymbol() == symbol)
        {
            return p1;
        }
        else if(p1.GetSymbol() == symbol)
        {
            return p2;
        }
        else
        {
            return null;
        }
    }
}
