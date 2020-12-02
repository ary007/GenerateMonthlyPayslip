package com.arijeet;

import com.arijeet.model.Employee;
import com.arijeet.model.PaySlip;
import com.arijeet.model.TaxRates;
import com.arijeet.service.PayslipService;
import com.arijeet.validator.InputValidator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        InputValidator.validateInputs(args);
        Employee emp = new Employee(args[0],new BigDecimal(args[1]),args[2]);

        PayslipService.calculate(emp);

        System.out.println(emp.toString());
    }
}
