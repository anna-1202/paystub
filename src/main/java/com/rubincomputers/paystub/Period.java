package com.rubincomputers.paystub;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

public class Period implements Serializable {


    private static final long serialVersionUID = -8724124506895366897L;

    private LocalDate date;
    private Duration hours;


    public Period(LocalDate date, Duration hours) {
        this.date = date;
        this.hours = hours;

    }

    public String toString() {
        return "Day: " + this.date + " " +  " Hours: " + this.hours;


    }

    public LocalDate getDate() {
        return date;
    }

    public Duration getHours() {
        return hours;
    }
}
