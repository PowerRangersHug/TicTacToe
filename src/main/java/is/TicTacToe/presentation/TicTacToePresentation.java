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

    public static void GetGameMode()
    {
    	System.out.println("Please choose the game mode");
        System.out.println("1 - 1 Player");
        System.out.println("2 - 2 Player");
    }

    public static void main(String args[])
    {
    	WelcomeMessage();
        GetGameMode();
    }
}
