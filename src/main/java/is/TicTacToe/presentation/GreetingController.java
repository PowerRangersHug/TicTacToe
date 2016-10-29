package is.TicTacToe.presentation;

import is.TicTacToe.service.TicTacToeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/")
    public String index() 
    {
        return "front";
    }

    @RequestMapping("/tictactoe")
    public String tictactoe(@RequestParam(value="mode", required=false, defaultValue="1") String mode, Model model) 
    {
        if (mode == "1")
        {
            model.addAttribute("msg", "Not yet implemented.");
            return "errorpage";
        }
        else // if (mode == "2")
        {
            return "tictactoe";
        }
    }
    // @RequestMApping("/", method=POST)
}
