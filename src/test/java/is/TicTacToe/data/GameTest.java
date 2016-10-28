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

    /*@Test
    public void TestMakeMoveNullPlayer()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid Player Name!");
        testGame.MakeMove(2, 2, "Player8");
    }*/

    @Test
    public void TestMakeMove()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        testGame.MakeMove(1, 1, "X");
        Board testBoard = testGame.GetBoard();  
        assertEquals("X", testBoard.GetSymbol(1, 1));
    }

    @Test
    public void TestAWinner()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        testGame.MakeMove(0, 0, "X");
        testGame.MakeMove(0, 1, "X");
        testGame.MakeMove(0, 2, "X");
        assertEquals(true, testGame.IsDone());
    }

    @Test
    public void TestNotDone()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        testGame.MakeMove(0, 1, "X");
        testGame.MakeMove(1, 2, "O");
        assertEquals(false, testGame.IsDone());
    }

    @Test
    public void TestDoneFull()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                testGame.MakeMove(i, j, "O");
            }
        }
        assertEquals(true, testGame.IsDone());
    }

    @Test
    public void TestGetWinner()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        testGame.MakeMove(0, 0, "O");
        testGame.MakeMove(0, 1, "O");
        testGame.MakeMove(0, 2, "O");
        assertEquals("Player2", testGame.GetWinner().GetName());
    }

    @Test
    public void TestGetAnotherWinner()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        testGame.MakeMove(2, 1, "X");
        testGame.MakeMove(1, 1, "X");
        testGame.MakeMove(0, 1, "X");
        assertEquals("Player1", testGame.GetWinner().GetName());
    }

    @Test
    public void TestGetWinnerNoWinner()
    {
        Game testGame = new Game(new Board(), new Player("Player1", "X"), new Player("Player2", "O"));
        testGame.MakeMove(0, 0, "X");
        testGame.MakeMove(0, 1, "O");
        testGame.MakeMove(0, 2, "X");
        assertEquals(null, testGame.GetWinner());
    }

    @Test 
    public void TestGetPlayerBySymbol()
    {
        Player player1 = new Player("Player1", "X"); 
        Game testGame = new Game(new Board(), player1, new Player("Player2", "O"));
        assertEquals(player1, testGame.GetPlayerBySymbol("X"));

    }

}
