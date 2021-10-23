/**
 * 
 */
package com.example.springdemo.model;

import java.util.LinkedHashMap;

/**
 * @author 15197
 *
 */
public class Student {
	public Student() {
		// populate country options: used ISO country code
		/*countryOptions = new LinkedHashMap<>();
		countryOptions.put(" ", " ");
		countryOptions.put("BRA", "Brazil");
		countryOptions.put("RUS", "Russia");
		countryOptions.put("IND", "India");
		countryOptions.put("CHN", "China");
		countryOptions.put("SAF", "South Africa");*/
	}
	/**
	 * @return the favoriteLanguage
	 */
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	/**
	 * @param favoriteLanguage the favoriteLanguage to set
	 */
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	/*
	 public LinkedHashMap<String, String> getCountryOptions() {
	 return countryOptions;
	}*/
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	//private LinkedHashMap<String, String> countryOptions;
}
