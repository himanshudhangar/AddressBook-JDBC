package com.AddressBookJdbc;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AddressBookJDBC {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
            System.out.println(" Press\n 1 ->  Retrieve data\n 2 -> Update Address,city,state,zip  by srNo\n " +
                    "3 -> Retrieve data for particular date\n" +
                    "4 -> Retrieve Count of Contacts for City or State\n" +
                    "5 -> exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    retrieveData();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    retrieveDataForParticularDate();
                    break;
                case 4:
                    retrieveCountByCityOrState();
                case 5:
                    exit = true;
            }
        }
    }

    private static void retrieveData() {
        AddressBookSystem addressBookRepo = new AddressBookSystem();
        List<Contact> employeeInfoList = addressBookRepo.retrieveData();
        for (Contact employee : employeeInfoList
        ) {
            System.out.println(employee + "\n");
        }
    }

    private static void update() {
        AddressBookSystem addressBookRepo = new AddressBookSystem();
        System.out.println("Enter the address,city,state, zip and Serial Number  to Update");
        addressBookRepo.updateCityByZip(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt());
    }
    private static void retrieveDataForParticularDate() {
        AddressBookSystem addressBookRepo = new AddressBookSystem();
        System.out.println("Enter the Date of Joining (YYYY-MM-DD");
        System.out.println("Enter year , month and Day ex: 2020 02 03");
        List<Contact> employeeInfoList = addressBookRepo.findAllForParticularDate(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        for (Contact employee : employeeInfoList
        ) {
            System.out.println(employee + "\n");
        }
    }
    private static void retrieveCountByCityOrState() {
        AddressBookSystem addressBookRepo = new AddressBookSystem();
        System.out.println("Enter 1 -> Contacts count by City\n" +
                "2 -> Contacts count by State");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Enter city Name");
                int cityContactsCount = addressBookRepo.countByCiy(scanner.next());
                System.out.println("Number of Contacts is Given city= " + cityContactsCount);
                break;
            case 2:
                System.out.println("Enter state name");
                int stateContactsCount=  addressBookRepo.countByState(scanner.next());
                System.out.println("Number of Contacts is Given state= " + stateContactsCount);
                break;
        }


    }
}