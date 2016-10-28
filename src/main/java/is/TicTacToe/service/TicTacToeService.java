package is.TicTacToe.service;

import is.TicTacToe.data.Board;
import is.TicTacToe.data.Game;
import is.TicTacToe.data.Player;

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

    /**
    * Gets the game
    * @return game the instance of the game.
    */
    public Game GetGame()
    {
        return game;
    }

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
    * Puts the symbol belogning to player with name 'playerName'
    * on cell [x][y] on the board.
    * @param x the x coordinate on the board
    * @param y the y coordinate on the board
    * @param playerName name of the player that is making a move
    * @return true if playerName is valid and 
    * board[x][y] does not contain a symbol yet, else false
    */
    public boolean MakeMove(int x, int y, String playerName)
    {        
        String symbol = " ";
        if (playerName == playerOne || playerName == playerTwo)
        {
            symbol = GetPlayerByName(playerName).GetSymbol();
        }
        else 
        {
            return false;
        }
        
        if (!ContainsSymbol(x,y))
        {
            game.MakeMove(x, y, symbol);
            return true;
        
        }
        return false;
    }

    /**
    * Checks if a certain cell on the board has a symbol.
    * @param x the x coordinate on the board
    * @param y the y coordinate on the board
    * @return true if cell (x,y) on the board does
    * not have a symbol, else false
    */
    public boolean ContainsSymbol(int x, int y)
    {
        return (!game.GetBoard().GetSymbol(x,y).equals(" "));
    }

    /**
    * Checks if input from user is a valid coordinate
    * @param co input coordinate on the board from user
    * @return true if coordinate is valid, else false
    */
    public boolean LegalCoordinate(int co)
    {
        return (co <3) && (co >= 0);
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
        String board = GetTopBottomRow();
        for(int i = 0; i < 3; i++)
        {
            board += GetBoardRow(i);
            if(i < 2)
            {
                board += GetRowSep();
            }
        }
        board += GetTopBottomRow();
        return board;
    }

    /**
     * Get String representation of board row.
     * @param row Row that should be returned
     * @return String representation of requested row
     */
    private String GetBoardRow(int row)
    {
        Board b = game.GetBoard();
        return "| "
            + b.GetSymbol(0, row) + " | "
            + b.GetSymbol(1, row) + " | "
            + b.GetSymbol(2, row) + " |\n";
    }

    /**
     * Returns a row seperator for board representation.
     * @return String representation of Board row seperator
     */
    private String GetRowSep()
    {
        return "|---+---+---|\n";
    }

    /**
     * Get the top/bottom row for Board representation.
     * @return String representation of the top/bottom row of the Board
     */
    private String GetTopBottomRow()
    {
        return "-------------\n";
    }

    /**
    * Checks if the game has finished
    * @return true if the game is done, else false
    */
    public boolean IsDone()
    {
        return game.IsDone();
    }

    /**
    * Returns the name of the player that won the game.
    * @return the name of the player that won the game
    */
    public String GetWinner()
    {
        if (!game.GetBoard().IsFull())
        {
            Player winner = game.GetWinner();
            return winner.GetName();
        }
        return "";
    }
}
