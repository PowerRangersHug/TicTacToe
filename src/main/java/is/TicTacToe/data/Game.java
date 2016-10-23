package is.TicTacToe.data;

import is.TicTacToe.data.Board;
import is.TicTacToe.data.Player;

public class Game {
    private Board board;
    private Player p1, p2;

    public Game() 
    {
        board = new Board();
        p1 = new Player("Player1", "X");
        p2 = new Player("Player2", "O");
    }

    public Board GetBoard() { return board; }
    public Player GetPlayer(String name) { return new Player(); }

    public boolean IsDone() { return false; }
    public Player GetWinner() { return new Player(); }
}
