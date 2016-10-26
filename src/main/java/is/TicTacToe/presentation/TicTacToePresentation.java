package is.TicTacToe.presentation;
import java.util.Scanner;
import is.TicTacToe.service.TicTacToeService;


public class TicTacToePresentation 
{
    private TicTacToeService gameService;

    public TicTacToePresentation() 
    {
        gameService = new TicTacToeService();
    }

    public static void WelcomeMessage()
    {
        System.out.println("Welcome to TicTacToe!");
    }

    public static int GetGameMode()
    {
        Scanner sc = new Scanner(System.in);
        String inputLine = "";
        while (true)
        {
            System.out.println("Please choose the game mode");
            System.out.println("1 - 1 Player");
            System.out.println("2 - 2 Player");
            System.out.println("Q - Quit");
            if(sc.hasNextLine())
            {
                inputLine = sc.next();
            }

            if (inputLine.equals("Q"))
            {
                return 0;
            }
            else if (inputLine.equals("1"))
            {
                return 1;
            }
            else if (inputLine.equals("2"))
            {
                return 2;
            }
            else
            {
                System.out.println("Wrong input!");
            }
        }
    }

    public static void main(String args[])
    {
        WelcomeMessage();
        int gameMode = GetGameMode();
        if (gameMode == 0)
        {
                System.out.println("Goodbye");
        }
    }
}
