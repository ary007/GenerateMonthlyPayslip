package com.arijeet.validator;

import org.apache.commons.validator.routines.BigDecimalValidator;

import java.math.BigDecimal;

public class InputValidator {

    public static void validateInputs(String[] inputs) {
        if(inputs.length != 3) {
            throw new IllegalArgumentException(" Kindly enter two inputs, name and annual income ");
        }
        String annualIncome=inputs[1];
        validateAnnualIncome(annualIncome);
    }

    private static void validateAnnualIncome(String annualIncome) {
        BigDecimal value=BigDecimalValidator.getInstance().validate(annualIncome);
        if(value==null) {
            throw new IllegalArgumentException(" Kindly enter number for annual Income ");
        }
    }
}
