package com.nl.fos.controllers;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.nl.fos.model.FoodItem;
import com.nl.fos.model.Order;
import com.nl.fos.model.Restaurant;
import com.nl.fos.service.FoodItemService;
import com.nl.fos.service.UserService;
import com.nl.fos.vo.response.FoodItemReturn;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FoodItemController  {
	
    @Autowired
    FoodItemService foodItemService;
    
    @Autowired
    UserService userService;
    

    @GetMapping("/fooditem")
    public Page<FoodItem> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "5") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        return foodItemService.findAll(request);
    }

    @GetMapping("/fooditem/{foodItemId}")
    public FoodItem showOne(@PathVariable("foodItemId") String foodItemId) {

        FoodItem foodItemInfo = foodItemService.findItem(Long.parseLong(foodItemId));
        return foodItemInfo;
    }
    
    @GetMapping("/restaurantItems")
    public ResponseEntity<List<FoodItem> > orderList(Authentication authentication) {
    	List<FoodItem> foodItems= new ArrayList<FoodItem>();
    	
    	if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    	}
    	else {
    		foodItems = foodItemService.getRestaurantItems(authentication.getName());
    	}
    	 return ResponseEntity.ok(foodItems);
    }

    @PostMapping("/fooditem/new")
    public ResponseEntity<FoodItem> create(@Valid @RequestBody FoodItem foodItem,
    		Authentication authentication) {
    	
    	Restaurant restaurant=userService.findRestaurant(authentication.getName());
        foodItem.setRestaurant(restaurant);
        return ResponseEntity.ok(foodItemService.save(foodItem));
    }
}