package com.nl.fos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nl.fos.model.Customer;
import com.nl.fos.model.OStatus;
import com.nl.fos.model.Order;
import com.nl.fos.model.OrderStatus;
import com.nl.fos.model.Restaurant;
import com.nl.fos.repository.OrderRepository;
import com.nl.fos.repository.OrderStatusRepository;
import com.nl.fos.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	 @Autowired
	 OrderRepository orderRepository;
	 @Autowired
	 OrderStatusRepository orderStatusRepository;
	 
	 @Override
	 @Transactional
	 public Order save(Order order) {
	        return orderRepository.save(order);
	    }

	 @Override
	 public List<Order> getRestaurantOrders(String username) {
		 
		 return orderRepository.findAllByRestaurantUsername(username);
	 }

	@Override
	public List<Order> getCustomerOrders(String username) {
		
		return orderRepository.findAllByCustomerUsername(username);
	}
	
	@Override
	public  List<Order> getAll() {
		return orderRepository.findAll();

	}

	@Override
	public Page<Order> findAll(PageRequest request) {
		return orderRepository.findAll(request);
	}

	@Override
	public Order findById(Long orderId) {
		return orderRepository.findById(orderId).get();
	}
	
    @Override
    @Transactional
    public Order finish(Long orderId) {
        Order order = findById(orderId);
        OrderStatus orderStatus=orderStatusRepository.findByStatus(OStatus.FINISHED).get();
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }
    
    @Override
    @Transactional
    public Order accept(Long orderId) {
        Order order = findById(orderId);
        OrderStatus orderStatus=orderStatusRepository.findByStatus(OStatus.ACCEPTED).get();
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }
    
    @Override
    @Transactional
    public Order cancel(Order order) {
        OrderStatus orderStatus=orderStatusRepository.findByStatus(OStatus.CANCELED).get();
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }
    

}
