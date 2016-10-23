package is.TicTacToe.data;

public class Player {
    private String name;
    private String symbol;

    /**
     * Initialize new instance of Player class
     */
    public Player()
    {
        name = "";
        symbol = "";
    }

    /**
     * Initialize new instance of Player class using the values passed in
     * parameters n and s.
     * @param n Player name
     * @param s Player symbol
     */
    public Player(String n, String s)
    {
        name = n;
        symbol = s;
    }

    /**
     * Get this players name
     * @return Player name
     */
    public String GetName()
    {
        return name;
    }

    /**
     * Get this players symbol
     * @return Player symbol
     */
    public String GetSymbol()
    {
        return symbol;
    }

    /**
     * Set the value of name to the value passed in parameter n.
     * @param n Player name
     */
    public void SetName(String n)
    {
        name = n;
    }

    /**
     * Set the value of symbol to the value passed in parameter s.
     * @param s Player symbol
     */
    public void SetSymbol(String s)
    {
        symbol = s;
    }
}
