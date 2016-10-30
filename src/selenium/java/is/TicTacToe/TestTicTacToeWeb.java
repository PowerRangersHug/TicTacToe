package is.TicTacToe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;
import java.lang.NullPointerException;
import java.lang.*;

import java.util.List;
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

        //WebElement gameTable = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameTable = retryingFindClick("game-table");

        //List<WebElement> allCells = gameTable.findElements(By.tagName("td"));

        List<WebElement> allCells = retryingFindCells(gameTable, "td");
        allCells.get(1).click();
         try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}
        //retryingFindClick(allCells, 1);

        //WebElement gameTable1 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameTable1 = retryingFindClick("game-table");

        //List<WebElement> allCells1 = gameTable1.findElements(By.tagName("td"));
        List<WebElement> allCells1 = retryingFindCells(gameTable1, "td");
        allCells1.get(2).click();
        //retryingFindClick(allCells1, 2);

        try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}
        //WebElement gameTable2 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameTable2 = retryingFindClick("game-table");

        //List<WebElement> allCells2 = gameTable2.findElements(By.tagName("td"));
        List<WebElement> allCells2 = retryingFindCells(gameTable2, "td");
        //retryingFindClick(allCells2, 4);
        allCells2.get(4).click();

        try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}

        //WebElement gameTable3 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameTable3 = retryingFindClick("game-table");

        //List<WebElement> allCells3 = gameTable3.findElements(By.tagName("td"));
        List<WebElement> allCells3 = retryingFindCells(gameTable3, "td");
        //retryingFindClick(allCells3, 5);
        allCells3.get(5).click();
         try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}

        //WebElement gameTable4 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameTable4 = retryingFindClick("game-table");
        //List<WebElement> allCells4 = gameTable4.findElements(By.tagName("td"));
        List<WebElement> allCells4 = retryingFindCells(gameTable4, "td");

        allCells4.get(7).click();
        //retryingFindClick(allCells4, 7);
         try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}

        WebElement results = (new WebDriverWait(driver, 15, 5000))
            .until(ExpectedConditions.presenceOfElementLocated(By.className("showing")));
        //WebElement results = retryingFindClick("showing");	
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

        //WebElement gameTable = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameTable = retryingFindClick("game-table");
        //List<WebElement> allCells = gameTable.findElements(By.tagName("td"));
        List<WebElement> allCells = retryingFindCells(gameTable, "td");
        //retryingFindClick(allCells, 1);
        allCells.get(1).click();
         try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}

        WebElement gameTable1 = retryingFindClick("game-table");
        //WebElement gameTable1 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        //List<WebElement> allCells1 = gameTable1.findElements(By.tagName("td"));
        List<WebElement> allCells1 = retryingFindCells(gameTable1, "td");
        allCells1.get(4).click();
      	//retryingFindClick(allCells1, 4);
      	 try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}


        //WebElement gameTable2 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameTable2 = retryingFindClick("game-table");
        //List<WebElement> allCells2 = gameTable2.findElements(By.tagName("td"));
        List<WebElement> allCells2 = retryingFindCells(gameTable2, "td");
        allCells2.get(8).click();
        //retryingFindClick(allCells2, 8);
         try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}

        //WebElement gameTable3 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));
		WebElement gameTable3 = retryingFindClick("game-table");
        //List<WebElement> allCells3 = gameTable3.findElements(By.tagName("td"));
		List<WebElement> allCells3 = retryingFindCells(gameTable3, "td");
        allCells3.get(7).click();
        //retryingFindClick(allCells3, 7);
         try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}

        //WebElement gameTable4 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));
        WebElement gameTable4 = retryingFindClick("game-table");
        //List<WebElement> allCells4 = gameTable4.findElements(By.tagName("td"));
        List<WebElement> allCells4 = retryingFindCells(gameTable4, "td");
        allCells4.get(6).click();
        //retryingFindClick(allCells4, 6);
         try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}

        //WebElement gameTable5 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));
        WebElement gameTable5 = retryingFindClick("game-table");
        //List<WebElement> allCells5 = gameTable5.findElements(By.tagName("td"));
        List<WebElement> allCells5 = retryingFindCells(gameTable5, "td");
        allCells5.get(2).click();
        //retryingFindClick(allCells5, 2);
         try {
   			Thread.sleep(1000);
   		} catch (Exception e) {}

        //WebElement gameTable6 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));
        WebElement gameTable6 = retryingFindClick("game-table");
        //List<WebElement> allCells6 = gameTable6.findElements(By.tagName("td"));
        List<WebElement> allCells6 = retryingFindCells(gameTable6, "td");
        allCells6.get(5).click();
        //retryingFindClick(allCells6, 5);
         try {
   	        Thread.sleep(1000);
   	    } catch (Exception e) {}

        //WebElement gameTable7 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));
        WebElement gameTable7 = retryingFindClick("game-table");
        //List<WebElement> allCells7 = gameTable7.findElements(By.tagName("td"));
        List<WebElement> allCells7 = retryingFindCells(gameTable7, "td");
        allCells7.get(0).click();
        //retryingFindClick(allCells7, 0);
         try {
   	        Thread.sleep(1000);
   	    } catch (Exception e) {}

        //WebElement gameTable8 = (new WebDriverWait(driver, 15, 5000))
        //    .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));
        WebElement gameTable8 = retryingFindClick("game-table");
        //List<WebElement> allCells8 = gameTable8.findElements(By.tagName("td"));
        List<WebElement> allCells8 = retryingFindCells(gameTable8, "td");
        allCells8.get(3).click();
        //retryingFindClick(allCells8, 3);

         try {
   	        Thread.sleep(1000);
   	    } catch (Exception e) {}

        WebElement results = (new WebDriverWait(driver, 15, 5000))
            .until(ExpectedConditions.presenceOfElementLocated(By.className("showing")));
        //WebElement results = retryingFindClick("showing");
        WebElement resultMessage = results.findElement(By.id("game-result-message"));
         assertEquals("It's a tie!", resultMessage.getText());
     }

    @Test
    public void GetScore()
    {
        driver.get(baseUrl);

        // Clicks on mode 1 (Human vs Human)
        WebElement buttonMode1 = driver.findElement(By.id("button-mode2"));
        buttonMode1.click();

        // Sets the player names
        WebElement player1Name = driver.findElement(By.id("player1name"));
        WebElement player2Name = driver.findElement(By.id("player2name"));
        player1Name.sendKeys("Jón");
        player2Name.sendKeys("Jörundur");

        player2Name.submit();

        //WebElement gameTable = (new WebDriverWait(driver, 15))
          //  .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement gameTable = retryingFindClick("game-table");

        List<WebElement> allCells = gameTable.findElements(By.tagName("td"));

        allCells.get(1).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        WebElement gameTable1 = (new WebDriverWait(driver, 15, 5000))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells1 = gameTable1.findElements(By.tagName("td"));

        allCells1.get(2).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        WebElement gameTable2 = (new WebDriverWait(driver, 15, 5000))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells2 = gameTable2.findElements(By.tagName("td"));

        allCells2.get(4).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        WebElement gameTable3 = (new WebDriverWait(driver, 15, 5000))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells3 = gameTable3.findElements(By.tagName("td"));

        allCells3.get(5).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        WebElement gameTable4 = (new WebDriverWait(driver, 15, 5000))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        List<WebElement> allCells4 = gameTable4.findElements(By.tagName("td"));
        
        allCells4.get(7).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        WebElement results = (new WebDriverWait(driver, 15, 5000))
            .until(ExpectedConditions.presenceOfElementLocated(By.className("showing")));

        // Let's press play again and check if the score will be updated
        WebElement playAgainButton = results.findElement(By.id("play-again-button"));
        playAgainButton.click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        
        WebElement results2 = (new WebDriverWait(driver, 15, 5000))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("game-table")));

        WebElement player1score = driver.findElement(By.id("scoreboard-player1"));
        assertEquals("1", player1score.getText());

        WebElement player2score = driver.findElement(By.id("scoreboard-player2"));
        assertEquals("0", player2score.getText());
    }

    public WebElement retryingFindClick(String idOfElement) {
        int attempts = 0;
        while(attempts < 2) {
            try {
                WebElement result = (new WebDriverWait(driver, 15, 5000))
            		.until(ExpectedConditions.presenceOfElementLocated(By.id(idOfElement)));
                return result;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return null;
	}

	public List<WebElement> retryingFindCells(WebElement table, String tagOfElement) {
        int attempts = 0;
        while(attempts < 2) {
            try {
                List<WebElement> result = table.findElements(By.tagName(tagOfElement));
                return result;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return null;
	}

	public void retryingFindClick(List<WebElement> list, int id) {
        int attempts = 0;
        while(attempts < 2) {
            try {
            	list.get(id).click();
				return;
            } catch(StaleElementReferenceException e) {
            }
            catch(NullPointerException e) {
            }
            attempts++;
        }
        return;
	}

}



