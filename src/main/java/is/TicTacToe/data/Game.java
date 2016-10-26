package is.TicTacToe.data;

import is.TicTacToe.data.Board;
import is.TicTacToe.data.Player;

public class Game {

    private Board board;
    private Player p1, p2;

    /**
    * Initialize new instance of Game class with params
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
    * Get player with name 'name'
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
    * Make 
    * @param name, Player name
    * @return Player
    */
    public void MakeMove(int x, int y, String playerName)
    {
        Player player = GetPlayer(playerName);
        if (player == null)
        {
            throw new IllegalArgumentException("Invalid Player Name!");
        }

        String symbol = player.GetSymbol();
        System.out.println(symbol);
        try 
        {
            board.setSymbol(x, y, symbol);
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public boolean IsDone() 
    { 
        return board.hasThreeInRow();
    }

    public Player GetWinner() 
    { 
        return new Player(); 
    }
}
