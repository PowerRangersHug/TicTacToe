package is.TicTacToe.service;

import is.TicTacToe.data.Game;
import is.TicTacToe.data.Player;
import is.TicTacToe.data.Board;

public class TicTacToeService {
    private Game game;
    private String playerOne;
    private String playerTwo;

    /**
     * Initialize the service class with default values for Player instances.
     */
    public TicTacToeService()
    {
        playerOne = "Player1";
        playerTwo = "Player2";
        Player p1 = new Player(playerOne , "X");
        Player p2 = new Player(playerTwo , "O");
        Board b = new Board();
        game = new Game(b, p1, p2);
    }

    /**
     * Initialize the service class with customized names for Player instances.
     * @param player1 Player 1 name
     * @param player2 Player 2 name
     */
    public TicTacToeService(String player1, String player2)
    {
        playerOne = player1;
        playerTwo = player2;
        Player p1 = new Player(playerOne, "X");
        Player p2 = new Player(playerTwo, "O");
        Board b = new Board();
        game = new Game(b, p1, p2);
    }

    public void MakeMove() {  }

    /**
     * Start a game in the specified mode, with the specified player names.
     * @param mode Which mode will be played; Human vs. Human,
     * Human vs. Computer or Computer vs. Computer
     * @param p1Name Player 1 name
     * @param p2Name Player 2 name
     */
    public void StartGame(int mode, String p1Name, String p2Name)
    {
        SetPlayerNames(p1Name, p2Name);
    }

    /**
     * Get the game result.
     * @return Game result in String format
     */
    public String GetGameResult() { return ""; }

    /**
     * Change the current games' Player names.
     * @param p1 Player 1 name
     * @param p2 Player 2 name
     */
    public void SetPlayerNames(String p1, String p2)
    {
        if(!p1.isEmpty())
        {
            GetPlayerByName(playerOne).SetName(p1);
            playerOne = p1;
        }
        if(!p2.isEmpty())
        {
            GetPlayerByName(playerTwo).SetName(p2);
            playerTwo = p2;
        }
    }

    /**
     * Find a Player currently playing with the name stored in pName.
     * @param pName Name of the player to find
     * @return Player instance that has the specififed name, if the player is
     * found. If a Player isn't found null is returned.
     */
    public Player GetPlayerByName(String pName)
    {
        return game.GetPlayer(pName);
    }

    /**
     * Get a String representation of the current game board.
     * @return String representation of the game board
     */
    public String GetBoard()
    {
        return "";
    }
}
