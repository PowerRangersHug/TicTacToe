package is.TicTacToe.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import is.TicTacToe.data.Player;

public class PlayerTest {
    @Test
    public void TestEmptyNewPlayerName()
    {
        Player p = new Player();
        assertEquals("", p.GetName());
    }

    @Test
    public void TestEmptyNewPlayerSymbol()
    {
        Player p = new Player();
        assertEquals("", p.GetSymbol());
    }

    @Test
    public void TestSetPlayerName()
    {
        Player p = new Player();
        p.SetName("John");
        assertEquals("John", p.GetName());
    }

    @Test
    public void TestSetPlayerSymbol()
    {
        Player p = new Player();
        p.SetSymbol("X");
        assertEquals("X", p.GetSymbol());
    }

    @Test
    public void TestConstructorWithParamsName()
    {
        Player p = new Player("John", "X");
        assertEquals("John", p.GetName());
    }

    @Test
    public void TestConstructorWithParamsSymbol()
    {
        Player p = new Player("John", "X");
        assertEquals("X", p.GetSymbol());
    }
}
