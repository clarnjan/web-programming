package mk.ukim.finki.wp.kol2021.restaurant.web;

import mk.ukim.finki.wp.kol2021.restaurant.model.MenuItem;
import mk.ukim.finki.wp.kol2021.restaurant.service.impl.MenuItemServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/menuitems")
public class MenuItemController {

    public final MenuItemServiceImpl menuItemService;

    public MenuItemController(MenuItemServiceImpl menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public String show(Model model){
        List<MenuItem> menuItems = menuItemService.listAll();
        model.addAttribute("menuItems",menuItems);
        return "menuItems";
    }

    @GetMapping("/add")
    public String showAdd(){
        return "addMenuItem";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name, @RequestParam String description){
        System.out.println(menuItemService.create(name, description));
        return "redirect:/menuitems";
    }
}
