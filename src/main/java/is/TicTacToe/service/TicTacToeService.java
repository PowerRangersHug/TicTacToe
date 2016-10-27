package is.TicTacToe.service;

import is.TicTacToe.data.Board;
import is.TicTacToe.data.Game;
import is.TicTacToe.data.Player;

public class TicTacToeService {
    private Game game;

    public TicTacToeService() 
    {
    	Player p1 = new Player("Player1" , "X");
        Player p2 = new Player("Player2" , "O");
        Board b = new Board();
        game = new Game(b , p1 , p2);
    }

    public TicTacToeService(String player1, String player2) 
    {
        Player p1 = new Player(player1, "X");
        Player p2 = new Player(player2 , "O");
        Board b = new Board();
        game = new Game(b , p1 , p2);
    }

    public void makeMove() {  }
    public void startGame() {  }

    public String getGameResult() { return ""; }
}
