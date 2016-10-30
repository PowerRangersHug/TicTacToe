package is.TicTacToe.presentation;

import is.TicTacToe.service.TicTacToeService;
import is.TicTacToe.presentation.viewmodels.GameInfoViewModel;
import is.TicTacToe.data.Player;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.json.*;

@Controller
public class GreetingController {

    private TicTacToeService service;
    private GameInfoViewModel gameInfoViewModel;

    /*
    * The front page, a form to fill before starting a game.
    */
    @GetMapping("/")
    public String Form(Model model) 
    {
        gameInfoViewModel = new GameInfoViewModel();
        model.addAttribute("gameInfo", gameInfoViewModel);
        return "front";
    }

    /*
    * Submitting the form on the front page, resulting
    * in a new page /tictactoe presented where the game can begin.
    */
    @PostMapping("/")
    public String Submit(Model model, @ModelAttribute GameInfoViewModel gameInfoViewModel) 
    {
        // At first assuming only Human vs Human is possible
        // TODO: implement Human vs Computer in this layer
        System.out.println(gameInfoViewModel.getMode());
        if(gameInfoViewModel.getMode() == 1)
        {

            service = new TicTacToeService(gameInfoViewModel.getPlayer1());
            // There cant be two players with the same name
            if(gameInfoViewModel.getPlayer1().equals("Computer"))
            {
                gameInfoViewModel.setPlayer1("Player1");
            }
            gameInfoViewModel.setPlayer2("Computer");
        }
        else if(gameInfoViewModel.getMode() == 2)
        {
            if(gameInfoViewModel.getPlayer1().equals("Computer"))
            {
                gameInfoViewModel.setPlayer1("Player1");
            }
            if(gameInfoViewModel.getPlayer2().equals("Computer"))
            {
                gameInfoViewModel.setPlayer2("Player2");
            }
            if(gameInfoViewModel.getPlayer1().equals(gameInfoViewModel.getPlayer2()))
            {
                gameInfoViewModel.setPlayer1("Player1");
                gameInfoViewModel.setPlayer2("Player2");
            }
            if(gameInfoViewModel.getPlayer1().equals(""))
            {
                gameInfoViewModel.setPlayer1("Player1");
            }
            if(gameInfoViewModel.getPlayer2().equals(""))
            {
                gameInfoViewModel.setPlayer2("Player2");
            }
            service = new TicTacToeService(gameInfoViewModel.getPlayer1(), gameInfoViewModel.getPlayer2());
        }

        this.gameInfoViewModel = gameInfoViewModel;
        model.addAttribute("message", "");
        return "tictactoe";
    }

    /*
    * Ajax call from tictactoe.js, dealing with
    * the move that the user made in the game.
    */
    @PostMapping(value = "/tictactoe")
    // Submit
    public String MakeMove(Model model, @RequestParam ("player") String player, @RequestParam("cell") String cell)
    {
        String message = "";

        // TODO: call MakeMove and check if it was an OK move
        // Then return ok otherwise return NOT OK or something...
                // If the game was done before this move attempt
        if (service.IsDone())
        {
            message = "Illegal move";
            model.addAttribute("gameInfoViewModel", gameInfoViewModel);
            model.addAttribute("message", message);
            return "tictactoe";
        }
        
        // True if the move was ok
        if(!player.equals("Computer"))
        {
            int x = Integer.parseInt(cell) / 3;
            int y = Integer.parseInt(cell) - x*3;
            if (service.MakeMove(x, y, player))
            {   
                Player currPlayer = service.GetPlayerByName(player);
                gameInfoViewModel.setGridSymbol(Integer.parseInt(cell), currPlayer.GetSymbol());
                System.out.println(currPlayer.GetSymbol());
            }
            else
            {
                System.out.println("Illegal move...");
                message = "Illegal move";
            }
        }
         else
        {
            Integer[] compCell = new Integer[1];
            compCell[0] = new Integer(-1);
            if(service.MakeMove(compCell))
            {

                Player currPlayer = service.GetPlayerByName("Computer");
                if(compCell[0] != -1)
                {
                    gameInfoViewModel.setGridSymbol(compCell[0], "O");
                }
                System.out.println(compCell[0]);
            }
        }
        if (service.IsDone())
        {
            String winner = service.GetWinner();
            if (winner == "")
            {
                message = "It's a tie!";
            }
            else
            {
                message = winner;
                gameInfoViewModel.incrementScore(winner);
            }
        }
     
        model.addAttribute("gameInfoViewModel", gameInfoViewModel);
        model.addAttribute("message", message);
        return "tictactoe";
    }

    /*
    * If the user presses "play again" after finishing a game,
    * another game can start with the same players, keeping
    * track of the scores for those two players.
    */
    @GetMapping(value = "/playAgain")
    public String PlayAgain(Model model)
    {
        gameInfoViewModel.resetGrid();
        service.ResetBoard();
        model.addAttribute("gameInfoViewModel", gameInfoViewModel);
        model.addAttribute("message", "");
        return "tictactoe";
    }
}