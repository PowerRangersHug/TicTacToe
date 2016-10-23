package is.TicTacToe.data;

import is.TicTacToe.data.Board;
import is.TicTacToe.data.Player;

public class Game {
    private Board board;
    private Player p1, p2;

    public Game() 
    {
    	board = new Board();
    	p1 = new Player();
    	p2 = new Player();
    }

    public Board getBoard() { return board; }
    public Player getPlayer(String name) { return new Player(); }

    public boolean isDone() { return false; }
    public Player getWinner() { return new Player(); }
}
