package is.TicTacToe.presentation;

import is.TicTacToe.service.TicTacToeService;
import is.TicTacToe.presentation.viewmodels.ModeInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String Form(Model model) {
        model.addAttribute("modeInfo", new ModeInfo());
        return "front";
    }

    @PostMapping("/")
    public String Submit(@ModelAttribute ModeInfo modeInfo) {
    	TicTacToeService service = new TicTacToeService(modeInfo.GetPlayer1(), modeInfo.GetPlayer2());
        return "tictactoe";
    }
}