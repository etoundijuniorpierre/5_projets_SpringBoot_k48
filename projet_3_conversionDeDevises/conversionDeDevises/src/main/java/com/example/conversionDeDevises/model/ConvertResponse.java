package com.example.conversionDeDevises.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class ConvertResponse {
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double amount;  // <-- Ajout du champ amount
    private int conversion_result;

    // Constructeur
    public ConvertResponse(String base_code, String target_code, double conversion_rate, double amount, int conversion_result) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.amount = amount;
        this.conversion_result = conversion_result;
    }



    // Getters et Setters
    public String getBase_code() { return base_code; }
    public void setBase_code(String base_code) { this.base_code = base_code; }

    public String getTarget_code() { return target_code; }
    public void setTarget_code(String target_code) { this.target_code = target_code; }

    public double getConversion_rate() { return conversion_rate; }
    public void setConversion_rate(double conversion_rate) { this.conversion_rate = conversion_rate; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public int getConversion_result() { return conversion_result; }
    public void setConversion_result(int conversion_result) { this.conversion_result = conversion_result; }
}

