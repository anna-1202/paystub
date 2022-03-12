package com.rubincomputers.paystub;

import java.util.Scanner;

public class Menu {
    public static void showMenu() {
        System.out.println("1 - Show the list");
        System.out.println("2 - Add new data. Use 0 to stop entering info");
        System.out.println("3 - Delete data from the list");
        System.out.println("4 - Data Analyzer Menu");
        System.out.println("5 Exit");
        System.out.println();

        int number = getInput();
        runSelected(number);

    }

    public static int getInput() {
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        return number;
    }

    public static void runSelected(int number) {
        switch (number) {
            case 1:
                MainFunctions.showDataTable(MainFunctions.readData());

                break;
            case 2:
                MainFunctions.addData();
                break;
            case 3:
                MainFunctions.deleteData();
                break;
            case 4:
                showAnalyzeMenu();
                break;
            case 5:
                System.exit(0);
                break;
            case 6:
                View.showTotal(MainFunctions.readData());
                break;
            case 7:
                View.monthlyGoal(MainFunctions.readData());
                break;
            case 8:
                showMenu();
                break;
            default:
                showMenu();

        }

    }

    private static void showAnalyzeMenu() {
        System.out.println("6 - Yearly hours worked");
        System.out.println("7 - Monthly hours worked");
        System.out.println("8 - Back to previous menu");
        System.out.println();

        int number = getInput();
        runSelected(number);
    }
}
