package is.TicTacToe.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import is.TicTacToe.data.Game;
import is.TicTacToe.data.Board;

public class GameTest {
    @Rule public final ExpectedException thrown = ExpectedException.none();

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

    @Test
    public void TestMakeMoveNullPlayer()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid Player Name!");
        testGame.MakeMove(2, 2, "Player8");
    }

    /*@Test
    public void TestMakeMove()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        testGame.MakeMove(1, 1, "Player1");
        Board testBoard = testGame.GetBoard();  
        //assertEquals("X", testBoard.getSymbol(1, 1));
        assertEquals()

    }*/

}
