package com.arijeet;

import com.arijeet.model.Employee;
import com.arijeet.model.PaySlip;
import com.arijeet.service.PayslipService;
import com.arijeet.validator.InputValidator;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        InputValidator.validateInputs(args);
        Employee emp = new Employee();

        emp.setPaySlip(new PaySlip());
        emp.setName(args[0]);
        emp.setAnnualSalary(new BigDecimal(args[1]));
        emp.setCountry(args[2]);

        PayslipService.calculate(emp);

        System.out.println(emp.toString());
    }
}
