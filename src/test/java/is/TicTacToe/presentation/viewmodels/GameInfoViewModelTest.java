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
        testModeInfo.SetPlayer1("Fanney");
        assertEquals("Fanney", testModeInfo.GetPlayer1());
    }

    @Test
    public void TestGetPlayersEmptyString()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        assertEquals("", testModeInfo.GetPlayer1());
        assertEquals("", testModeInfo.GetPlayer2());

    }

    @Test
    public void TestGetPlayer2()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        testModeInfo.SetPlayer2("Herdís");
        assertEquals("Herdís", testModeInfo.GetPlayer2());
    }

    @Test
    public void TestGetMode()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        assertEquals(0, testModeInfo.GetMode());
    }

    @Test
    public void TestSetMode()
    {
        GameInfoViewModel testModeInfo = new GameInfoViewModel();
        testModeInfo.SetMode(1);
        assertEquals(1, testModeInfo.GetMode());
    }


}