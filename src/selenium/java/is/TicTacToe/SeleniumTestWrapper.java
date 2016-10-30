package is.TicTacToe;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public abstract class SeleniumTestWrapper {
    //static ChromeDriver driver;
    static FirefoxDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void openBrowser(){
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //port = System.getenv("PORT");
				port = "8080";
        if (port == null) {
            port = "8080";
        }
        //baseUrl = "http://localhost:" + port;
        baseUrl = "https://powerrangers-tictactoe-staging.herokuapp.com/";
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}

