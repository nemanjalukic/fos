package com.nl.fos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nl.fos.model.FoodItem;

import com.nl.fos.repository.FoodItemRepository;
import com.nl.fos.service.FoodItemService;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    FoodItemRepository foodItemRepository;


    @Override
    public Page<FoodItem> findAll(Pageable pageable) {
        return foodItemRepository.findAll(pageable);
    }

    @Override
    public FoodItem update(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    @Override
    public FoodItem save(FoodItem foodItem) {
        return update(foodItem);
    }

    @Override
    public void delete(String foodItemId) {
        FoodItem foodItem = foodItemRepository.findById(Long.parseLong(foodItemId)).get();
        foodItemRepository.delete(foodItem);

    }


	@Override
	public FoodItem findItem(Long id) {
		return foodItemRepository.findById(id).get();
	}

	@Override
	public Page<FoodItem> findAllInCategory(Long categoryType, Pageable pageable) {
		
		return foodItemRepository.findAllByCategoryId(categoryType,pageable);
	}

	@Override
	public List<FoodItem> getRestaurantItems(String name) {
		return foodItemRepository.findAllByRestaurantUsername(name);
	}




}
