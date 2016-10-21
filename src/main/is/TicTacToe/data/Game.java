package is.TicTacToe;

import is.TicTacToe.data.Board;
import is.TicTacToe.data.Player;

public class Game {
    private Board board;
    private Player p1, p2;

    public Board getBoard() { return new Board(); }
    public Player getPlayer(String name) { return new Player(); }

    public boolean isDone() { return false; }
    public Player getWinner() { return new Player(); }
}
