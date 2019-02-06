/**
 * SortableArray.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h02;

import java.util.Comparator;

/**
 * @author Emeri Joe Dingal
 *
 */
public interface SortableArray<E> {
  /**
   * This method will move items over and will leave a gap for an item to be inserted.
   * 
   * @param data an array of objects
   * @param compare used for comparing two objects
   */
  void insertionSort(E[] data, Comparator<E> compare);


  /**
   * This method will search for the largest items and move them over to the right, sorting the array in an ascending
   * order.
   * 
   * @param data an array of objects
   * @param compare used for comparing two objects
   */
  void bubbleSort(E[] data, Comparator<E> compare);


  /**
   * Will find the smallest item in the array and swap it to the first position, then finding the next biggest item and
   * swap it to the next index and so forth.
   * 
   * @param data an array of objects
   * @param compare used for comparing two objects
   */
  void selectionSort(E[] data, Comparator<E> compare);


  /**
   * This method will count the number of times items in an array are swapped.
   * 
   * @return int the number of swaps made.
   */
  int getNumberOfSwaps();


  /**
   * This method will count the number of comparisons made.
   * 
   * @return int the number of comparisons
   */
  int getNumberOfComparisons();


  /**
   * This method will measure how long a method takes in nanoseconds.
   * 
   * @return double the amount of time in nanoseconds
   */
  double getSortTime();
}
