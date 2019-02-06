/**
 * IList211.java
 */
package edu.ics211.h04;

/**
 * This list uses the features of a list data structure to hold data
 * 
 * @author Emeri Joe Dingal.
 *
 * @param <E> a generic
 */
public interface IList211<E> {
  /**
   * This method returns the element currently at the index provided.
   * 
   * @param index an index provided to get element at this position
   * @return E the element currently at the index
   */
  E get(int index);


  /**
   * Set an element in place of another element in the data structure, returning the old element.
   * 
   * @param index the position of where the element is to go
   * @param element the element to be put in
   * @return E the element currently at the index;
   */
  E set(int index, E element);


  /**
   * This method returns the index of a provided object in the data structure. Returns negative one if not in the array.
   * 
   * 
   * @param obj the element to be searched for in the data structure
   * @return the position of the object
   */
  int indexOf(Object obj);


  /**
   * Returns the size of the list.
   * 
   * @return the size of the list
   */
  int size();


  /**
   * Add an element to the data structure.
   * 
   * @param e the element to be added to the data structure
   * @return boolean as a pass/fail to the add
   */
  boolean add(E e);


  /**
   * Adds an element to a given index of the data structure.
   * 
   * @param index the position which the element is to go into
   * @param element the element which is to be added
   */
  void add(int index, E element);


  /**
   * Removes an element at a given index.
   * 
   * @param index the position of the element to be removed
   * @return the element to be removed
   */
  E remove(int index);
}
