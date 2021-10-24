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
		
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
	}
}
