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
        Game testGame = new Game();
        assertNotNull(testGame.GetBoard());
    }

    @Test
    public void TestPlayerOneNotNull()
    {
        Game testGame = new Game();
        assertNotNull(testGame.GetPlayer("Player1"));
    }

}
