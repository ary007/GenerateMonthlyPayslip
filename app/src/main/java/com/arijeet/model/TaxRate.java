package com.arijeet.model;

public class TaxRate {

    private String taxSlab;
    private float taxPercent;

    public TaxRate(String taxSlab, float taxPercent) {
        this.taxSlab = taxSlab;
        this.taxPercent = taxPercent;
    }

    public String getTaxSlab() {
        return taxSlab;
    }

    public void setTaxSlab(String taxSlab) {
        this.taxSlab = taxSlab;
    }

    public float getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(float taxPercent) {
        this.taxPercent = taxPercent;
    }

    @Override
    public String toString() {
        return "TaxRate{" +
                "taxSlab='" + taxSlab + '\'' +
                ", taxPercent='" + taxPercent + '\'' +
                '}';
    }
}