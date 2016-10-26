package is.TicTacToe.data;

public class Board {
    private final int SIZE = 3;
    private String[][] grid;

    /**
    * The constructor for the board.
    */
    public Board() 
    {
        init();
    }

    /**
    * Get the current symbol at the (x,y) grid position.
    * @param x the x coordinate on the board
    * @param y the y coordinate on the board
    * @return the symbol
    */
    public String getSymbol(int x, int y) 
    {
        if ((x < 0 || x > 2) || (y < 0 || y > 2))
            throw new IndexOutOfBoundsException("Index out of bounds!");
        return grid[x][y];
    }

    /**
    * Set the current symbol at the (x,y) grid position.
    * @param x the x coordinate on the board
    * @param y the y coordinate on the board
    */
    public void setSymbol(int x, int y, String symbol)
    {
        if ((x < 0 || x > 2) || (y < 0 || y > 2))
            throw new IndexOutOfBoundsException("Index out of bounds!");

        if (symbol == "X" || symbol == "O")
            grid[x][y] = symbol;
    }

    /**
    * Initialize the board, starting fresh (new game).
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
    * @return true/false whether the board has three in row or not.
    */
    public boolean hasThreeInRow()
    {
        if (diagonalsThreeInRow())
            return true;
        for (int i = 0; i < SIZE; i++)
        {
            if (hasThreeInCurrentRow(i))
                return true;
            else if (hasThreeInCurrentColumn(i))
                return true;
        }
        return false; 
    }

    /**
    * Checks if the board is full of symbols, i.e. the game
    * is over.
    * @return true/false whether the board is full or not.
    */
    public boolean isFull() 
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (grid[i][j] == "")
                    return false;
            }
        }
        return true;
    }

    /**
    * Helper function for hasThreeInRow(), checks if
    * there are three same symbols in row diagonally.
    * @return true/false if diagonally three in row.
    */
    private boolean diagonalsThreeInRow()
    {
        return (grid[0][0] != "") && (grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2]);
    }

    /**
    * Helper function for hasThreeInRow(), checks if
    * there are three same symbols in current row.
    * @param i row number
    * @return true/false if three same symbols in row i.
    */
    private boolean hasThreeInCurrentRow(int i)
    {
        return (grid[i][0] != "") && (grid[i][0] == grid[i][1]) && (grid[i][1] == grid[i][2]);
    }

    /**
    * Helper function for hasThreeInRow(), checks if
    * there are three same symbols in current column.
    * @param i column number
    * @return true/false if three same symbols in column i.
    */
    private boolean HasThreeInCurrentColumn(int i)
    {
        return (grid[0][i] != "") && (grid[0][i] == grid[1][i]) && (grid[1][i] == grid[2][i]);
    }
}
