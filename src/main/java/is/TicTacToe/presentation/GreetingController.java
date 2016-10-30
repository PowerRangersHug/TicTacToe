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
    private GameInfoViewModel gameInfoViewModel = new GameInfoViewModel();

    @GetMapping("/")
    public String Form(Model model) 
    {
        model.addAttribute("gameInfo", gameInfoViewModel);
        return "front";
    }

    @PostMapping("/")
    public String Submit(@ModelAttribute GameInfoViewModel gameInfoViewModel) 
    {
        // At first assuming only Human vs Human is possible
        // TODO: implement Human vs Computer in this layer
        System.out.println(gameInfoViewModel.getMode());
        service = new TicTacToeService(gameInfoViewModel.getPlayer1(), gameInfoViewModel.getPlayer2());
        // gameInfoViewModel.setGridSymbol(1, "X"/*currPlayer.GetSymbol()*/);
        this.gameInfoViewModel = gameInfoViewModel;
        return "tictactoe";
    }

    @PostMapping(value = "/tictactoe")
    // public @ResponseBody
    public String Submit(Model model, @RequestParam ("player") String player, @RequestParam("cell") String cell)
    {
        // TODO: call MakeMove and check if it was an OK move
        // Then return ok otherwise return NOT OK or something...
        int x = Integer.parseInt(cell) / 3;
        int y = Integer.parseInt(cell) - x*3;
        System.out.println(x);
        System.out.println(y);
        if (service.MakeMove(x, y, player))
        {
            System.out.println("if");
            Player currPlayer = service.GetPlayerByName(player);
            gameInfoViewModel.setGridSymbol(Integer.parseInt(cell), currPlayer.GetSymbol());
        }
        model.addAttribute("gameInfoViewModel", gameInfoViewModel);
        return "tictactoe";
    }

    private String GetJSONStringArray(String[] arr)
    {
        JSONObject result = new JSONObject();
        for(String s : arr)
        {
            result.put("symbol",s);

        }
        return result.toString();
    }
}