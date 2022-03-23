package com.rubincomputers.paystub;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class View {
    public static LocalDate stringToLocalDate(String dateStr) {
        String dateSplit[] = dateStr.split("\\.");

        int month = Integer.parseInt(dateSplit[0]);
        int day = Integer.parseInt(dateSplit[1]);
        int year = LocalDate.now().getYear();

        LocalDate date = null;
        try {
            date = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            System.out.println("wrong date entered");
        }

        return date;

    }

    public static void showTotal(List<Period> list) {
        Duration total = Duration.ZERO;
        for (int i = 0; i < list.size(); i++) {
            total = total.plus(list.get(i).getDuration());
        }
        System.out.println("Total hours worked: " + durationToString(total));
    }

    public static void monthlyGoal(List<Period> list) {
        Duration monthlyGoal = Duration.ofHours(129);
        Duration monthlySum = Duration.ZERO;

        for (int j = 1; j <= Month.values().length; j++) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDate().getMonth() == Month.of(j)) {
                    monthlySum = monthlySum.plus(list.get(i).getDuration());
                }
            }
            if (monthlySum.toHours() != 0) {
                Duration current = monthlyGoal.minus(monthlySum);
                System.out.println(Month.of(j) + " " + durationToString(monthlySum)
                + " Hours remained: " + (durationToString(current)));
            }
            monthlySum = Duration.ZERO;
        }

        System.out.println();
    }

    public static String durationToString(Duration d){
        return d.toHours() + ":" +d.toMinutesPart();
    }
}
