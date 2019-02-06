/**
 * ISortableList.java
 */
package edu.ics211.h04;

import java.util.Comparator;

/**
 * This interface uses the list data structure to hold data and makes it sortable
 * 
 * @author Emeri Joe Dingal
 *
 * @param <E> a generic
 */
public interface ISortableList<E> {
  /**
   * This method sorts a data structure using the insertion sort algorithm
   * 
   * @param compare a comparing too used for sorting
   */
  void insertionSort(Comparator<E> compare);


  /**
   * This method sorts a data structure using the bubble sort algorithm.
   * 
   * @param compare a comparing too used for sorting
   */
  void bubbleSort(Comparator<E> compare);


  /**
   * This method sorts a data structure using the selection sort algorithm.
   * 
   * @param compare a comparing too used for sorting
   */
  void selectionSort(Comparator<E> compare);


  /**
   * This method returns the amount of swaps performed for a given sort algorithm.
   * 
   * @return number of swaps
   */
  int getNumberOfSwaps();


  /**
   * This method returns the number of comparisons for a given sort algorithm.
   * 
   * @return number of comparisons
   */
  int getNumberOfComparisons();


  /**
   * This method returns the time elapsed for a sort method in nano time.
   * 
   * @return time elapsed for a sort
   */
  double getSortTime();
}