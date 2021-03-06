package is.TicTacToe.presentation;
import java.util.Scanner;
import is.TicTacToe.service.TicTacToeService;

/*
* This class is the console presentation.
* It is unused now since the application is 
* now a web application.
*/
public class TicTacToePresentation 
{
    private TicTacToeService service;

    /**
     * Default constructor for TicTacToePresentation
     */
    public TicTacToePresentation() 
    {
        service = new TicTacToeService();
    }

    /**
     * Constructor for TicTacToePresentation. Initializes service as
     * service.
     * @param service
     */
    public TicTacToePresentation(TicTacToeService service) 
    {
        this.service = service;
    }

    /** 
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
            if (sc.hasNextLine())
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
    
    /** 
     * Get usernames from users
     * Start and play game
     * Announce winner
     * Prompt user for new game or quit
     * @param mode computer vs. player(1) or player vs. player(2)
     */
    public void TwoPlayer(int mode) 
    {
        System.out.println("Name of player 1:");
        String player1Name = GetPlayerName("Player1");

        System.out.println("Name of player 2:");
        String player2Name = GetPlayerName("Player2");

        service.StartGame(mode, player1Name, player2Name);
        boolean playAgain = true;
        while(playAgain)
        {
            service.ResetBoard();
            while (!service.IsDone())
            {
                PrintBoard();
                MakeMove(1, player1Name);
                if (service.IsDone())
                {
                    break;
                }
                PrintBoard();
                MakeMove(2, player2Name);               
            }
            PrintBoard();
            printFinalMsg();
            playAgain = PromptForAnotherGame();
        }
        System.out.println(service.GetScoreForPlayerOne() + " - " + service.GetScoreForPlayerTwo());
        System.out.println("Thanks for playing");   
    }

    public void OnePlayer(int mode) 
    {
        System.out.println("Name of player:");
        String playerName = GetPlayerName("Player1");

        service.StartGame(mode, playerName, "Computer");
        boolean playAgain = true;
        while(playAgain)
        {
            service.ResetBoard();
            while (!service.IsDone())
            {
                PrintBoard();
                MakeMove(1, playerName);
                if (service.IsDone())
                {
                    break;
                }
                PrintBoard();

                System.out.println("Computers turn move:");
                Integer[] cell = new Integer[1];
                cell[0] = new Integer(-1);
                // TODO: makemove skilar true/false, eh að gera með það?
                service.MakeMove(cell);
                
            }
            PrintBoard();
            printFinalMsg();
            playAgain = PromptForAnotherGame();
        }
        System.out.println(service.GetScoreForPlayerOne() + " - " + service.GetScoreForPlayerTwo());
        System.out.println("Thanks for playing");   
    }

    private String GetPlayerName(String defaultPlayer)
    {
        String player = "";
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine())
        {
            player = sc.next();
        }
        if(player.isEmpty())
        {
            player = defaultPlayer;
        }
        return player;
    }

    public void MakeMove(int player, String name)
    {
        Scanner sc = new Scanner(System.in);
        int x = -1;
        int y = -1;
        System.out.println(name + " it's your move:");
        
        System.out.println("Choose x coordinate:");
        x = sc.nextInt();
        while (!service.LegalCoordinate(x))
        {
           System.out.println("x coordinate must be between 0-2:");
           x = sc.nextInt(); 
        }
        System.out.println("Choose y coordinate");
        y = sc.nextInt();
        while (!service.LegalCoordinate(y))
        {
           System.out.println("Y coordinate must be between 0-2:");
           y = sc.nextInt(); 
        }

        while (!service.MakeMove(x, y, name))
        {
            System.out.println("You can't make that move");
            System.out.println("Choose x coordinate:");
            x = sc.nextInt();
            System.out.println("Choose y coordinate");
            y = sc.nextInt();
        }
    }

    public void PrintBoard()
    {
        System.out.println(service.GetBoard());    
    }

    public void printFinalMsg()
    {
        String winner = service.GetWinner();
        if (winner.isEmpty())
        {
            System.out.println("It's a draw");
            return;
        }
        System.out.println(winner + " has won!");
    }

    public boolean PromptForAnotherGame()
    {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        System.out.println("Do you want to play another game?");
        System.out.println("Y - Yes");
        System.out.println("N - No");

        while (true)
        {
            answer = sc.next();
            if (answer.equals("Y"))
            {
                return true;

            }
            else if (answer.equals("N"))
            {
                return false;
            }
            System.out.println("That is not a valid input");
        }
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
            ticTacToe.OnePlayer(1);
        }
        else // 2 players on same computer
        {
            ticTacToe.TwoPlayer(2);
        }
    }
}

