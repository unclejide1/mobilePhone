package com.decagonhq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {
        boolean quit = false;
//        int choice = 0;
        startPhone();
        printInstructions();
        while (!quit){
            System.out.print("\nEnter action: (6 to show available actions) ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("shutting phone down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addNewContacts();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                   printInstructions();
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\n Available actions: \nPress ");
        System.out.println("\t 0 - To Shutdown");
        System.out.println("\t 1 - To print contacts");
        System.out.println("\t 2 - To add a new contact");
        System.out.println("\t 3 - To update an existing contact");
        System.out.println("\t 4 - To remove an existing contact");
        System.out.println("\t 5 - To search if a contact exists");
        System.out.println("\t 6 - To print list of available actions");
    }

    public static void addNewContacts(){
        System.out.print("Please enter new contact name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter contact Phone number: ");
        String number = scanner.nextLine();
        Contacts contact = new Contacts(name, number);
        if(mobilePhone.addContacts(contact)){
            System.out.println("New contact added: name = " + name  + ", phone = " + number);
        }else {
            System.out.println("Cannot add, " + name  + ", phone = " + number + " already on file" );
        }

    }

    public static void startPhone(){
        System.out.println("Switching phone on");
    }

    public static void modifyContact(){
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println(" Contact not found");
            return;
        }
        System.out.print("Please enter new contact name: ");
        String contactName = scanner.nextLine();
        System.out.print("Please enter contact Phone number: ");
        String number = scanner.nextLine();
        Contacts contact = new Contacts(contactName, number);
       if(mobilePhone.modifyContacts(existingContact, contact)){
           System.out.println("Successfully updated contact");
       }else{
           System.out.println("Error updating record");
       }
    }

    public static void removeContact(){
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println(" Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContact)){
            System.out.println("Successfully removed contact");
        }else{
            System.out.println("Error removing record");
        }
    }

    public static void searchForContact(){
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println(" Contact not found");
            return;
        }
        System.out.print("Name: " + existingContact.getName() + " phone number is " + existingContact.getPhoneNo() + " exists");
    }

}
