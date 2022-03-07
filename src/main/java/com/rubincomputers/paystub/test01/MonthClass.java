package com.rubincomputers.paystub.test01;

public class MonthClass {
    public static final MonthClass JANUARY = new MonthClass("JANUARY");
    public static final MonthClass FEBRUARY = new MonthClass("FEBRUARY");
    public static final MonthClass MARCH = new MonthClass("MARCH");


    private String name;


    public MonthClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(MonthClass.JANUARY == MonthClass.FEBRUARY);
        System.out.println(MonthClass.JANUARY);
    }
}
