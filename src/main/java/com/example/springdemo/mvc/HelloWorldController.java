/**
 * 
 */
package com.example.springdemo.mvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author 15197
 * Create Controller class
 */
@Controller
@RequestMapping("/funny")
public class HelloWorldController {
	
	/**
	 * Need a controller method to show the initial HTML form
	 * @return JSP page name
	 */
	@RequestMapping("/showForm")
	public String showForm()	{
		return "helloworld-form";
	}
	
	/**
	 * for another form
	 * @return
	 */
	@RequestMapping("/showFormVersionTwo")
	public String showFormVersionTwo()	{
		return "helloworld-form-version-two";
	}
	
	/**
	 * Need a controller method to process the initial HTML form
	 * @return JSP page name
	 */
	@RequestMapping("/processForm")
	public String processForm()	{
		return "helloworld";
	}
	
	/**
	 * Add a new controller method to read form data and
	 * add data to the model
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/processFormVersionTwo")
	public String greetStudent(HttpServletRequest request, Model model)	{
		// read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		String theAge = request.getParameter("studentAge");
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		/**
		 * evening/morning
		 */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String salut = "morning ";
		if(now.getHour()>=12 && now.getHour()<17)	salut="afternoon ";
		else if(now.getHour()>=17 && now.getHour()<=24)	salut="evening ";
		
		// create the message
		String result = "Good " + salut + theName + " (aged " + theAge + "years). Current Time is " + dtf.format(now);
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld-version-two";
	}
	
	/**
	 * Add a new controller method to read form data using request param way and
	 * add data to the model
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/processFormVersionThree")
	public String showStudentScore(@RequestParam("studentName") String theName, Model model)	{
		// now we can use the variable - theName 
		//String theAge = request.getParameter("studentAge");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		int gpa = (int) ((Math.random()*4)+3); 
		String result=theName + "'s GPA: "+gpa;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld-version-three";
	}
}
