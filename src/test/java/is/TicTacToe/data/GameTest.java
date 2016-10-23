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
		Game newGame = new Game();
		assertNotNull(newGame.getBoard());
	}	
}
