package com.arijeet.mapper;

import com.arijeet.App;
import com.arijeet.model.TaxRates;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class TaxRateMapper {

    public static TaxRates getTaxRates(String country) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream in;
            if(country.equals("Australia")) {
                in = App.class.getClassLoader()
                        .getResourceAsStream("australia_tax_rates.json");

                return mapper.readValue(in, TaxRates.class);
            }else {
                in = App.class.getClassLoader()
                        .getResourceAsStream("new_zealand_tax_rates.json");

                return mapper.readValue(in, TaxRates.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
