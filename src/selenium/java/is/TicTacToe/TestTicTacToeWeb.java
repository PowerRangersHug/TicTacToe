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

        // Clicks on mode 1 (Human vs Human)
        WebElement buttonMode1 = driver.findElement(By.id("button-mode2"));
        buttonMode1.click();

        // Sets the player names
        WebElement player1Name = driver.findElement(By.id("player1name"));
        WebElement player2Name = driver.findElement(By.id("player2name"));
        player1Name.sendKeys("Áslaug");
        player2Name.sendKeys("Karl");

        player2Name.submit();

        WebElement resultp1 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("p1")));

        WebElement resultp2 = (new WebDriverWait(driver, 15))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("p2")));

        assertEquals("Áslaug", resultp1.getText());
        assertEquals("Karl", resultp2.getText());
    }

    @Test
    public void PlayGame()
    {
        driver.get(baseUrl);

        // Clicks on mode 1 (Human vs Human)
        WebElement buttonMode1 = driver.findElement(By.id("button-mode2"));
        buttonMode1.click();

        // Sets the player names
        WebElement player1Name = driver.findElement(By.id("player1name"));
        WebElement player2Name = driver.findElement(By.id("player2name"));
        player1Name.sendKeys("Áslaug");
        player2Name.sendKeys("Karl");

        player2Name.submit();

        WebElement gameTable = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells = gameTable.findElements(By.tagName("td"));

        allCells.get(1).click();

        WebElement gameTable1 = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells1 = gameTable1.findElements(By.tagName("td"));

        allCells1.get(2).click();

        WebElement gameTable2 = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells2 = gameTable2.findElements(By.tagName("td"));

        allCells2.get(4).click();

        WebElement gameTable3 = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells3 = gameTable3.findElements(By.tagName("td"));

        allCells3.get(5).click();

        WebElement gameTable4 = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells4 = gameTable4.findElements(By.tagName("td"));
        

        allCells4.get(7).click();

        WebElement results = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.className("showing")));

       	WebElement resultMessage = results.findElement(By.id("game-result-message"));
        assertEquals("Áslaug is the winner!", resultMessage.getText());
    }

    @Test
    public void FullBoard()
    {
        driver.get(baseUrl);
        // Clicks on mode 1 (Human vs Human)
        WebElement buttonMode1 = driver.findElement(By.id("button-mode2"));
        buttonMode1.click();

        // Sets the player names
        WebElement player1Name = driver.findElement(By.id("player1name"));
        WebElement player2Name = driver.findElement(By.id("player2name"));
        player1Name.sendKeys("Hannes");
        player2Name.sendKeys("Skúli");

        player2Name.submit();

        WebElement gameTable = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells = gameTable.findElements(By.tagName("td"));

        allCells.get(1).click();

        WebElement gameTable1 = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells1 = gameTable1.findElements(By.tagName("td"));

        allCells1.get(4).click();

        WebElement gameTable2 = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells2 = gameTable2.findElements(By.tagName("td"));

        allCells2.get(8).click();

        WebElement gameTable3 = (new WebDriverWait(driver, 15, 100))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells3 = gameTable3.findElements(By.tagName("td"));

        allCells3.get(7).click();

        WebElement gameTable4 = (new WebDriverWait(driver, 15, 500))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells4 = gameTable4.findElements(By.tagName("td"));
        
        allCells4.get(6).click();

        WebElement gameTable5 = (new WebDriverWait(driver, 15, 500))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells5 = gameTable5.findElements(By.tagName("td"));
        
        allCells5.get(2).click();

        WebElement gameTable6 = (new WebDriverWait(driver, 15, 500))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells6 = gameTable6.findElements(By.tagName("td"));
        
        allCells6.get(5).click();

        WebElement gameTable7 = (new WebDriverWait(driver, 15, 500))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells7 = gameTable7.findElements(By.tagName("td"));
        
        allCells7.get(0).click();

        WebElement gameTable8 = (new WebDriverWait(driver, 15, 500))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells8 = gameTable8.findElements(By.tagName("td"));

        allCells8.get(3).click();

        WebElement results = (new WebDriverWait(driver, 15, 500))
            .until(ExpectedConditions.presenceOfElementLocated(By.className("showing")));

        WebElement resultMessage = results.findElement(By.id("game-result-message"));
         assertEquals("It's a tie!", resultMessage.getText());
     }
}

