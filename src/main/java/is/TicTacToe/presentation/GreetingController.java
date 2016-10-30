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

    @GetMapping("/")
    public String Form(Model model) 
    {
        gameInfoViewModel = new GameInfoViewModel();
        model.addAttribute("gameInfo", gameInfoViewModel);
        return "front";
    }

    @PostMapping("/")
    public String Submit(Model model, @ModelAttribute GameInfoViewModel gameInfoViewModel) 
    {
        // At first assuming only Human vs Human is possible
        // TODO: implement Human vs Computer in this layer
        System.out.println(gameInfoViewModel.getMode());
        if(gameInfoViewModel.getMode() == 1)
        {
            System.out.println("1");
            service = new TicTacToeService(gameInfoViewModel.getPlayer1());
            // There cant be two players with the same name
            if(gameInfoViewModel.getPlayer1().equals("Computer"))
            {
                gameInfoViewModel.setPlayer1("Player1");
            }
            gameInfoViewModel.setPlayer2("Computer");
        }
        if(gameInfoViewModel.getMode() == 2)
        {
            System.out.println("2");
            if(gameInfoViewModel.getPlayer1().equals(gameInfoViewModel.getPlayer2()))
            {
                gameInfoViewModel.setPlayer1("Player1");
                gameInfoViewModel.setPlayer1("Player2");
            }
            service = new TicTacToeService(gameInfoViewModel.getPlayer1(), gameInfoViewModel.getPlayer2());
        }

        this.gameInfoViewModel = gameInfoViewModel;
        model.addAttribute("message", "");
        return "tictactoe";
    }

    @PostMapping(value = "/tictactoe")
    public String Submit(Model model, @RequestParam ("player") String player, @RequestParam("cell") String cell)
    {
        String message = "";
        // TODO: call MakeMove and check if it was an OK move
        // Then return ok otherwise return NOT OK or something...
        int x = Integer.parseInt(cell) / 3;
        int y = Integer.parseInt(cell) - x*3;
        

        // True if the move was ok
        if(!player.equals("Computer"))
        {
            if (service.MakeMove(x, y, player))
            {   
                Player currPlayer = service.GetPlayerByName(player);
                gameInfoViewModel.setGridSymbol(Integer.parseInt(cell), currPlayer.GetSymbol());
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

        // The game is done (tie or a winner)
        if (service.IsDone())
        {
            String winner = service.GetWinner();
            System.out.println("winner:");
            System.out.println(winner);

            if (winner == "")
            {
                message = "It's a tie!";
            }
            else
            {
                message = winner;
            }
        }
       
        System.out.println(message);
        model.addAttribute("gameInfoViewModel", gameInfoViewModel);
        model.addAttribute("message", message);
        return "tictactoe";
    }
}