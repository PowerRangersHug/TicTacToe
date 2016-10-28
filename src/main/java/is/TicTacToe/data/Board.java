package is.TicTacToe.data;

public class Board {
    private final int SIZE = 3;
    private String[][] grid;

    /**
    * The constructor for the board.
    */
    public Board()
    {
        Init();
    }

    /**
    * Get the current symbol at the (x,y) grid position.
    * @param x the x coordinate on the board
    * @param y the y coordinate on the board
    * @return the symbol
    */
    public String GetSymbol(int x, int y)
    {
        return grid[x][y];
    }

    /**
    * Set the current symbol at the (x,y) grid position.
    * @param x the x coordinate on the board
    * @param y the y coordinate on the board
    */
    public void SetSymbol(int x, int y, String symbol)
    {
        grid[x][y] = symbol;
    }

    /**
    * Initialize the board, starting fresh (new game).
    */
    public void Init()
    {
        // Points to a new 3x3 grid
        grid = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                grid[i][j] = " ";
            }
        }
    }

    /**
    * Checks if the board is in a winning state, i.e.
    * a symbol occurs three times in a row on the board.
    * @return true/false whether the board has three in row or not.
    */
    public boolean HasThreeInRow()
    {
        if (DiagonalsThreeInRow())
        {
            return true;
        }
        for (int i = 0; i < SIZE; i++)
        {
            if (HasThreeInCurrentRow(i))
                return true;
            else if (HasThreeInCurrentColumn(i))
                return true;
        }
        return false;
    }

    /**
    * Checks if the board is full of symbols, i.e. the game
    * is over.
    * @return true/false whether the board is full or not.
    */
    public boolean IsFull()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (grid[i][j] == " ")
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
    * Helper function for hasThreeInRow(), checks if
    * there are three same symbols in row diagonally.
    * @return true/false if diagonally three in row.
    */
    private boolean DiagonalsThreeInRow()
    {
        if (grid[1][1] ==  " ")
        {
            return false;
        }
        else if ((grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2]))
        {
            return true;
        }
        return ((grid[0][2] == grid[1][1]) && (grid[1][1] == grid[2][0]));
    }

    /**
    * Helper function for hasThreeInRow(), checks if
    * there are three same symbols in current row.
    * @param i row number
    * @return true/false if three same symbols in row i.
    */
    private boolean HasThreeInCurrentRow(int i)
    {
        return (grid[i][0] != " ") && (grid[i][0] == grid[i][1]) && (grid[i][1] == grid[i][2]);
    }

    /**
    * Helper function for hasThreeInRow(), checks if
    * there are three same symbols in current column.
    * @param i column number
    * @return true/false if three same symbols in column i.
    */
    private boolean HasThreeInCurrentColumn(int i)
    {
        return (grid[0][i] != " ") && (grid[0][i] == grid[1][i]) && (grid[1][i] == grid[2][i]);
    }

     /**
    * Checks if the board is in a winning state, i.e.
    * a symbol occurs three times in a row on the board and 
    * return the winning symbol.
    * @param
    * @return A symbol that occures three times in a row or emtpy string if the board is not in a winning state.
    */
    public String GetThreeInRowSymbol()
    {
        String symbol = DiagonalSymbol();
        if(symbol != "")
        {
            return symbol;
        }
        for (int i = 0; i < SIZE; i++)
        {
            symbol = CurrentRowSymbol(i);
            if(symbol != "")
            {
                return symbol;
            }
            symbol = CurrentColumnSymbol(i);
            if(symbol != "")
            {
                return symbol;
            }
        }
        return "";
    }

    /**
    * Helper function to find the winning symbol iff
    * the winning symbol is situated in the middle of the board.
    * @return the winning symbol, if not diagonal win, then returns empty string.
    */
    private String DiagonalSymbol()
    {
        if(DiagonalsThreeInRow())
        {
            return grid[1][1];
        }
        return "";
    }

    /**
    * Helper function to find the winning symbol iff
    * the winning symbol is situated in current row.
    * @param i the row
    * @return the winning symbol, if not win in this row, then returns empty string.
    */
    private String CurrentRowSymbol(int i)
    {
        if(HasThreeInCurrentRow(i))
        {
            return grid[i][0];
        }
        return "";
    }

    /**
    * Helper function to find the winning symbol iff
    * the winning symbol is situated in current column.
    * @param i the column
    * @return the winning symbol, if not win in this column, then returns empty string.
    */
    private String CurrentColumnSymbol(int i)
    {
        if(HasThreeInCurrentColumn(i))
        {
            return grid[0][i];
        }
        return "";
    }
}
