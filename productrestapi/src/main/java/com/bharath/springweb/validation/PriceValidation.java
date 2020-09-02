package com.bharath.springweb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidation implements ConstraintValidator<PriceValid, Integer> {

	@Override
	public boolean isValid(Integer price, ConstraintValidatorContext arg1) {
		arg1.disableDefaultConstraintViolation();
		if(price > 10)
		{
			
		return true;
		}
		else 
			{
			arg1.buildConstraintViolationWithTemplate("Price is Less than10").addConstraintViolation();
			return false;
			}
			
	}

}
