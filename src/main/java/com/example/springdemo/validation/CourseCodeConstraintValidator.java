/**
 * 
 */
package com.example.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 15197
 * The actual helper class which contains business rules for validation
 * Implements ConstrainValidator which pass in CourseCode annotation and the actual type of data we need to validate
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	// setup field 
	private String[] coursePrefix;
	
	/**
	 * When validator is created, it initialize it to get handle to the actual annotation that was passed in
	 */
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	/**
	 * This is what MVC will call to validate when form is submitted. we apply our business rule then
	 * theCode - HTML form data entered by user
	 * theConstraintValidatorContext - Helper class for additional error messages
	 * 
	 */
	@Override
	public boolean isValid(String theCode, 
						ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result=false;
		if (theCode != null) {
			//result = theCode.startsWith(coursePrefix);
			//loop through array of prefixes
			// check to see if code matches any of the course prefix
			for(String allowedPrefix : coursePrefix)	{
				result = theCode.startsWith(allowedPrefix);
				
				//if match is found, break out
				if(result)	{
					break;
				}
			}
		}
		else {
			result = true;
		}	
		return result;
	}

}
