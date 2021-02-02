package com.nl.fos.vo.request;



import javax.validation.constraints.*;
 
public class SignUpRequest {
    @NotBlank
    @Size(min = 6, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    private String role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    
    @NotBlank
    @Size(min = 6, max = 20)
    private String firstName;
    @NotBlank
    @Size(min = 6, max = 20)
    private String lastName;
    
    @NotBlank
    @Size(min = 6, max = 20)
    private String restaurantName;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	
    
    
    
}
