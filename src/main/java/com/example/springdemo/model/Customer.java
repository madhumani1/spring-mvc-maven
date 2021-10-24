/**
 * 
 */
package com.example.springdemo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	private String firstName;
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@Min(value=18, message="age must be greater than or equal to 18")
	@Max(value=65, message="age must be less than or equal to 65")
	private int age;
}
