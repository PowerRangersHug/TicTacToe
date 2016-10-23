package is.TicTacToe.data;

public class Player {
    private String name;
    private String symbol;

    public Player()
    {
        name = "";
        symbol = "";
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

    public void SetName(String n) {  }
    public void SetSymbol(String s) {  }
}
