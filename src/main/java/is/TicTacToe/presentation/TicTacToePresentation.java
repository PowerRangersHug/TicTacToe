package is.TicTacToe.presentation;

import is.TicTacToe.service.TicTacToeService;

public class TicTacToePresentation 
{
    private TicTacToeService gameService;

    public TicTacToePresentation() 
    {
    	gameService = new gameService();
    }

    public void WelcomeMessage()
    {
    	System.out.println("Welcome to TicTacToe!\n");
    }

    /*public void GetGameMode()
    {
    	System.out.println()
    }*/

    public static int main(String args[])
    {
    	WelcomeMessage();
        return 0;
    }
}
