package is.TicTacToe.presentation;
import java.util.Scanner;
import is.TicTacToe.service.TicTacToeService;


public class TicTacToePresentation 
{
    private TicTacToeService service;

    public TicTacToePresentation() 
    {
        service = new TicTacToeService();
    }

    public TicTacToePresentation(TicTacToeService service) 
    {
        this.service = service;
    }

    /* 
    * Prints a welcome message to the console.
    */
    public static void WelcomeMessage()
    {
        System.out.println("Welcome to TicTacToe!");
    }

    /**
    * Get the game mode from standard input.
    * @return the game mode (0:quit, 1:human vs human, 2: human vs computer)
    */
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
            if (inputLine.equals("Q") || inputLine.equals("q"))
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
        Scanner sc = new Scanner(System.in);
        String player1Name, player2Name;

        System.out.println("Name of player 1:");
        if(sc.hasNextLine())
        {
            player1Name = sc.next();
        }
        System.out.println("Name of player 2:");
        if(sc.hasNextLine())
        {
            player2Name = sc.next();
        }
        // TODO: implement the StartGame function in service
        // service.StartGame(1, player1Name, player2Name);
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
            PlayGameMode1();
        }
        else // 2 players on same computer
        {
            PlayGameMode2();
            System.out.println("Goodbye");
        }
    }
}

