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
        if ((x < 0 || x > 2) || (y < 0 || y > 2))
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
        if ((x < 0 || x > 2) || (y < 0 || y > 2))
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
    * @param
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

    private boolean diagonalsThreeInRow()
    {
        return (grid[0][0] != "") && (grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2]);
    }

    private boolean hasThreeInCurrentRow(int i)
    {
        return (grid[i][0] != "") && (grid[i][0] == grid[i][1]) && (grid[i][1] == grid[i][2]);
    }

    private boolean hasThreeInCurrentColumn(int i)
    {
        return (grid[0][i] != "") && (grid[0][i] == grid[1][i]) && (grid[1][i] == grid[2][i]);
    }

    public String getThreeInRowSymbol()
    {
        String symbol = diagonalSymbol();
        if(symbol != "")
        {
            return symbol;
        }
        for (int i = 0; i < SIZE; i++)
        {
            symbol = currentRowSymbol(i);
            if(symbol != "")
            {
                return symbol;
            }
            symbol = currentColumnSymbol(i);
            if(symbol != "")
            {
                return symbol;
            }
        }
        return ""; 
    }

    private String diagonalSymbol()
    {
        if(diagonalsThreeInRow())
        {
            return grid[0][0];
        }
        return "";
    }

    private String currentRowSymbol(int i)
    {
        if(hasThreeInCurrentRow(i))
        {
            return grid[i][0];
        }
        return "";
    }

    private String currentColumnSymbol(int i)
    {
        if(hasThreeInCurrentColumn(i))
        {
            return grid[0][i];
        }
        return "";
    }
}
