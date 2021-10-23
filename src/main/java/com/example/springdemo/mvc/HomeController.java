/**
 * 
 */
package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 15197
 * Create Controller class
 */
@Controller
public class HomeController {
	
	/**
	 * Spring MVC is flexible. Can have any method name, any return type, any argument
	 * get actual path that needs to be mapped. 
	 * Annotation maps a path to a method name, hence you can chose any method name
	 * handle all requests - get post, etc.
	 * 
	 * Based on the configs, it will look for a given prefix director, get view name from here, and look for suffix.
	 * @return JSP page name
	 */
	@RequestMapping("/")
	public String showMyPage()	{
		return "main-menu";
	}
}
