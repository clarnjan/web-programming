package mk.ukim.finki.wp.kol2021.restaurant.service.impl;

import mk.ukim.finki.wp.kol2021.restaurant.model.Menu;
import mk.ukim.finki.wp.kol2021.restaurant.model.MenuItem;
import mk.ukim.finki.wp.kol2021.restaurant.model.MenuType;
import mk.ukim.finki.wp.kol2021.restaurant.model.exceptions.InvalidMenuIdException;
import mk.ukim.finki.wp.kol2021.restaurant.repository.MenuItemRepository;
import mk.ukim.finki.wp.kol2021.restaurant.repository.MenuRepository;
import mk.ukim.finki.wp.kol2021.restaurant.service.MenuService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;

    public MenuServiceImpl(MenuRepository menuRepository, MenuItemRepository menuItemRepository) {
        this.menuRepository = menuRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<Menu> listAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElseThrow(InvalidMenuIdException::new);
    }

    @Override
    public Menu create(String restaurantName, MenuType menuType, List<Long> menuItemIds) {
        List<MenuItem> menuItems = menuItemRepository.findAllById(menuItemIds);
        return menuRepository.save(new Menu(restaurantName,menuType,menuItems));
    }

    @Override
    public Menu update(Long id, String restaurantName, MenuType menuType, List<Long> menuItemIds) {
        Menu menu = menuRepository.findById(id).orElseThrow(InvalidMenuIdException::new);
        menu.setRestaurantName(restaurantName);
        menu.setMenuType(menuType);
        List<MenuItem> menuItems = menuItemRepository.findAllById(menuItemIds);
        menu.setMenuItems(menuItems);
        return menuRepository.save(menu);
    }

    @Override
    public Menu delete(Long id) {
        Menu menu = this.findById(id);
        menuRepository.delete(menu);
        return menu;
    }

    @Override
    public List<Menu> listMenuItemsByRestaurantNameAndMenuType(String restaurantName, MenuType menuType) {
        if(restaurantName == null && menuType == null){
            return menuRepository.findAll();
        }
        if(menuType == null){
            return menuRepository.findByRestaurantNameContaining(restaurantName);
        }
        if(restaurantName == null){
            return menuRepository.findByMenuType(menuType);
        }
        return menuRepository.findByRestaurantNameContainingAndMenuType(restaurantName, menuType);
    }
}
