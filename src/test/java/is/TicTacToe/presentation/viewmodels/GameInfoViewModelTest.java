package is.TicTacToe.presentation.viewmodels;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import is.TicTacToe.presentation.viewmodels.GameInfoViewModel;

public class GameInfoViewModelTest  
{
    @Test
    public void TestGetPlayer1()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        testModeInfo.setPlayer1("Fanney");
        assertEquals("Fanney", testModeInfo.getPlayer1());
    }

    @Test
    public void TestGetPlayersEmptyString()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        assertEquals("", testModeInfo.getPlayer1());
        assertEquals("", testModeInfo.getPlayer2());

    }

    @Test
    public void TestGetPlayer2()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        testModeInfo.setPlayer2("Herdís");
        assertEquals("Herdís", testModeInfo.getPlayer2());
    }

    @Test
    public void TestGetMode()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        assertEquals(0, testModeInfo.getMode());
    }

    @Test
    public void TestSetMode()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        testModeInfo.setMode(1);
        assertEquals(1, testModeInfo.getMode());
    }

    @Test
    public void TestSetGridSymbol()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        testModeInfo.setGridSymbol(1,"X");
        assertEquals("X", testModeInfo.getGrid()[1]);
    }


}