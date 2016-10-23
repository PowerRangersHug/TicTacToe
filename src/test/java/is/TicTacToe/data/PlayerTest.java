package is.TicTacToe.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import is.TicTacToe.data.Player;

public class PlayerTest {
    @Test
    public void EmptyNewPlayerName()
    {
        Player p = new Player();
        assertEquals("", p.GetName());
    }

    @Test
    public void EmptyNewPlayerSymbol()
    {
        Player p = new Player();
        assertEquals("", p.GetSymbol());
    }

    @Test
    public void SetPlayerNameTest()
    {
        Player p = new Player();
        p.SetName("John");
        assertEquals("John", p.GetName());
    }

    @Test
    public void SetPlayerSymbolTest()
    {
        Player p = new Player();
        p.SetSymbol("X");
        assertEquals("X", p.GetSymbol());
    }
}
