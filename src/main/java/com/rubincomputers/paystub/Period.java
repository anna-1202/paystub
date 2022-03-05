package com.rubincomputers.paystub;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Period implements Serializable {


    private static final long serialVersionUID = -8724124506895366897L;

    private LocalDate date;
    private LocalTime hours;


    public Period(LocalDate date, LocalTime hours) {
        this.date = date;
        this.hours = hours;

    }

    public String toString() {
        return "Day: " + this.date + " " +  " Hours: " + this.hours;


    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHours() {
        return hours;
    }
}
