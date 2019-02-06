/**
 * CircularDoublyLinkedList.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h05;

import java.util.Iterator;

/**
 * @author Emeri Joe Dingal. Worked with Kade Shirmoma && Kason Shiroma, Got help from Angeli Amascual.
 *
 */
public class CircularDoublyLinkedList<E> implements IList211, Iterable {

  private int size;
  DLinkedNode head;
  DLinkedNode tail;


  @SuppressWarnings("unchecked")
  public CircularDoublyLinkedList(E[] items) {
    this.head = null;
    this.tail = null;
    this.size = 0;
    for (E Identifier : items) {
      add(items);
    }
  }


  public CircularDoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * The node that is doubly linked
   * 
   * @author Emeri Joe Dingal
   *
   */
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;


    /**
     * Constructor for Doubly linked nodes
     * 
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

  public class CircularDoublyLinkedListIterator implements ListIterator {

    /*
     * (non-Javadoc)
     * 
     * @see edu.ics211.h05.ListIterator#hasNext()
     */
    @Override
    public boolean hasNext() {
      if (size > 0)
        return true;
      return false;
    }


    /*
     * (non-Javadoc)
     * 
     * @see edu.ics211.h05.ListIterator#hasPrevious()
     */
    @Override
    public boolean hasPrevious() {
      if (this.previous() != null)
        return true;
      return false;
    }


    /*
     * (non-Javadoc)
     * 
     * @see edu.ics211.h05.ListIterator#next()
     */
    @Override
    public Object next() {
      return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see edu.ics211.h05.ListIterator#nextIndex()
     */
    @Override
    public int nextIndex() {
      // TODO Auto-generated method stub
      return 0;
    }


    /*
     * (non-Javadoc)
     * 
     * @see edu.ics211.h05.ListIterator#previous()
     */
    @Override
    public Object previous() {
      // TODO Auto-generated method stub
      return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see edu.ics211.h05.ListIterator#previousIndex()
     */
    @Override
    public int previousIndex() {
      // TODO Auto-generated method stub
      return 0;
    }


    /*
     * (non-Javadoc)
     * 
     * @see edu.ics211.h05.ListIterator#remove()
     */
    @Override
    public void remove() {
      // TODO Auto-generated method stub

    }


    /*
     * (non-Javadoc)
     * 
     * @see edu.ics211.h05.ListIterator#set(java.lang.Object)
     */
    @Override
    public void set(Object e) {
      // TODO Auto-generated method stub

    }

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h05.IList211#get(int)
   */
  @Override
  public Object get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    else {
      DLinkedNode temp = head;
      ListIterator<E> itr = (ListIterator<E>) temp;
      while (itr.nextIndex() != index) {
        temp = (CircularDoublyLinkedList<E>.DLinkedNode) itr.next();
      }
      temp = (CircularDoublyLinkedList<E>.DLinkedNode) itr.next();
      return temp;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h05.IList211#set(int, java.lang.Object)
   */
  @Override
  public Object set(int index, Object element) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    else {
      DLinkedNode temp = head;
      ListIterator<E> itr = (ListIterator<E>) temp;
      DLinkedNode ret = null;
      while (itr.nextIndex() != index) {
        temp = (CircularDoublyLinkedList<E>.DLinkedNode) itr.next();
        ret = temp;
      }
      temp.item = (E) element;
      return ret;
    }

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h05.IList211#indexOf(java.lang.Object)
   */
  @Override
  public int indexOf(Object obj) {
    DLinkedNode temp = head;
    ListIterator<E> itr = (ListIterator<E>) temp;
    while (!itr.equals(obj)) {
      itr.next();
      if (itr.equals(obj)) {
        itr.previous();
        return itr.nextIndex();
      }
    }
    return -1;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h05.IList211#size()
   */
  @Override
  public int size() {
    return size;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h05.IList211#add(java.lang.Object)
   */
  @Override
  public boolean add(Object e) {
    if (head == null) {
      head = new DLinkedNode((E) e, tail, tail);
      tail = head;
      size++;
      return true;
    }
    tail.next = new DLinkedNode((E) e, head, tail);
    tail = tail.next;
    size++;
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h05.IList211#add(int, java.lang.Object)
   */
  @Override
  public void add(int index, Object element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    else {
      if (index == 0) {
        head.prev = new DLinkedNode((E) element, head, tail);
        head = head.prev;
        size++;
      }
      if (index == size) {
        add(element);
      }
      else {
        DLinkedNode temp = head;
        ListIterator<E> itr = (ListIterator<E>) temp;
        while (itr.nextIndex() != index - 1) {
          temp = (CircularDoublyLinkedList<E>.DLinkedNode) itr.next();
        }
        temp.next = new DLinkedNode((E) element, temp, temp.next.next);
        size++;

      }
    }

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h05.IList211#remove(int)
   */
  @Override
  public Object remove(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    // cycle through list index amount of times
    // remove method only returns last element returned by itr.next()
    return null;
  }


  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator iterator() {
    return (Iterator) new CircularDoublyLinkedListIterator();
  }
}
