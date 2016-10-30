package is.TicTacToe;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.chrome.ChromeDriver;

public abstract class SeleniumTestWrapper {
    static ChromeDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void openBrowser()
    {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        port = System.getenv("PORT");
        //port = "8080";
        if (port == null) {
            port = "8080";
        }
        //baseUrl = "http://localhost:" + port;
        baseUrl = "http://powerrangers-tictactoe-staging.herokuapp.com";
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}

