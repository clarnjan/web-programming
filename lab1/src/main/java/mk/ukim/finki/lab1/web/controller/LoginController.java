package mk.ukim.finki.lab1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String getLogin(@RequestParam(required = false) String error, Model model){
        return "login";
    }

    @PostMapping
    public String postLogin(@RequestParam(required = false) String error, Model model){
        return "login";
    }
}
