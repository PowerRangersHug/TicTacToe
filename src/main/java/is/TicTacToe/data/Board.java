package is.TicTacToe.data;

public class Board {
    private final int SIZE = 3;
    private String[][] grid;

    public Board() 
    {
    	grid = new String[SIZE][SIZE];
    }

    public String getSymbol(int x, int y) 
    {
    	return grid[x][y];
    }

    public void setSymbol(int x, int y, String symbol)
    {
    	grid[x][y] = symbol;
    }

    public void init() 
    {
    	// Points to a new 3x3 grid
    	grid = new String[SIZE][SIZE];
    }

    public boolean hasThreeInRow() { return false; }
    public boolean isFull() { return false; }
}
