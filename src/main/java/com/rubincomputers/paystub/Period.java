package com.rubincomputers.paystub;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

public class Period implements Serializable {


    private static final long serialVersionUID = -8724124506895366897L;

    private LocalDate date;
    private Duration duration;


    public Period(LocalDate date, Duration duration) {
        this.date = date;
        this.duration = duration;

    }

    public String toString() {
        return "Day: " + this.date + " " +  " Hours: " + this.duration;


    }

    public LocalDate getDate() {
        return date;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getHoursMinutes(){
        return duration.toHours() + ":" + duration.toMinutesPart();
    }
}
