package is.TicTacToe.data;

public class Player {

    private String name;
    private String symbol;
    private int type;

    private static final int UNDEFINED = 0;
    private static final int COMPUTER = 1;
    private static final int HUMAN = 2;

    /**
     * Initialize new instance of Player class
     */
    public Player()
    {
        name = "";
        symbol = "";
        type = UNDEFINED;
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
        type = HUMAN;
    }

    /**
     * Initialize new instance of Player class using the values passed in
     * parameters n and s.
     * @param n Player name
     * @param s Player symbol
     * @param t Player type
     */
    public Player(String n, String s, int t)
    {
        name = n;
        symbol = s;
        type = t;
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

    public int GetType()
    {
        return type;
    }
}
