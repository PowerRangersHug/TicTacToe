package is.TicTacToe.presentation;

import is.TicTacToe.service.TicTacToeService;
import is.TicTacToe.presentation.viewmodels.GameInfoViewModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String Form(Model model) {
        model.addAttribute("gameInfo", new GameInfoViewModel());
        return "front";
    }

    @PostMapping("/")
    public String Submit(@ModelAttribute GameInfoViewModel gameInfoViewModel) {
        // At first assuming only Human vs Human is possible
        // TODO: implement Human vs Computer in this layer
        System.out.println(gameInfoViewModel.getMode());
        TicTacToeService service = new TicTacToeService(gameInfoViewModel.getPlayer1(), gameInfoViewModel.getPlayer2());
        return "tictactoe";
    }

    @PostMapping(value = "/tictactoe", produces = MediaType.APPLICATION_JSON_VALUE)
    // public @ResponseBody
    public String Submit(@RequestParam("player") String player, @RequestParam("cell") String cell)
    {
        // TODO: call MakeMove and check if it was an OK move
        // Then return ok otherwise return NOT OK or something...
        return "OK";
    }
}