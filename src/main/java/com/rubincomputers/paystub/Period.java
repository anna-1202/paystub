package com.rubincomputers.paystub;

import java.io.Serializable;
import java.time.LocalDate;

public class Period implements Serializable {


    private static final long serialVersionUID = -8724124506895366897L;

    private LocalDate startDate;
    private LocalDate endDate;
    private int hours;

    public Period(LocalDate startDate, LocalDate endDate, int hours) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hours = hours;

    }

    public String toString() {
        return "From: " + this.startDate + " " + "To: " + this.endDate + " Hours: " + this.hours;


    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getHours() {
        return hours;
    }
}
