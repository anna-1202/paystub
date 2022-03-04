package com.rubincomputers.paystub;

import java.util.Scanner;

public class Menu {
    public static void showMenu() {
        System.out.println("Enter 1 to show the list");
        System.out.println("Enter 2 to add new data. Use 0 to stop entering info");
        System.out.println("Enter 3 to delete data from the list");
        System.out.println("Enter 4 to exit");
        System.out.println();

        int number = getInput();
        runSelected(number);

    }

    public static int getInput(){
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        return number;
    }

    public static void runSelected(int number){
        switch (number){
            case 1:
                Main.showDataTable(Main.readData());

                break;
            case 2:
                Main.addData();
                break;
            case 3:
                Main.deleteData();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                showMenu();

        }

    }
}
