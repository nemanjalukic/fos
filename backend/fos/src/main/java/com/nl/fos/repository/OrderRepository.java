package com.nl.fos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nl.fos.model.Customer;
import com.nl.fos.model.Order;
import com.nl.fos.model.Restaurant;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Optional<Order> findById(Long orderId);

	List<Order> findAllByRestaurantId(Long username);
	List<Order> findAllByCustomerId(Long username);

	List<Order> findAllByRestaurantUsername(String username);

	List<Order> findAllByCustomerUsername(String username);
}
