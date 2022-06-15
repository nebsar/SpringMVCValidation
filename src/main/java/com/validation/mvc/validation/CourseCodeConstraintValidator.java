package com.validation.mvc.validation;

import com.validation.mvc.validation.CourseCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        this.coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        if (theCode != null){
           for (String prefix: this.coursePrefix){
               if (prefix.startsWith(theCode)){
                  return true;
               }
           }
        }

        return false;
    }
}
