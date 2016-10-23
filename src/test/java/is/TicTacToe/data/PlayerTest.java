package is.TicTacToe.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import is.TicTacToe.data.Player;

public class PlayerTest {
    @Test
    public void EmptyNewPlayerName()
    {
        Player p = new Player();
        assertEquals("", p.getName());
    }

    @Test
    public void EmptyNewPlayerSymbol()
    {
        Player p = new Player();
        assertEquals("", p.getSymbol());
    }
}
