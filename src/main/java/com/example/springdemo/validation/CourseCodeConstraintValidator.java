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
	private String coursePrefix;
	
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
		boolean result;
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
		}
		else {
			result = true;
		}	
		return result;
	}

}
