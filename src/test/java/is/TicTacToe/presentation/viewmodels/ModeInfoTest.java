package is.TicTacToe.presentation.viewmodels;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import is.TicTacToe.presentation.viewmodels.ModeInfo;

public class ModeInfoTest 
{
    @Test
    public void TestGetPlayer1()
    {
        ModeInfo testModeInfo = new ModeInfo();
        testModeInfo.SetPlayer1("Fanney");
        assertEquals("Fanney", testModeInfo.GetPlayer1());
    }

    @Test
    public void TestGetPlayer2()
    {
        ModeInfo testModeInfo = new ModeInfo();
        testModeInfo.SetPlayer2("Herdís");
        assertEquals("Herdís", testModeInfo.GetPlayer2());
    }

    @Test
    public void TestGetMode()
    {
        ModeInfo testModeInfo = new ModeInfo();
        testModeInfo.SetMode(1);
        assertEquals(1, testModeInfo.GetMode());
    }
}