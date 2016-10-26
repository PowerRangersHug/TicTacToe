package is.TicTacToe.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import is.TicTacToe.data.Game;
import is.TicTacToe.data.Board;

public class GameTest {

    @Test
    public void TestBoardNotNull() 
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        assertNotNull(testGame.GetBoard());
    }

    @Test
    public void TestPlayerOneNotNull()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        assertNotNull(testGame.GetPlayer("Player1"));
    }

    @Test
    public void TestPlayerTwoNotNull()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        assertNotNull(testGame.GetPlayer("Player2"));
    }

    @Test
    public void TestPlayerOneName() 
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        assertEquals("Player1", testGame.GetPlayer("Player1").GetName());
    }

    @Test
    public void TestPlayerOneSymbol()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        assertEquals("X", testGame.GetPlayer("Player1").GetSymbol());
    }

}
