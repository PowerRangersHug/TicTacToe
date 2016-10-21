package is.TicTacToe;

public class Board {
    private final int SIZE = 3;
    private String grid[SIZE][SIZE];

    public Board() { }

    public String getSymbol(int x, int y) { return ""; }
    public void setSymbol(int x, int y, String symbol) {  }

    public void init() {  }

    public boolean hasThreeInRow() { return false; }
    public boolean isFull() { return false; }
}
