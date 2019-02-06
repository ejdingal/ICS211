/**
 * CircularLiostQueue.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h07;

import java.util.NoSuchElementException;

/**
 * A circular queue with an underlying list **did not realize homework required an array**
 * 
 * @author Emeri Joe Dingal
 * 
 */
public class CircularListQueue<E> implements Queue211<E> {

  int size;
  final int MAX_CAPACITY = 20;
  DLinkedNode head;
  DLinkedNode tail;


  public CircularListQueue() {
    this.size = 0;
    this.head = null;
    this.tail = null;
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


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#add(java.lang.Object)
   */
  @Override
  public boolean add(E e) {
    // if queue is empty, make a new queue
    if (size() == 0) { // empty queue
      // make new queue
      head = new DLinkedNode(e, head, tail); // create head
      tail = head; // tail is head
      size += 1; // increment size
    }
    // else if queue is full, throw IllegalStateException
    /* is queue is ever full?? ,, when?? */
    else if (size() == MAX_CAPACITY - 1) { // reached max capacity
      throw new IllegalStateException();
    }
    // else
    else { // stack not full, stack not empty
      // add onto tail of queue, return true
      tail.next = new DLinkedNode(e, head, tail); // add onto tail
      tail = tail.next; // reposition tail
      size += 1; // increment size
    }

    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#element()
   */
  @Override
  public E element() {
    // if queue is empty, throw no such element
    if (size() == 0) {
      throw new NoSuchElementException();
    }
    return head.item;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#offer(java.lang.Object)
   */
  @Override
  public boolean offer(E e) {
    // if queue is empty, make a new queue
    if (size() == 0) { // empty queue
      // make new queue
      head = new DLinkedNode(e, head, tail); // create head
      tail = head; // tail is head
      size += 1; // increment size
    }
    // else if queue is full
    else if (size() == MAX_CAPACITY - 1) {
      return false;
    }
    else {
      tail.next = new DLinkedNode(e, head, tail);
      tail = tail.next;
      size += 1;
    }
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#peek()
   */
  @Override
  public E peek() {
    // TODO Auto-generated method stub
    // same as element, but returns null if queue is empty
    if (size() == 0) {
      return null;
    }
    return head.item;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#poll()
   */
  @Override
  public E poll() {
    // retrieves and removes head of queue, return null if empty
    if (size() == 0) {
      return null;
    }
    E temp = head.item;
    remove();
    return temp;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#remove()
   */
  @Override
  public E remove() {
    if (size() == 0) {
      throw new NoSuchElementException();
    }
    E temp = head.item;
    head = head.next;
    head.prev = tail;
    tail.next = head;
    size -= 1;
    return temp;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#size()
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    // return size of queue;
    return size;
  }

}
