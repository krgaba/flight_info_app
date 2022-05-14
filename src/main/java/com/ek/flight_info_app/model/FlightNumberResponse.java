package com.ek.flight_info_app.model;

public class FlightNumberResponse {
    private String flightNumber;

    public FlightNumberResponse(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
