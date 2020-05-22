/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import linkedlist.LinkedList;
import java.io.FileReader;


/**
 *
 * @author Che-Wei Chou
 */
public class Driver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        //Object obj = new JSONParser().parse(new FileReader("IDedObjects.json"));

        int choice;

        do {
            //Print out all options
            System.out.println("Operations on List:");
            System.out.println("1. Make Empty");
            System.out.println("2. Find ID");
            System.out.println("3. Insert At Front");
            System.out.println("4. Delete From Front");
            System.out.println("5. Delete ID");
            System.out.println("6. Print All Records");
            System.out.println("7. Done");

            //Ask for a valid choice from user
            System.out.print("Your Choice: ");
            choice = isInt(keyboard);
            while (choice < 1 || choice > 7) { //If number entered is not one of the options
                System.out.println("The number you entered is not a valid choice.");
                System.out.print("Please enter a choice that is on the list: ");
                choice = isInt(keyboard);
            }

            switch (choice) {
                case 1: //Empty the list
                    if (list.isEmpty()) {
                        System.out.println("List is already empty.\n");
                    } else {
                        list.clearList();
                        System.out.println("Emptied.\n");
                    }
                    break;
                case 2: //Find a magazine in the list hbased on user ID
                    System.out.print("Enter ID: ");
                    int id = isInt(keyboard);
                    if (!list.contains(id)) {
                        System.out.println(id + " not found.\n");
                    } else {
                        Magazine mag = (Magazine) list.getIDedObject(id);
                        System.out.println(mag);
                    }
                    //System.out.println();
                    break;
                case 3:
                    //Ask user for magazine data and create a new magazine
                    //Also make sure magazine ID is an integer
                    System.out.print("Enter Magazine ID: ");
                    id = isInt(keyboard);
                    keyboard.nextLine();
                    System.out.print("Enter Magazine Name: ");
                    String name = keyboard.nextLine();
                    System.out.print("Enter Publisher name: ");
                    String publisher = keyboard.nextLine();
                    Magazine mag = new Magazine(id, name, publisher);
                    //Add the created magazine to the front of the list
                    list.addFirst(mag);

                    System.out.println("Magazine Added\n");
                    break;
                case 4: //Delete the first item fro the list
                    if (list.isEmpty()) {
                        System.out.println("List is already empty.\n");
                    } else {
                        System.out.println(list.deleteFirst());
                        System.out.println("Deleted.\n");
                    }
                    break;
                case 5:
                    //Delete the designated item from th list
                    System.out.print("Enter ID: ");
                    id = isInt(keyboard);
                    if (!list.contains(id)) {
                        System.out.println(id + " not found.\n");
                    } else {
                        System.out.println(list.deleteSearch(id));
                        System.out.println("Deleted.\n");
                    }
                    break;
                case 6:
                    
                    System.out.print(list);
                    if (list.isEmpty())System.out.println("There are no records\n");
                    break;
            }
        } while (choice != 7);
        
        list.WriteJSON();

        System.out.println("Done.");

    }

    /**
     * Keep asking until the input is an integer
     *
     * @param key Scanner must be created, connected to System.in
     * @return the integer from the user input.
     */
    public static int isInt(Scanner key) {
        while (!key.hasNextInt()) {
            //key.nextLine();
            String notAnInt = key.nextLine();
            System.out.println("\n" + notAnInt + " is not an integer.");
            System.out.print("Please enter an integer: ");
        }
        return key.nextInt();
    }
    
    
}
