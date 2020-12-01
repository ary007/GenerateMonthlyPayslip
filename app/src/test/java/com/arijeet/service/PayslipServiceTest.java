package com.arijeet.service;

import com.arijeet.model.Employee;
import com.arijeet.model.PaySlip;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class PayslipServiceTest {

    @Test
    public void payslipShouldGetGenerated() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(60000));
        emp.setCountry("Australia");
        PayslipService.calculate(emp);
        assertNotNull(emp.getPaySlip().getGrossMonthlyIncome());
        assertNotNull(emp.getPaySlip().getMonthlyIncomeTax());
        assertNotNull(emp.getPaySlip().getNetMonthlyIncome());
    }

    @Test
    public void calculateMonthlyIncomeBasedOnAnnualIncome() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(80000));
        emp.setCountry("Australia");
        PayslipService.calculate(emp);
        assertEquals(emp.getPaySlip().getGrossMonthlyIncome(),new BigDecimal("6666.67"));
    }

    @Test
    public void incomeTaxIsZeroWhenAnnualSalaryIsBelowTwentyThousand() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(18000));
        emp.setCountry("Australia");
        PayslipService.calculate(emp);
        assertEquals(emp.getPaySlip().getMonthlyIncomeTax(),new BigDecimal("0.00"));
    }

    @Test
    public void calculateIncomeTaxWhenAnnualSalaryIsBetweenTwentyAndFortyThousand() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(24000));
        emp.setCountry("Australia");
        PayslipService.calculate(emp);
        assertEquals(emp.getPaySlip().getMonthlyIncomeTax(),new BigDecimal("33.33"));
    }

    @Test
    public void calculateIncomeTaxWhenAnnualSalaryIsBetweenFortyAndEightyThousand() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(60000));
        emp.setCountry("Australia");
        PayslipService.calculate(emp);
        assertEquals(emp.getPaySlip().getMonthlyIncomeTax(),new BigDecimal("500.00"));
    }

    @Test
    public void calculateIncomeTaxWhenAnnualSalaryIsBetweenEightyAndOneEightyThousand() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(120000));
        emp.setCountry("Australia");
        PayslipService.calculate(emp);
        assertEquals(emp.getPaySlip().getMonthlyIncomeTax(),new BigDecimal("1833.33"));
    }

    @Test
    public void calculateIncomeTaxWhenAnnualSalaryIsAboveOneEightyThousand() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(190000));
        emp.setCountry("Australia");
        PayslipService.calculate(emp);
        assertEquals(emp.getPaySlip().getMonthlyIncomeTax(),new BigDecimal("3666.67"));
    }

    @Test
    public void calculateNetMonthlyIncome() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(60000));
        emp.setCountry("Australia");
        PayslipService.calculate(emp);
        assertEquals(emp.getPaySlip().getNetMonthlyIncome(),new BigDecimal("4500.00"));
    }

    @Test
    public void calculateincomeTaxWhenAnnualSalaryNewZealand() {
        Employee emp = new Employee();
        emp.setPaySlip(new PaySlip());
        emp.setAnnualSalary(new BigDecimal(14000));
        emp.setCountry("New Zealand");
        PayslipService.calculate(emp);
        assertEquals(new BigDecimal("1400").divide(new BigDecimal(12), 2, RoundingMode.HALF_UP), emp.getPaySlip().getMonthlyIncomeTax());
    }
}
