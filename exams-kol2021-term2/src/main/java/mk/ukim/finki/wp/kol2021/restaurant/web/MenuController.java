package mk.ukim.finki.wp.kol2021.restaurant.web;

import mk.ukim.finki.wp.kol2021.restaurant.model.Menu;
import mk.ukim.finki.wp.kol2021.restaurant.model.MenuItem;
import mk.ukim.finki.wp.kol2021.restaurant.model.MenuType;
import mk.ukim.finki.wp.kol2021.restaurant.service.impl.MenuItemServiceImpl;
import mk.ukim.finki.wp.kol2021.restaurant.service.impl.MenuServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    private final MenuServiceImpl service;
    private MenuItemServiceImpl menuItemService;

    public MenuController(MenuServiceImpl service, MenuItemServiceImpl menuItemService) {
        this.service = service;
        this.menuItemService = menuItemService;
    }

    @GetMapping({"/","/menu"})
    public String showMenus(@RequestParam(required = false) String nameSearch,@RequestParam(required = false) MenuType menuType, Model model) {
        List<Menu> menuList;
        if (nameSearch == null && menuType == null) {
            menuList = service.listAll();
        } else {
            menuList = this.service.listMenuItemsByRestaurantNameAndMenuType(nameSearch,  menuType);
        }
        model.addAttribute("menuList",menuList);
        return "list";
    }

    @GetMapping("/menu/add")
    public String showAdd(Model model) {
        model.addAttribute("menuItems",menuItemService.listAll());
        return "form";
    }

    @GetMapping("/menu/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        Menu menu = this.service.findById(id);
        List<MenuItem> menuItems = menuItemService.listAll();
        model.addAttribute("menu", menu);
        model.addAttribute("menuItems", menuItems);
        return "form.html";
    }

    @PostMapping("/menu")
    public String create(@RequestParam String name,@RequestParam MenuType menuType,@RequestParam List<Long> menuItemsId) {
        this.service.create(name, menuType, menuItemsId);
        return "redirect:/menu";
    }

    @PostMapping("/menu/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam MenuType menuType,
                         @RequestParam List<Long> menuItemsId) {
        this.service.update(id, name, menuType, menuItemsId);
        return "redirect:/menu";
    }

    @PostMapping("/menu/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.service.delete(id);
        return "redirect:/menu";
    }
}
