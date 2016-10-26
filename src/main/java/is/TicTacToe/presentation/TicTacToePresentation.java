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

        public TicTacToePresentation(TicTacToeService service) 
    {
        gameService = service;
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

    // Human vs Human mode
    public static void PlayGameMode1() 
    {
        //gameService.startGame(1);
    }

    // Human vs Computer mode
    public static void PlayGameMode2() 
    {
        System.out.println("Not yet implemented.");
    }

    public static void main(String args[])
    {
        TicTacToePresentation ticTacToe = new TicTacToePresentation(new TicTacToeService());
        ticTacToe.WelcomeMessage();
        int gameMode = ticTacToe.GetGameMode();
        if (gameMode == 0)
        {
                System.out.println("Goodbye");
        }
        else if (gameMode == 1) // 1 player vs computer
        {
            // kalla á fall
        }
        else // 2 players on same computer
        {
            // kalla á annað fall
        }
    }

}

