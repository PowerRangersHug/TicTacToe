package is.TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import is.TicTacToe.data.Board;

public class BoardTest {
	@Test
    public void testBoardSetAndGet()
    {
    	Board testBoard = new Board();
    	testBoard.setSymbol(1,1,"X");
		assertEquals("X", testBoard.getSymbol(1,1));
	}

	@Test
    public void testBoardSetAndGetWrongSymbol()
    {
    	Board testBoard = new Board();
    	testBoard.setSymbol(1,1,"BLA");
		assertEquals("", testBoard.getSymbol(1,1));
	}
}
