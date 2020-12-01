package com.arijeet.service;

import com.arijeet.model.Employee;
import com.arijeet.model.PaySlip;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayslipService {
  public static void calculate(Employee emp) {
      PaySlip paySlip=emp.getPaySlip();
      BigDecimal annualSalary=emp.getAnnualSalary();
      paySlip.setGrossMonthlyIncome(calculateGrossMonthlyIncome(annualSalary));
      paySlip.setMonthlyIncomeTax(calculateMonthlyIncomeTax(annualSalary,emp.getCountry()));
      paySlip.setNetMonthlyIncome(paySlip.getGrossMonthlyIncome().subtract(paySlip.getMonthlyIncomeTax()));
  }

    private static BigDecimal calculateGrossMonthlyIncome(BigDecimal annualSalary) {
      return annualSalary.divide(new BigDecimal(12), 2, RoundingMode.HALF_UP);
    }

    private static BigDecimal calculateMonthlyIncomeTax(BigDecimal annualSalary, String country) {
       BigDecimal annualTax;
       if (country.equals("Australia")) {
           if (annualSalary.compareTo(new BigDecimal(20000)) <= 0) {
               annualTax = annualSalary.multiply(new BigDecimal(0));
           } else if (annualSalary.compareTo(new BigDecimal(40000)) <= 0) {
               annualTax = getTax(annualSalary, 20000, 0.1);
           } else if (annualSalary.compareTo(new BigDecimal(80000)) <= 0) {
               annualTax = getTax(new BigDecimal(40000), 20000, 0.1)
                       .add(getTax(annualSalary, 40000, 0.2));
           } else if (annualSalary.compareTo(new BigDecimal(180000)) <= 0) {
               annualTax = getTax(new BigDecimal(40000), 20000, 0.1)
                       .add(getTax(new BigDecimal(80000), 40000, 0.2))
                       .add(getTax(annualSalary, 80000, 0.3));
           } else {
               annualTax = getTax(new BigDecimal(40000), 20000, 0.1)
                       .add(getTax(new BigDecimal(80000), 40000, 0.2))
                       .add(getTax(new BigDecimal(180000), 80000, 0.3))
                       .add(getTax(annualSalary, 180000, 0.4));
           }
       } else {
           if (annualSalary.compareTo(new BigDecimal(14000)) <= 0) {
               annualTax = annualSalary.multiply(new BigDecimal("0.1"));
           } else if (annualSalary.compareTo(new BigDecimal(48000)) <= 0) {
               annualTax =getTax(new BigDecimal(14000), 0, 0.1)
                       .add(getTax(annualSalary, 14000, 0.17));
           } else if (annualSalary.compareTo(new BigDecimal(70000)) <= 0) {
               annualTax = getTax(new BigDecimal(14000), 0, 0.1)
                       .add(getTax(new BigDecimal(48000), 14000, 0.17))
                       .add(getTax(annualSalary, 48000, 0.3));
           } else {
               annualTax = getTax(new BigDecimal(14000), 0, 0.1)
                       .add(getTax(new BigDecimal(48000), 14000, 0.17))
                       .add(getTax(new BigDecimal(70000), 48000, 0.3))
                       .add(getTax(annualSalary, 70000, 0.33));
           }
       }
        return annualTax.divide(new BigDecimal(12),2, RoundingMode.HALF_UP);
    }

    private static BigDecimal getTax(BigDecimal upperBound, int lowerBound, double taxRate) {
     return upperBound.subtract(new BigDecimal(lowerBound)).multiply(new BigDecimal(taxRate));
    }
}

