/**
 * SortableBeerList.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h04;

import edu.ics211.h01.Beer;
import java.util.Comparator;

/**
 * This class implements the aspects of a list and applies them for beers.
 * 
 * @author Emeri Joe Dingal. Worked with Angeli Amascual, Kade Shiroma, and Kason Shiroma.
 *
 */
public class SortableBeerList implements IList211<Beer> {
  private SortableList<Beer> beer;
  private Comparator<Beer> compare;


  public SortableBeerList(Comparator<Beer> element) {
    compare = element;
    beer = new SortableList<Beer>();
  }


  /**
   * @param index
   * @return
   * @see edu.ics211.h03.SortableList#get(int)
   */
  public Beer get(int index) {
    return beer.get(index);
  }


  /**
   * @param index
   * @param element
   * @return
   * @see edu.ics211.h03.SortableList#set(int, java.lang.Object)
   */
  public Beer set(int index, Beer element) {
    return beer.set(index, element);
  }


  /**
   * @param obj
   * @return
   * @see edu.ics211.h03.SortableList#indexOf(java.lang.Object)
   */
  public int indexOf(Object obj) {
    return beer.indexOf(obj);
  }


  /**
   * @return
   * @see edu.ics211.h03.SortableList#size()
   */
  public int size() {
    return beer.size();
  }


  /**
   * @param e
   * @return
   * @see edu.ics211.h03.SortableList#add(java.lang.Object)
   */
  public boolean add(Beer e) {

    if (beer.add(e)) {
      beer.selectionSort(compare);
      return true;
    }
    return false;
  }


  /**
   * @param index
   * @param element
   * @see edu.ics211.h03.SortableList#add(int, java.lang.Object)
   */
  public void add(int index, Beer element) {
    beer.add(index, element);
    beer.bubbleSort(compare);
  }


  /**
   * @param index
   * @return
   * @see edu.ics211.h03.SortableList#remove(int)
   */
  public Beer remove(int index) {
    return beer.remove(index);
  }

}