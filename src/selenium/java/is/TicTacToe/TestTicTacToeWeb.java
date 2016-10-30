package is.TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class TestTicTacToeWeb extends SeleniumTestWrapper {
    @Test
    public void TitleMatches() 
	{
        driver.get(baseUrl);
        assertEquals("Tic Tac Toe", driver.getTitle());
    }
		
		@Test
		public void NameMatch()
		{
			
		}
}

