package mk.ukim.finki.wp.kol2021.restaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LogginController {

    @GetMapping
    public String getLogin(){
        return "login";
    }

    @PostMapping
    public String login(){
        return "redirect:/";
    }

}
