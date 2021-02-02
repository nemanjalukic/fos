package com.nl.fos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.nl.fos.model.Category;
import com.nl.fos.model.FoodItem;

public interface FoodItemService {

    Page<FoodItem> findAll(Pageable pageable);
    FoodItem update(FoodItem FoodItem);
    FoodItem save(FoodItem FoodItem);

    void delete(String productId);
	FoodItem findItem(Long id);
	Page<FoodItem> findAllInCategory(Long categoryType, Pageable pageable);
	List<FoodItem> getRestaurantItems(String name);


}