package com.nl.fos.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nl.fos.vo.request.SignUpRequest;

import java.util.List;
import java.util.Set;


@Entity
public class Customer extends User{

    @Column(nullable = false, updatable = false, length = 45)
    private String firstName;

    @Column(length = 45)
    private String lastName;
    
    @JsonIgnore
    @OneToMany(mappedBy = "customer", targetEntity = Order.class, fetch = FetchType.EAGER)
    private List<Order> customerOrders;
    
    public Customer() {}
    

    public Customer(SignUpRequest signUpRequest) {
		super(signUpRequest);
		this.firstName=signUpRequest.getFirstName();
		this.lastName=signUpRequest.getLastName();
	}

	public Customer(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }


	public List<Order> getCustomerOrders() {
		return customerOrders;
	}


	public void setCustomerOrders(List<Order> customerOrders) {
		this.customerOrders = customerOrders;
	}

    

}