package com.ek.flight_info_app.model;

public class DroolsPriceRequest {
    private String flightNumber;
    private char firstLetter;

    public char getFirstLetter() {
        return flightNumber.toLowerCase().charAt(0);
    }

    private int month;
    private int day;
    private int dayOfWeek;

    public String getFlighNumber() {
        return flightNumber;
    }

    public void setFlighNumber(String flighNumber) {
        this.flightNumber = flighNumber;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
