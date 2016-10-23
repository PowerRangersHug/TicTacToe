package is.TicTacToe;

import is.TicTacToe.data.Board;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class BoardTest {
	@Rule public final ExpectedException thrown = ExpectedException.none();


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

	@Test
    public void testBoardSetWrongField()
    {
    	Board testBoard = new Board();
    	thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index out of bounds!");
    	testBoard.setSymbol(3,3,"X");
	}
}
