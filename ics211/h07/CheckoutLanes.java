/**
 * CheckoutLanes.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h07;

import java.util.List;

/**
 * Checkout lanes simulated like Foodland.
 * 
 * @author Emeri Joe Dingal. Help from TA
 *
 */
public class CheckoutLanes {
  CircularArrayQueue<Shopper>[] lanes;
  int express = 0;
  int regular = 0;



  /**
   * Creates checkout lanes
   * 
   * @param numExpress number of express lanes
   * @param numRegular number of regular lanes
   */
  public CheckoutLanes(int numExpress, int numRegular) {
    lanes = new CircularArrayQueue[4];
    for (int i = 0; i < numExpress; i++) {
      lanes[i] = new CircularArrayQueue<Shopper>();
      express += 1;
    }
    for (int i = 0; i < numRegular; i++) {
      lanes[i + numExpress] = new CircularArrayQueue<Shopper>();
      regular += 1;
    }
  }


  /**
   * Enters shoppers into lanes
   * 
   * @param laneNumber number of lane
   * @param shopper a shopper
   */
  public void enterLane(int laneNumber, Shopper shopper) {
    switch (laneNumber) {
    case (0): // request to zero
      if (lanes[0].MAX_CAPACITY == lanes[0].size()) { // check if full
        lanes[1].add(shopper); // move over if full
        break;
      }
      lanes[0].add(shopper); // add shopper to line
      break;
    case (1): // request to lane one
      if (lanes[1].MAX_CAPACITY == lanes[1].size()) { // check if full
        lanes[2].add(shopper); // move over if full
        break;
      }
      lanes[1].add(shopper); // add shopper to line
      break;
    case (2): // request to lane two
      if (lanes[2].MAX_CAPACITY == lanes[2].size()) { // check if full
        lanes[3].add(shopper); // move over if full
        break;
      }
      lanes[2].add(shopper); // add shopper to line
      break;
    case (3):
      if (lanes[3].MAX_CAPACITY == lanes[3].size()) { // check if full
        lanes[0].add(shopper); // move over if full
        break;
      }
      lanes[3].add(shopper); // add shopper to line
      break;
    default:
      break;
    }
  }


  /**
   * Simulates checkout procedure
   * 
   * @return a list of shoppers
   */
  public List<Shopper> simulateCheckout() {
    List<Shopper> allPau = null;
    int i = 0;
    do {
      int n = lanes[0].peek().getNumberOfItems();
      if (express >= 1) { // enter in express
        if (n > 10) {
          lanes[1].add(lanes[0].element());
          System.out.println("Express lane shopper with " + n + " items, moved to lane 1");
        }
        allPau.add(lanes[0].poll());
        System.out.println("Express lane 0 shoppwer with " + n + "items");
        break;
      } // end in express
      if (express < 1) {
        allPau.add(lanes[0].poll());
        System.out.println("Regular lane 0 shoppwer with " + n + "items");
      }
    }
    while (lanes[0].poll() != null);

    do {
      int n = lanes[1].peek().getNumberOfItems();
      if (express >= 2) {
        if (n > 10) {
          lanes[2].add(lanes[1].element());
          System.out.println("Express lane shopper with " + n + " items, moved to lane 2");
        }
      }
      if (express < 2) {
        allPau.add(lanes[1].poll());
        System.out.println("Express lane 1 shoppwer with " + n + "items");
      }
    }
    while (lanes[1].poll() != null);

    do {
      int n = lanes[2].peek().getNumberOfItems();
      if (express >= 3) {
        if (n > 10) {
          lanes[3].add(lanes[2].element());
          System.out.println("Express lane shopper with " + n + " items, moved to lane 3");
        }
      }
      if (express < 3) {
        allPau.add(lanes[2].poll());
        System.out.println("Regular lane shopper with " + n + " items");
      }
    }
    while (lanes[2].poll() != null);
    
    do {
      int n = lanes[3].peek().getNumberOfItems();
      if (express >= 3) {
        if (n > 10) {
          lanes[0].add(lanes[2].element());
          System.out.println("Express lane shopper with " + n + " items, moved to lane 0");
        }
      }
      if (express < 3) {
        allPau.add(lanes[3].poll());
        System.out.println("Regular lane shopper with " + n + " items");
      }
    }
    while (lanes[2].poll() != null);

    // ******************************
//    do { // express
//      int n = lanes[i].peek().getNumberOfItems();
//      if (n > 10) { // more than 10
//        lanes[(i + 2) % 4].add(lanes[i].element()); // move to a regular
//        // syso moved shopper
//        System.out.println("Express lane shopper with " + n + " items," + " moved to lane " + lanes[(i + 1) % 2]);
//      }
//      else { // less than 10
//        allPau.add(lanes[i].poll()); // checkout, add to list
//        // syso checkout
//        System.out.println("Express Lane " + i + " shopper with " + n + " items");
//      }
//      i = (i + 1) % 2;
//    }
//    while (lanes[i].poll() != null);
//
//    i = 2;
//    do { // regular
//      int n = lanes[i].element().getNumberOfItems();
//      allPau.add(lanes[i].poll()); // checkout, add to list
//      // syso checkout
//      System.out.println("Express Lane " + i + " shopper with " + n + " items");
//      i = (i + 1) % 2;
//    }
//    while (lanes[i].poll() != null);

    return allPau;

  }
}
