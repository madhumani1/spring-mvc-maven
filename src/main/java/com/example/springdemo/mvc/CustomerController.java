/**
 * 
 */
package com.example.springdemo.mvc;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.model.Customer;

/**
 * @author 15197
 * Demo MVC Form tags
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/**
	 * @InitBinder annotation works as a pre-processor. It will pre process each web request to our controller
	 * Method annotated with @InitBinder is executed.
	 * We are going to use it to remove leading and trailing white spaces.
	 * If String only has white spaces, then trim it to null
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)	{
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	/**
	 * customer - attribute (model name of customer)
	 * new customer() - value
	 * creating an empty Customer object that will be passed to the form
	 * for the form to make use of it with data binding
	 * 
	 * @param model model is an object we can use to pass data between controller and view
	 * @return
	 */
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		System.out.println("First name: |" + theCustomer.getFirstName() + "|" + "Last name: |" + theCustomer.getLastName() + "|");
		System.out.println("Age: |" + theCustomer.getAge()+"|");
		System.out.println("Postal Code: |" + theCustomer.getPostalCode()+"|");
		
		//I unput Madhu for age and got the following result
		//Binding Result: org.springframework.validation.BeanPropertyBindingResult: 1 errors
		//Field error in object 'customer' on field 'age': rejected value [madhu]; 
		//codes [typeMismatch.customer.age,typeMismatch.age,typeMismatch.java.lang.Integer,typeMismatch]; 
		//arguments [org.springframework.context.support.DefaultMessageSourceResolvable: 
		//codes [customer.age,age]; arguments []; default message [age]]; 
		//default message [Failed to convert property value of type 'java.lang.String' to required type 
		//'java.lang.Integer' for property 'age'; nested exception is java.lang.NumberFormatException: For input string: "madhu"]
		//
		//
		// We  are overriding typeMismatch.customer.age with our message
		System.out.println("Binding Result: "+theBindingResult);
		System.out.println("\n\n\n");
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
	}
}
