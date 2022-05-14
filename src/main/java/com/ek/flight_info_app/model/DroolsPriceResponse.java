package com.ek.flight_info_app.model;

public class DroolsPriceResponse {
    private double basePrice;
    private double adjustment;

    public double calculate() {
        return basePrice + adjustment;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }

}
