package is.TicTacToe.data;

public class Board {
    private final int SIZE = 3;
    private String[][] grid;

    /**
	* The constructor for the board
 	* @param 
 	* @return 
 	*/
    public Board() 
    {
    	init();
    }

    /**
	* Get the current symbol at the (x,y) grid position.
 	* @param int x, int y
 	* @return a symbol
 	*/
    public String getSymbol(int x, int y) 
    {
    	if ((x < 0 || x > 2) && (y < 0 || y > 2))
    		throw new IndexOutOfBoundsException("Index out of bounds!");

    	return grid[x][y];
    }

    /**
	* Set the current symbol at the (x,y) grid position.
 	* @param int x, int y
 	* @return
 	*/
    public void setSymbol(int x, int y, String symbol)
    {
    	if ((x < 0 || x > 2) && (y < 0 || y > 2))
    		throw new IndexOutOfBoundsException("Index out of bounds!");

    	if (symbol == "X" || symbol == "O")
    		grid[x][y] = symbol;
    }

    /**
	* Initialize the board, starting fresh (new game).
 	* @param
 	* @return
 	*/
    public void init() 
    {
    	// Points to a new 3x3 grid
    	grid = new String[SIZE][SIZE];
    	for (int i = 0; i < SIZE; i++)
    	{
    		for (int j = 0; j < SIZE; j++)
    		{
    			grid[i][j] = "";
    		}
    	}
    }

    /**
	* Checks if the board is in a winning state, i.e.
	* a symbol occurs three times in a row on the board.
 	* @param
 	* @return true/false whether the board has three in row or not.
 	*/
    public boolean hasThreeInRow()
    {
    	for (int i = 0; i < SIZE; i++)
    	{
    		if ((grid[i][0] != "") && (grid[i][0] == grid[i][1]) && (grid[i][1] == grid[i][2]))
    		{
    			return true;
    		}
    	}
    	if ((grid[0][0] != "") && (grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2]))
    		return true;
    	else	
    		return false; 
    }

    /**
	* Checks if the board is full of symbols, i.e. the game
	* is over.
 	* @param
 	* @return true/false whether the board is full or not.
 	*/
    public boolean isFull() { return false; }
}
