package com.arijeet.model;

import java.math.BigDecimal;

public class PaySlip {
    private BigDecimal grossMonthlyIncome;
    private BigDecimal monthlyIncomeTax;
    private BigDecimal netMonthlyIncome;

    public BigDecimal getGrossMonthlyIncome() {
        return grossMonthlyIncome;
    }

    public void setGrossMonthlyIncome(BigDecimal grossMonthlyIncome) {
        this.grossMonthlyIncome = grossMonthlyIncome;
    }

    public BigDecimal getMonthlyIncomeTax() {
        return monthlyIncomeTax;
    }

    public void setMonthlyIncomeTax(BigDecimal monthlyIncomeTax) {
        this.monthlyIncomeTax = monthlyIncomeTax;
    }

    public BigDecimal getNetMonthlyIncome() {
        return netMonthlyIncome;
    }

    public void setNetMonthlyIncome(BigDecimal netMonthlyIncome) {
        this.netMonthlyIncome = netMonthlyIncome;
    }

    @Override
    public String toString() {
        return "Gross Monthly Income: $"+grossMonthlyIncome+"\n"+
                "Monthly Income Tax: $"+ monthlyIncomeTax +"\n"+
                "Net Monthly Income: $"+netMonthlyIncome;
    }
}
