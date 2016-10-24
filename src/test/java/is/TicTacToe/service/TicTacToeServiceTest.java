package is.TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToePresentationTest 
{
	@Test
	public void TestWelcomeMessage()
	{
		TicTacToePresentation pres = new TicTacToePresentation();

		assertEquals("Welcome to TicTacToe", pres.WelcomeMessage());
	}

	//@Test
	//public void 
}
