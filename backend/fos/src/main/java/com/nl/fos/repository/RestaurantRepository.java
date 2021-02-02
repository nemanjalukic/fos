package com.nl.fos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nl.fos.model.Restaurant;
import com.nl.fos.model.User;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	Optional<Restaurant> findByUsername(String username);
}