/**
 * 
 */
package com.example.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.model.Student;

/**
 * @author 15197
 * Demo MVC Form tags
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	
	/**
	 * Inject properties values into Spring Controller
	 */
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	/**
	 * student - attribute (model name of student)
	 * new student() - value
	 * creating an empty Student object that will be passed to the form
	 * for the form to make use of it with data binding
	 * 
	 * @param model model is an object we can use to pass data between controller and view
	 * @return
	 */
	@RequestMapping("/showForm")
	public String showForm(Model model)	{
		// student - attribute (model name of student)
		// new student() - value 
		// creating an empty Student object that will be passed to the form 
		// for the form to make use of it with data binding
		model.addAttribute("student", new Student());
		// add the country options to the model 
	    model.addAttribute("theCountryOptions", countryOptions); 
		return "student-form";
	}
	/*
	 * @RequestMapping("/showForm") public String showForm(Model model) { // student
	 * - attribute (model name of student) // new student() - value // creating an
	 * empty Student object that will be passed to the form // for the form to make
	 * use of it with data binding model.addAttribute("student", new Student());
	 * return "student-form"; }
	 */
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent)	{
		// log input data
		System.out.println("theStudent: "+ theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}
}
