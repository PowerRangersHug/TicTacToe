package is.TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestChuckWeb extends SeleniumTestWrapper {
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

