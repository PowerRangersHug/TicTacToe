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

	@Test
    public void testBoardGetWrongField()
    {
    	Board testBoard = new Board();
    	thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index out of bounds!");
    	testBoard.getSymbol(3,3);
	}

	@Test
    public void testBoardThreeInRow()
    {
    	Board testBoard = new Board();
    	testBoard.setSymbol(0,0,"X");
    	testBoard.setSymbol(1,1,"X");
    	testBoard.setSymbol(2,2,"X");
		assertEquals(true, testBoard.hasThreeInRow());
	}


	@Test
    public void testBoardIsFull()
    {
    	Board testBoard = new Board();
    	for (int i = 0; i < 3; i++)
    	{
    		for (int j = 0; j < 3; j++)
    		{
    			testBoard.setSymbol(i,j,"O");
    		}
    	}
		assertEquals(true, testBoard.isFull());
	}
}
