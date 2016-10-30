package is.TicTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.List;
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
		driver.get(baseUrl);
		WebElement player1Name = driver.findElement(By.id("player1"));
		player1Name.sendKeys("Hattifatti");
		WebElement player2Name = driver.findElement(By.id("player2"));
		player2Name.sendKeys("Mia");
		// Change when mode becomed dropdown list
		WebElement mode = driver.findElement(By.id("mode"));
		mode.sendKeys("1");
		player2Name.submit();

		WebElement resultp1 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("p1")));

        WebElement resultp2 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("p2")));

        assertEquals("Hattifatti", resultp1.getText());
        assertEquals("Mia", resultp2.getText());
	}

	@Test
	public void PlayGame()
	{
		driver.get(baseUrl);
		WebElement player1Name = driver.findElement(By.id("player1"));
		player1Name.sendKeys("Hattifatti");
		WebElement player2Name = driver.findElement(By.id("player2"));
		player2Name.sendKeys("Mia");
		// Change when mode becomed dropdown list
		WebElement mode = driver.findElement(By.id("mode"));
		mode.sendKeys("1");
		player2Name.submit();

		WebElement gameTable = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells = gameTable.findElements(By.tagName("td"));

        allCells.get(1).click();

        WebElement gameTable1 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells1 = gameTable1.findElements(By.tagName("td"));

        allCells1.get(0).click();

        WebElement gameTable2 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells2 = gameTable2.findElements(By.tagName("td"));

        allCells2.get(4).click();

        WebElement gameTable3 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells3 = gameTable3.findElements(By.tagName("td"));

        allCells3.get(2).click();

        WebElement gameTable4 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells4 = gameTable4.findElements(By.tagName("td"));
        
        allCells4.get(7).click();

        /*WebElement gameTable5 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameResult = gameTable5.findElement(By.id("game-result-message"));
        assertEquals("Hattifatti", gameResult.getText());

        /*for (WebElement cell : allCells)
        {
        	System.out.println(String.format("Value is: %s", cell.getAttribute("id")));
        }*/
	}
}

