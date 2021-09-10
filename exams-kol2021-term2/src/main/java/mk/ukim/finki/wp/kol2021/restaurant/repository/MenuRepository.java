package mk.ukim.finki.wp.kol2021.restaurant.repository;
import mk.ukim.finki.wp.kol2021.restaurant.model.Menu;
import mk.ukim.finki.wp.kol2021.restaurant.model.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {

    List<Menu> findByRestaurantNameContainingAndMenuType(String restaurantName, MenuType menuType);

    List<Menu> findByRestaurantNameContaining(String restaurantName);

    List<Menu> findByMenuType(MenuType menuType);
}
