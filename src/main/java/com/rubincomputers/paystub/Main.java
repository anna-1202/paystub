package com.rubincomputers.paystub;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        showTotal(readData());

        while (true) {
            Menu.showMenu();

        }

    }

    public static void addData() {
        String dateEntered = "";
        List<Period> list = readData();
        Scanner keyboard = new Scanner(System.in);

        while (true) {

            System.out.println("enter date: MONTH.DAY");
            dateEntered = keyboard.next();
            if (dateEntered.equals("0")) {
                break;
            }

            LocalDate date = stringToLocalDate(dateEntered);

            System.out.println("You entered day: " + date);

            System.out.println("Enter hours, press enter and enter minutes and press enter.");
            int hours = keyboard.nextInt();
            int minutes = keyboard.nextInt();

            LocalTime time = LocalTime.of(hours, minutes);


            list.add(new Period(date, time));
            saveData(list);

        }


    }

    public static void deleteData() {
        List<Period> list = readData();
        showDataLineIndex(list);
        System.out.println("Press the number you want to delete");
        int indexToDelete = Menu.getInput();
        list.remove(indexToDelete);
        saveData(list);


    }

    private static LocalDate stringToLocalDate(String dateStr) {
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

    public static void saveData(List<Period> list) {
        try {
            FileOutputStream fos = new FileOutputStream("database.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.flush();
            oos.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    /**
     * reads info from file
     *
     * @return all data from file
     */
    public static List<Period> readData() {
        List<Period> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("database.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            list = (List<Period>) object;

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

        return list;
    }


    private static void showData(List<Period> list, boolean... options) {

        boolean showIndex = options.length > 0 ? options[0] : false;

        boolean showTable = options.length > 1 ? options[1] : false;

        if (showTable) {
            if (showIndex) {
                System.out.print("index ");
            }
            System.out.println("  from    to  hours");
            System.out.println("--------------------------");
            for (int i = 0; i < list.size(); i++) {
                if (showIndex) {
                    System.out.print(i + ". ");
                }

                System.out.println(list.get(i).getDate() + " " + list.get(i).getHours());

            }


        } else {
            for (int i = 0; i < list.size(); i++) {
                if (showIndex) {
                    System.out.print(i + " .");
                }

                System.out.println(list.get(i));
            }

        }
        System.out.println();

    }

    public static void showDataTable(List<Period> list) {
        showData(list, false, true);
    }

    public static void showDataLineIndex(List<Period> list) {
        showData(list, true, false);
    }

    public static void showTotal(List<Period> list) {
        LocalTime total = LocalTime.now();
        System.out.println(total );
        total = total.plusHours(3);
        System.out.println(total );

        for (int i = 0; i <list.size() ; i++) {

            //total = total + list.get(i).getHours();

        }
    }
}
