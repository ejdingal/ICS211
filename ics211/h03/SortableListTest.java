/**
 * SortableListTest.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h03;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.Test;

/**
 * This class tests the features of a list using ints.
 * 
 * @author Emeri Joe Dingal. Worked with Angeli Amascual, Kade Shiroma, Kason Shiroma, Russel Alegre.
 *
 */
public class SortableListTest {

  public SortableList<Integer> list;
  public Integer[] stuff = new Integer[] { 10, 2, 5 };
  public Comparator<Integer> compare;


  /**
   * Test method for {@link edu.ics211.h03.SortableList#insertionSort(java.util.Comparator)}.
   */
  @Test
  public void testInsertionSort() {
    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    list.insertionSort(compare);
    assertTrue("Should be 10", stuff[2] == 10);
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#bubbleSort(java.util.Comparator)}.
   */
  @Test
  public void testBubbleSort() {
    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    list.bubbleSort(compare);
    assertTrue("Should be 10", stuff[2] == 10);
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#selectionSort(java.util.Comparator)}.
   */
  @Test
  public void testSelectionSort() {
    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    list.selectionSort(compare);
    assertTrue("Should be 10", stuff[2] == 10);
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#set(int, java.lang.Object)}.
   */
  @Test
  public void testSet() {
    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    assertTrue("Should be 10", list.set(0, 3) == 10);
    assertTrue("Should be 3", list.get(0) == 3);
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#indexOf(java.lang.Object)}.
   */
  @Test
  public void testIndexOf() {
    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    assertTrue("Should be 1", list.indexOf(2) == 1);
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#size()}.
   */
  @Test
  public void testSize() {
    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    assertTrue("Should be 3", list.size() == 3);
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#add(java.lang.Object)}.
   */
  @Test
  public void testAddE() {
    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    list.add(17);
    assertTrue("Should be 4", list.size() == 4);
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#add(int, java.lang.Object)}.
   */
  @Test
  public void testAddIntE() {

    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    list.add(0, 17);
    assertTrue("Should be 10", list.get(1) == 10);
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#remove(int)}.
   */
  @Test
  public void testRemove() {
    list = new SortableList<Integer>();
    for (int i = 0; i < stuff.length; i++) {
      list.add(stuff[i]);
    }
    list.remove(0);
    assertTrue("Size should be 2", list.size() == 2);
    assertTrue("Should be 2", list.get(0) == 2);
  }

}
