/**
 * 
 */
package com.example.springdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author 15197
 * Custom Annotation
 * Where value – the value course code must start with 
 * Message – error message if validation fails
 * CourseCode – Field in the entity class/POJO (Student)
 * 
 * Its a special type of interface, so use @interface
 * @Contraint - to be validated by CourseCodeConstraintValidate class which we are going to create. Its a helper class containing business rules
 * @Target - where can we apply this annotation - method or on a field
 * @Retention - retain this annotation in Java class file. Process it at runtime
 */
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	// define default course code
	// means @CourseCode annotation has a parameter called value. If user doesn't provide a value, then we will use MAD
	/**
	 * equivalent to 
	 * @CourseCode(value="MAD" message="must start with MAD")
	 * private String courseCode;
	 * @return
	 */
	public String[] value() default {"MAD"};	
	
	// define default error message
	public String message() default "must start with MAD";
	
	// define default groups
	public Class<?>[] groups() default {};
	
	// define default payloads
	public Class<? extends Payload>[] payload() default {};
}
