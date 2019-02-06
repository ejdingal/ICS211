/**
 * HashTable.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h10;

/**
 * A hash taboe
 * @author Emeri Joe Dingal
 * @param <E> A generic
 *
 */
public class HashTable<E> {
  private static Object[] data;


  /**
   * @param data
   */
  public HashTable(Object[] data) {
    super();
    HashTable.data = new Object[1000000];
  }


  public static void add(Object e) {
    boolean ableToAdd = false; // boolean to check if successful add
    // create hash code from key
    int key = Math.abs(e.hashCode()) % data.length; // generate hash
    do { // attempt add at keys
      if (data[key] == null /* OR MARKED AS DELETED (?) */) { // if spot is empty
        data[key] = e; // add to table
        ableToAdd = true;
      }
      // deal with collisions
      else { // spot used up
        /* INCREMENT KEY BY ONE (?) */ // linear probe
        /* MULTIPLY KEY BY SOMETHING */ // quadratic (?)
      }
    }
    while (!ableToAdd); // boolean while unable to add at key location
    HashTable.add(key);
  }


  public static Object delete(Object e) {
    boolean ableToDelete = false; /// boolean to chek if successful delete
    // create hash code from key;
    int key = Math.abs(e.hashCode()) % data.length; // generate hash
    do {
      if (data[key] == null) { // nothing found
        return null; // report not found
      }
      else if (data[key] != null) { // found something
        if (data[key] == e) { // found target
          /* MARK THIS LOCATION DELETED */
        }
      }
    }
    while (!ableToDelete);
    return e;
  }


  public static Object find(Object e) {

    return e;
  }
}
