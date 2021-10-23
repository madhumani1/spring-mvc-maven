/**
 * 
 */
package com.example.springdemo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author 15197
 *
 */
public class Customer {
	
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
	
	private String firstName;
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
}
