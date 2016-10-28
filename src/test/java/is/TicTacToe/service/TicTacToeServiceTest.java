package is.TicTacToe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import is.TicTacToe.service.TicTacToeService;

public class TicTacToeServiceTest
{
    @Test
    public void TestGetPlayerByName()
    {
        // Test GetPlayerByName() with default constructor
        TicTacToeService testService = new TicTacToeService();

        assertNull(testService.GetPlayerByName("PlayerThatDoesntExist"));
        assertEquals("Player1", testService.GetPlayerByName("Player1").GetName());
        assertEquals("Player2", testService.GetPlayerByName("Player2").GetName());
    }

    @Test
    public void TestConstructorWithParameters()
    {
        // Test constructor with parameters
        TicTacToeService testService = new TicTacToeService("John", "Eve");

        assertEquals("John", testService.GetPlayerByName("John").GetName());
        assertEquals("Eve", testService.GetPlayerByName("Eve").GetName());
    }

    @Test
    public void TestSetPlayerNames()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.SetPlayerNames("John", "Eve");

        assertEquals("John", testService.GetPlayerByName("John").GetName());
        assertEquals("Eve", testService.GetPlayerByName("Eve").GetName());
    }

    @Test
    public void TestGetBoard()
    {
        TicTacToeService testService = new TicTacToeService();
        String expectedBoard = "-------------\n"
            + "|   |   |   |\n"
            + "|---+---+---|\n"
            + "|   |   |   |\n"
            + "|---+---+---|\n"
            + "|   |   |   |\n"
            + "-------------\n";

        assertEquals(expectedBoard, testService.GetBoard());
    }

    @Test
    public void TestMakeMove()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.MakeMove(1, 1, "Player1");
        assertEquals("X", testService.GetGame().GetBoard().GetSymbol(1,1));
    }

    @Test 
    public void TestContainsSymbol()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.MakeMove(1, 1, "Player1");
        assertEquals(true, testService.ContainsSymbol(1,1));
    }

    @Test 
    public void TestNotContainsSymbol()
    {
        TicTacToeService testService = new TicTacToeService();
        assertEquals(false, testService.ContainsSymbol(1,1));
    }

    @Test 
    public void TestGetWinner()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.MakeMove(0, 0, "Player1");
        testService.MakeMove(1, 1, "Player1");
        testService.MakeMove(2, 2, "Player1");
        assertEquals("Player1", testService.GetWinner());
    }

    @Test 
    public void TestGetAnotherWinner()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.MakeMove(0, 0, "Player1");
        testService.MakeMove(0, 1, "Player1");
        testService.MakeMove(0, 2, "Player1");
        assertEquals("Player1", testService.GetWinner());
    }

    @Test 
    public void TestGetScoreForPlayerOne()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.MakeMove(0, 0, "Player1");
        testService.MakeMove(0, 1, "Player1");
        testService.MakeMove(0, 2, "Player1");
        testService.GetGame().IsDone();
        assertEquals(1, testService.GetScoreForPlayerOne());
    }

    @Test 
    public void TestGetScoreForPlayerTwo()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.MakeMove(1, 0, "Player2");
        testService.MakeMove(1, 1, "Player2");
        testService.MakeMove(1, 2, "Player2");
        testService.GetGame().IsDone();
        assertEquals(1, testService.GetScoreForPlayerTwo());
    }
    

    @Test 
    public void TestResetBoard()
    {
        TicTacToeService testService = new TicTacToeService();
        String expectedBoard = "-------------\n"
            + "|   |   |   |\n"
            + "|---+---+---|\n"
            + "|   |   |   |\n"
            + "|---+---+---|\n"
            + "|   |   |   |\n"
            + "-------------\n";
        testService.MakeMove(0, 0, "Player1");
        testService.MakeMove(0, 1, "Player1");
        testService.MakeMove(0, 2, "Player1");
        testService.ResetBoard();
        assertEquals(expectedBoard, testService.GetBoard());
    }

    @Test
    public void TestIsDoneTrueWinner()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.MakeMove(0, 0, "Player1");
        testService.MakeMove(0, 1, "Player1");
        testService.MakeMove(0, 2, "Player1");
        assertEquals(true, testService.IsDone());
    }

    @Test
    public void TestIsDoneFalse()
    {
        TicTacToeService testService = new TicTacToeService();
        testService.MakeMove(0, 0, "Player1");
        testService.MakeMove(0, 1, "Player1");
        assertEquals(false, testService.IsDone());
    }


    @Test
    public void TestIsDoneFull()
    {
        TicTacToeService testService = new TicTacToeService();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                testService.MakeMove(i, j, "Player1");
            }
        }
        assertEquals(true, testService.IsDone());
    }
}











