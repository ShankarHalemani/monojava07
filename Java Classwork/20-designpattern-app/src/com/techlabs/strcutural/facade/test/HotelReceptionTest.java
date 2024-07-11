package com.techlabs.strcutural.facade.test;

import com.techlabs.strcutural.facade.model.HotelReception;

import java.util.Scanner;

public class HotelReceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelReception hotelReception = new HotelReception();
        boolean exit = false;
        int chooseMenu;
        while (!exit){
            System.out.println();
            System.out.println("Choose Menu");
            System.out.println("1. Indian Menu");
            System.out.println("2. Italian Menu");
            System.out.println("3. Exit");
            System.out.println();
            chooseMenu=scanner.nextInt();
            switch (chooseMenu){
                case 1:
                    hotelReception.getIndianMenu();
                    break;

                case 2:
                    hotelReception.getItalianMenu();
                    break;

                case 3:
                    exit=true;
                    break;

                default:
                    System.out.println("Enter Valid choice");
                    break;
            }
        }
    }
}
