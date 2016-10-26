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

    public Board GetBoard() { return board; }
    
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

    public boolean IsDone() { return false; }
    public Player GetWinner() { return new Player(); }
}
