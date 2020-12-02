package com.arijeet.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.ArrayList;
import java.util.List;

public class TaxRates {
    List<TaxRate> taxRates=new ArrayList<>();

    @JsonAnySetter
    public void setTaxRates(String taxSlabs, float taxPercent) {
        taxRates.add(new TaxRate(taxSlabs, taxPercent));
    }

    public List<TaxRate> getTaxRates() {
        return taxRates;
    }

    @Override
    public String toString() {
        return "TaxRates{" +
                "taxRates=" + taxRates +
                '}';
    }
}
