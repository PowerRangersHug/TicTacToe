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

    @Test
    public void TestThreeInRowSymbolDiagonal()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(0,0,"X");
        testBoard.SetSymbol(1,1,"X");
        testBoard.SetSymbol(2,2,"X");
        assertEquals("X", testBoard.GetThreeInRowSymbol());
    }

    @Test
    public void TestThreeInRowSymbolDiagonalReversed()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(0,2,"X");
        testBoard.SetSymbol(1,1,"X");
        testBoard.SetSymbol(2,0,"X");
        assertEquals("X", testBoard.GetThreeInRowSymbol());
    }

    @Test
    public void TestThreeInRowSymbolVertical()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(0,0,"X");
        testBoard.SetSymbol(0,1,"X");
        testBoard.SetSymbol(0,2,"X");
        assertEquals("X", testBoard.GetThreeInRowSymbol());
    }

    @Test
    public void TestThreeInRowSymbolHorizontal()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(0,1,"O");
        testBoard.SetSymbol(1,1,"O");
        testBoard.SetSymbol(2,1,"O");
        assertEquals("O", testBoard.GetThreeInRowSymbol());
    }

    @Test
    public void TestThreeInRowSymbolWithNoThreeInRow()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(0,1,"O");
        testBoard.SetSymbol(1,1,"X");
        testBoard.SetSymbol(2,1,"O");
        assertEquals("", testBoard.GetThreeInRowSymbol());
    }

     @Test
    public void TestThreeInRowSymbolWithEmptyBoard()
    {
        Board testBoard = new Board();
        assertEquals("", testBoard.GetThreeInRowSymbol());
    }

    @Test
    public void TestBoardIsEmpty()
    {
        Board testBoard = new Board();
        assertEquals(true, testBoard.IsEmpty());
    }

      @Test
    public void TestBoardIsEmptyNotEmpty()
    {
        Board testBoard = new Board();
        testBoard.SetSymbol(2,1,"O");
        assertEquals(false, testBoard.IsEmpty());
    }

}
