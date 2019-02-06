/**
 * SortableList.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h04;

import java.util.Comparator;

/**
 * Creates a sortable data structure using a doubly linked list with nodes.
 * @author Emeri Joe Dingal. Recieved help from Kason Shiroma, Kade shiroma, and Angeli Amascual.
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {

  DLinkedNode head;
  DLinkedNode tail;
  private int size;
  private int swaps;
  private int comparisons;
  private double sortTime;


  /**
   * A constructor that initializes the variables size, head, and tail.
   * 
   * @author Emeri Joe Dingal
   *
   */
  public SortableList() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  /**
   * The node that is doubly linked
   * @author Emeri Joe Dingal
   *
   */
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;


    /**
     * Constructor for Doubly linked nodes
     * @param item the data
     * @param next the next node
     * @param prev the previous node
     */ 
    public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#insertionSort(java.util.Comparator)
   */
  @Override
  public void insertionSort(Comparator<E> compare) {
    for (int nextPos = 1; nextPos < size; nextPos++) {
      E nextVal = get(nextPos); // stores the second element in array
      comparisons += 1;
      while (nextPos > 0 && compare.compare(nextVal, get(nextPos - 1)) < 0) { // compares to the element before it
        set(nextPos, get(nextPos -1));
        swaps += 1;
        if (comparisons != 1)
          comparisons += 1;
        nextPos--; // checks the next smaller element
      }
      set(nextPos,  nextVal); // inserts element into correct place after room is made
    }

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#bubbleSort(java.util.Comparator)
   */
  @Override
  public void bubbleSort(Comparator<E> compare) {

    boolean swapsMade;
    do { // this block from Dr. Moore's screencast sudo code
      swapsMade = false;
      for (int index = 0; index < size - 1; index++) {
        comparisons += 1;
        swaps = 0;
        if ((compare.compare(get(index), get(index + 1)) > 0)) {
          E temp = get(index);
          set(index, get(index + 1));
          set(index + 1, temp);
          swaps += 1;
          swapsMade = true;
        }
      }
    }
    while (swapsMade);

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#selectionSort(java.util.Comparator)
   */
  @Override
  public void selectionSort(Comparator<E> compare) {

    { // this block a mix from Textbook and Dr. Moore
      int n = size;
      for (int fill = 0; fill < n - 1; fill++) {
        int posMin = fill;
        for (int next = fill + 1; next < n; next++) {
          comparisons += 1;
          if (compare.compare((get(next)), (get(posMin))) < 0) {
            posMin = next;
            swaps += 1;
          }
        }
        E temp = get(fill);
        set(fill, get(posMin));
        set(posMin, temp);
      }
    }

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#getNumberOfSwaps()
   */
  @Override
  public int getNumberOfSwaps() {
    // TODO Auto-generated method stub
    return swaps;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#getNumberOfComparisons()
   */
  @Override
  public int getNumberOfComparisons() {
    // TODO Auto-generated method stub
    return comparisons;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.ISortableList#getSortTime()
   */
  @Override
  public double getSortTime() {
    // TODO Auto-generated method stub
    return sortTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#get(int)
   */
  @Override
  public E get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    else {
      DLinkedNode temp = head;
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
      return temp.item;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#set(int, java.lang.Object)
   */
  @Override
  public E set(int index, E element) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    else {
      DLinkedNode temp = head;
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
      E retVal = temp.item;
      temp.item = element;
      return retVal;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#indexOf(java.lang.Object)
   */
  @Override
  public int indexOf(Object obj) {
    DLinkedNode temp = head;
    for (int i = 0; i < size; i++) {
      if(temp.item.equals(obj)) 
        return i;
      temp = temp.next;
    }
    return -1;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#size()
   */
  @Override
  public int size() {
    return size;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#add(java.lang.Object)
   */
  @Override
  public boolean add(E e) {
    if (head == null ) {
      head = new DLinkedNode(e, null, null);
      tail = head;
    }
    else {
      tail.next = new DLinkedNode (e, null, tail.prev);
      tail = tail.next;
    }
    
    size++;
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#add(int, java.lang.Object)
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    else {
      if (index == 0) {
        head = new DLinkedNode(element, null, head.next);
        size ++;
      }
      else {
        DLinkedNode temp = head;
        for (int i = 0; i < index - 1; i++) {
          temp = temp.next;
        }
        temp.next = new DLinkedNode(element, temp.next, temp.prev);
        size++;
      }
    }

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h04.IList211#remove(int)
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      E oldVal = head.item;
      head = head.next;
      size--;
      return oldVal;
    }
    else {
      DLinkedNode temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      E removed = temp.next.item;
      temp.next = temp.next.next;
      size--;
      return removed;
    }
  }

}
