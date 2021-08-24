package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "restaurantServices")
public class RestaurantServicesImpl implements RestaurantServices {
  @Autowired
  private RestaurantRepository restaurantRepository;
  
  //attempt to save everything as inputted, if it fails don't add to DB otherwise add to DB
  @Transactional
  @Override
  public Restaurant save(Restaurant restaurant) {
    return restaurantRepository.save(restaurant);
  }
}
