package is.TicTacToe;

import is.TicTacToe.data.Board;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class BoardTest {
    @Rule public final ExpectedException thrown = ExpectedException.none();


    @Test
    public void TestBoardSetAndGet()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(1,1,"X");
        assertEquals("X", testBoard.GetSymbol(1,1));
    }

    @Test
    public void TestBoardSetAndGetWrongSymbol()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(1,1,"BLA");
        assertEquals("", testBoard.GetSymbol(1,1));
    }

    @Test
    public void TestBoardSetWrongField()
    {
        Board testBoard = new Board();
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index out of bounds!");
        testBoard.SetSymbol(3,3,"X");
    }

    @Test
    public void TestBoardGetWrongField()
    {
        Board testBoard = new Board();
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index out of bounds!");
        testBoard.GetSymbol(3,3);
    }

    @Test
    public void TestBoardThreeInRow()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(0,0,"X");
        testBoard.SetSymbol(1,1,"X");
        testBoard.SetSymbol(2,2,"X");
        assertEquals(true, testBoard.HasThreeInRow());
    }


    @Test
    public void TestBoardIsFull()
    {
        Board testBoard = new Board();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                testBoard.SetSymbol(i,j,"O");
            }
        }
        assertEquals(true, testBoard.IsFull());
    }
}
