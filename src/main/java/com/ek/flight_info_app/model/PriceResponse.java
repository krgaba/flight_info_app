package com.ek.flight_info_app.model;

public class PriceResponse {
    private double price;

    public PriceResponse(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
