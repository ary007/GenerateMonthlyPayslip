package com.arijeet.model;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private BigDecimal annualSalary;
    private String country;
    private PaySlip paySlip;

    public Employee(String name, BigDecimal annualSalary, String country) {
        this.name = name;
        this.annualSalary = annualSalary;
        this.paySlip = paySlip;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
    }

    public PaySlip getPaySlip() {
        return paySlip;
    }

    public void setPaySlip(PaySlip paySlip) {
        this.paySlip = paySlip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Monthly Payslip for: "+name+"\n"+paySlip;
    }
}
