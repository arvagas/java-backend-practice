package com.lambdaschool.crudyrestaurants.repositories;

import java.util.List;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Restaurant to the rest of the application.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
  Restaurant findByName(String name);

  List<Restaurant> findByNameContainingIgnoringCase(String subname);

  @Query(value = "SELECT r.name, COUNT(m.*) AS counts " +
                "FROM restaurants r LEFT JOIN menus m " +
                "ON r.restaurantid = m.restaurantid " +
                "GROUP BY r.name", nativeQuery = true)
  List<MenuCounts> getMenuCounts(); 

  List<Restaurant> findByMenus_dishContainingIgnoringCase(String subdish);
}