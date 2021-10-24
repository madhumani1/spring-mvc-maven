/**
 * 
 */
package com.example.springdemo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		if(postalCode!=null)	{
			this.postalCode = postalCode.toUpperCase();
		} else	{
			this.postalCode = postalCode;
		}
	}

	private String firstName;
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@Min(value=18, message="age must be greater than or equal to 18")
	@Max(value=65, message="age must be less than or equal to 65")
	@NotNull(message="is required")
	private Integer age;	// Integer advantage - if field is blank or has spaces then it will be trimmed to null using initBinder
	
	@Pattern(regexp="^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$", message="A1A 1A1, where A is a letter and 1 is a digit")
	@NotNull(message="is required")
	private String postalCode;
}
