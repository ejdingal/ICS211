/**
 * ArraySorter.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h02;

import java.util.Comparator;

/**
 * This class sorts arrays in three different ways and reports the number of comparisons, swaps, and sort times.
 * Received help from TA, worked with Angeli Amascual.
 * 
 * @author Emeri Joe Dingal
 * @param <E> A generic type.
 *
 */
public class ArraySorter<E> implements SortableArray<E> {
  private double sortTime;
  private int swaps;
  private int comparisons;


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#insertionSort(java.lang.Object[], java.util.Comparator)
   */
  @Override
  public void insertionSort(E[] data, Comparator<E> compare) {
    // TODO Auto-generated method stub
    double startTime = System.nanoTime();
    swaps = 0; // reset swap counter
    comparisons = 0; // reset comparison counter
    { // this block from textbook and modified
      for (int nextPos = 1; nextPos < data.length; nextPos++) {
        E nextVal = data[nextPos]; // stores the second element in array
        comparisons += 1;
        while (nextPos > 0 && compare.compare(nextVal, data[nextPos - 1]) < 0) { // compares to the element before it
          data[nextPos] = data[nextPos - 1]; // if element before was smaller, swap them
          swaps += 1;
          if (comparisons != 1)
            comparisons += 1;
          nextPos--; // checks the next smaller element
        }
        data[nextPos] = nextVal; // inserts element into correct place after room is made
      }
    }

    sortTime = System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#bubbleSort(java.lang.Object[], java.util.Comparator)
   */
  @Override
  public void bubbleSort(E[] data, Comparator<E> compare) {
    // TODO Auto-generated method stub
    swaps = 0; // reset swap counter
    comparisons = 0; // reset comparison counter
    double startTime = System.nanoTime();

    boolean swapsMade;
    do { // this block from Dr. Moore's screencast sudo code
      swapsMade = false;
      for (int index = 0; index < data.length - 1; index++) {
        comparisons += 1;
        swaps = 0;
        if ((compare.compare(data[index], data[index + 1]) > 0)) {
          E temp = data[index];
          data[index] = data[index + 1];
          data[index + 1] = temp;
          swaps += 1;
          swapsMade = true;
        }
      }
    }
    while (swapsMade);
    sortTime = System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#selectionSort(java.lang.Object[], java.util.Comparator)
   */
  @Override
  public void selectionSort(E[] data, Comparator<E> compare) {
    // TODO Auto-generated method stub
    swaps = 0; // reset swap counter
    comparisons = 0; // reset comparison counter
    long startTime = System.nanoTime();
    { // this block a mix from Textbook and Dr. Moore
      int n = data.length;
      for (int fill = 0; fill < n - 1; fill++) {
        int posMin = fill;
        for (int next = fill + 1; next < n; next++) {
          comparisons += 1;
          if (compare.compare((data[next]), (data[posMin])) < 0) {
            posMin = next;
            swaps += 1;
          }
        }
        E temp = data[fill];
        data[fill] = data[posMin];
        data[posMin] = temp;
      }
    }

    sortTime = System.nanoTime() - startTime;

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#getNumberOfSwaps()
   */
  @Override
  public int getNumberOfSwaps() {
    // TODO Auto-generated method stub
    return swaps;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#getNumberOfComparisons()
   */
  @Override
  public int getNumberOfComparisons() {
    // TODO Auto-generated method stub
    return comparisons;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h02.SortableArray#getSortTime()
   */
  @Override
  public double getSortTime() {
    // TODO Auto-generated method stub
    return sortTime;
  }

}
