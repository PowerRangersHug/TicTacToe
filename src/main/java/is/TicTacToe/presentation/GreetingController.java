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

    @GetMapping("/")
    public String Form(Model model) 
    {
        model.addAttribute("gameInfo", new GameInfoViewModel());
        return "front";
    }
/*
    @PostMapping("/")
    public String Submit(@ModelAttribute GameInfoViewModel gameInfoViewModel) 
    {
        // At first assuming only Human vs Human is possible
        // TODO: implement Human vs Computer in this layer
        System.out.println(gameInfoViewModel.getMode());
        service = new TicTacToeService(gameInfoViewModel.getPlayer1(), gameInfoViewModel.getPlayer2());
        return "tictactoe";
    }

    @PostMapping(value = "/tictactoe", produces = MediaType.APPLICATION_JSON_VALUE)
    // public @ResponseBody
    public String Submit(@RequestParam("player") String player, @RequestParam("cell") String cell, @ModelAttribute GameInfoViewModel gameInfoViewModel)
    {
        // TODO: call MakeMove and check if it was an OK move
        // Then return ok otherwise return NOT OK or something...
        System.out.println("------");
        System.out.println(gameInfoViewModel.getPlayer1());
        System.out.println("------");

        int x = Integer.parseInt(cell) / 3;
        int y = Integer.parseInt(cell) - x*3;
        if (service.MakeMove(x, y, player))
        {
            Player currPlayer = service.GetPlayerByName(player);
            gameInfoViewModel.setGridSymbol(Integer.parseInt(cell), currPlayer.GetSymbol());
        }
        //console.log(GetJSONStringArray(gameInfoViewModel.getGrid()));

        return "{}";
    }

    private String GetJSONStringArray(String[] arr)
    {
        JSONObject result = new JSONObject();
        for(String s : arr)
        {
            result.put("symbol",s);

        }
        return result.toString();
    }*/
}