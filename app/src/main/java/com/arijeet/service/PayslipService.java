package com.arijeet.service;

import com.arijeet.mapper.TaxRateMapper;
import com.arijeet.model.Employee;
import com.arijeet.model.PaySlip;
import com.arijeet.model.TaxRate;
import com.arijeet.model.TaxRates;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayslipService {

  public static void calculate(Employee emp) {
      emp.setPaySlip(new PaySlip());
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
       BigDecimal annualTax = new BigDecimal(0);
        TaxRates taxRates;
        BigDecimal minRange;
        BigDecimal maxRange;

       taxRates = TaxRateMapper.getTaxRates(country);
       for (TaxRate taxRate: taxRates.getTaxRates()) {
        String[] taxRange=taxRate.getTaxSlab().split("-");
        if(taxRange.length>1) {
            minRange = new BigDecimal(taxRange[0]);
            maxRange = new BigDecimal(taxRange[1]);
            if (annualSalary.compareTo(maxRange) > 0) {
                annualTax = annualTax.add(getTax(maxRange, minRange, taxRate.getTaxPercent()));
            } else {
                annualTax = annualTax.add(getTax(annualSalary, minRange, taxRate.getTaxPercent()));
                break;
            }
        } else {
            minRange = new BigDecimal(taxRate.getTaxSlab());
            annualTax = annualTax.add(getTax(annualSalary, minRange, taxRate.getTaxPercent()));
        }
       }

        return annualTax.divide(new BigDecimal(12),2, RoundingMode.HALF_UP);
    }

    private static BigDecimal getTax(BigDecimal upperBound, BigDecimal lowerBound, double taxRate) {
     return upperBound.subtract(lowerBound).multiply(new BigDecimal(taxRate));
    }
}

