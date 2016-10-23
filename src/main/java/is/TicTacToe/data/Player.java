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
    public String getName()
    {
        return name;
    }

    /**
     * Get this players symbol
     * @return Player symbol
     */
    public String getSymbol()
    {
        return symbol;
    }

    public void setName(String n) {  }
    public void setSymbol(String s) {  }
}
