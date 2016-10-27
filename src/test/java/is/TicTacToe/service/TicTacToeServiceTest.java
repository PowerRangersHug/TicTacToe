package is.TicTacToe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
}
