package is.TicTacToe;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class SeleniumTestWrapper {
    //static ChromeDriver driver;
    static FirefoxDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void openBrowser() throws IOException
    {
        //driver = new ChromeDriver();
        String travisCiFlag = System.getenv().get("TRAVIS");
        FirefoxBinary firefoxBinary  = "true".equals(travisCiFlag) ?
            getFirefoxBinaryForTravisCi() : new FirefoxBinary();

        driver = new FirefoxDriver(firefoxBinary, new FirefoxProfile());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //port = System.getenv("PORT");
				port = "8080";
        if (port == null) {
            port = "8080";
        }
        //baseUrl = "http://localhost:" + port;
        baseUrl = "https://powerrangers-tictactoe-staging.herokuapp.com/";
    }

    private static FirefoxBinary getFirefoxBinaryForTravisCi() throws IOException
    {
        String firefoxPath = getFirefoxPath();
        System.out.println("firefox path: " + firefoxPath);

        return new FirefoxBinary(new File(firefoxPath));
    }

    private static String getFirefoxPath() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("which", "firefox");
        pb.redirectErrorStream(true);
        Process process = pb.start();
        try (InputStreamReader isr = new InputStreamReader(process.getInputStream(), "UTF-8");
             BufferedReader br = new BufferedReader(isr))
            {
                return br.readLine();
            }
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}

