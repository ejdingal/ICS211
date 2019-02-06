/**
 * CircularArrayQueue.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h07;

import java.util.NoSuchElementException;

/**
 * @author Emeri Joe Dingal
 *
 */
public class CircularArrayQueue<E> implements Queue211<E> {

  int front;
  int back;
  final int MAX_CAPACITY = 8;
  static int size;
  E[] data;


  public CircularArrayQueue() {
    data = (E[]) new Object[MAX_CAPACITY];
    this.front = 0;
    this.back = 0;
    this.size = 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#add(java.lang.Object)
   */
  @Override
  public boolean add(E e) {
    if (size == MAX_CAPACITY) {
      throw new IllegalStateException();
    }
    data[back] = e;
    back = (back + 1) % MAX_CAPACITY;
    size += 1;
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#element()
   */
  @Override
  public E element() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[front];
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#offer(java.lang.Object)
   */
  @Override
  public boolean offer(E e) {
    if (size == MAX_CAPACITY) {
      return false;
    }
    data[back] = e;
    back = (back + 1) % MAX_CAPACITY;
    size += 1;
    return true;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#peek()
   */
  @Override
  public E peek() {
    if (size == 0) {
      return null;
    }
    return data[front];
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#poll()
   */
  @Override
  public E poll() {
    if (size == 0) {
      return null;
    }
    
    E temp = data[front];
    
    front = (front + 1) % MAX_CAPACITY;
    size -= 1;
    return temp;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h07.Queue211#remove()
   */
  @Override
  public E remove() {

    if (size == 0) {
      throw new NoSuchElementException();
    }
    
    E temp = data[front];
    
    front = (front + 1) % MAX_CAPACITY;
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
    return size;
  }

}
