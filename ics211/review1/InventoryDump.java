package edu.ics211.review1;

import java.util.LinkedList;

/**
 * Inventory dump.
 * @author you
 */
public class InventoryDump {
  
//  Objectives:
//  1) create a method called printConsoleInventory that takes a LinkedList of VideoGameConsoles
//     as a parameter and prints the information about all the VideoGameConsoles in the list. 
//     For each VideoGameConsole in the list, it should print out:
//         -manufacturer
//         -model and submodel
//         -price
//  2) Create a main method and test your printConsoleInventory method on the GameStop console
//     inventory. The output should be the following:
//  
//     Microsoft
//     Xbox One X
//     $499.99
//
//     Microsoft
//     Xbox One S
//     $299.99
//
//     Sony
//     Playstation 4 Pro
//     $399.99

  public static void main(String[] args) {
    GameStop store = new GameStop();
    printConsoleInventory(store.getConsoleInventory());
  }
  
  public static void printConsoleInventory(LinkedList<VideoGameConsole> consoles) {
    int size = consoles.size();
    for(int i = 0; i < size; i++) {
      System.out.print(consoles.get(i).getModel() + " ");
      System.out.println(consoles.get(i).getSubmodel());
      System.out.println(consoles.get(i).getPrice());
      System.out.println("\n");
    }
  }
}
