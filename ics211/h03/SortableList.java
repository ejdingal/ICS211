/**
 * SortableList.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Emeri Joe Dingal. This class creates a portable list that uses the four main aspects of a list data
 * structure.
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {

  private E[] data;
  private int amount;

  private double sortTime;
  private int swaps;
  private int comparisons;


  @SuppressWarnings({ "unchecked" })
  public SortableList() {
    this.data = (E[]) new Object[5];
    this.amount = 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.ISortableList#insertionSort(java.util.Comparator)
   */
  @Override
  public void insertionSort(Comparator<E> compare) {
    // TODO Auto-generated method stub
    double startTime = System.nanoTime();
    if (amount >= 2){ // this block from textbook and modified
      for (int nextPos = 1; nextPos < amount - 1; nextPos++) {
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
   * @see edu.ics211.h03.ISortableList#bubbleSort(java.util.Comparator)
   */
  @Override
  public void bubbleSort(Comparator<E> compare) {
    // TODO Auto-generated method stub
    swaps = 0; // reset swap counter
    comparisons = 0; // reset comparison counter
    double startTime = System.nanoTime();

    boolean swapsMade;
    do { // this block from Dr. Moore's screencast sudo code
      swapsMade = false;
      for (int index = 0; index < amount; index++) {
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
   * @see edu.ics211.h03.ISortableList#selectionSort(java.util.Comparator)
   */
  @Override
  public void selectionSort(Comparator<E> compare) {
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
   * @see edu.ics211.h03.ISortableList#getNumberOfSwaps()
   */
  @Override
  public int getNumberOfSwaps() {
    // TODO Auto-generated method stub
    return swaps;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.ISortableList#getNumberOfComparisons()
   */
  @Override
  public int getNumberOfComparisons() {
    // TODO Auto-generated method stub
    return comparisons;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.ISortableList#getSortTime()
   */
  @Override
  public double getSortTime() {
    // TODO Auto-generated method stub
    return sortTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#get(int)
   */
  @Override
  public E get(int index) {
    // TODO Auto-generated method stub
    if (index < 0 || index > amount) {
      //System.err.println("Index provided out of bounds");
      throw new IndexOutOfBoundsException();
    }
    else {
      return (E)data[index]; // returns element at given index
    }
    
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#set(int, java.lang.Object)
   */
  @Override
  public E set(int index, E element) {
    // TODO Auto-generated method stub
    if (index < 0 || index > amount) {
      throw new IndexOutOfBoundsException();
    }
    else {
      E temp = data[index];
      data[index] = element;
      return temp;
    }

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#indexOf(java.lang.Object)
   */
  @Override
  public int indexOf(Object obj) {
    // TODO Auto-generated method stub
    int index;
    for (index = 0; index < amount; index++) {
      if (data[index] == obj) {
        return index;
      }
    }
    return -1;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#size()
   */
  @Override
  public int size() {
    return amount;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#add(java.lang.Object)
   */
  @Override
  public boolean add(E e) {
    if (data.length == amount) {
      reallocate();
    }
    data[amount] = e;
    amount++;
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#add(int, java.lang.Object)
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > amount) {
      //System.err.println("Index provided out of bounds");
      throw new IndexOutOfBoundsException();
    }
    else {
   // if full
      if (data.length == amount) {
        // reallocate
        reallocate();
      }
      if (amount == 0) {
        data[amount] = element;
        amount++;
      }
      else {
        for (int i = amount; i > index; i--) { // moves everything to the right up to index
          data[i] = data[i - 1];
        }

        // add element at index
        data[index] = element;
        // increase amount
        amount++;
      }
    }
    
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h03.IList211#remove(int)
   */
  @Override
  public E remove(int index) {
    // TODO Auto-generated method stub
    E old = data[index];
    data[index] = null;
    for (int i = index; i < amount; i++) { // moves left to right moving everything left
      data[i] = data[i + 1];
    }
    amount--;
    return old;
  }


  public void reallocate() {

    this.data = Arrays.copyOf(data, amount * 2);
  }

}
