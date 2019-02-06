/**
 * SlowPotionBag.java
 * Copyright (c) Emeri Joe Dingal 2018
 */

package edu.ics211.h10;

/**
 * A slow potion bag with a runtime of about O(n) using a single linked list with no tail.
 * 
 * @author Emeri Joe Dingal
 *
 */
public class SlowPotionBag implements PotionBag {
  private DLinkedNode head = new DLinkedNode(null, null, null);
  private int size;
  private static SlowPotionBag instance;

  /**
   * The node that is doubly linked.
   * 
   * @author Emeri Joe Dingal
   */
  private class DLinkedNode {
    Potion item;
    DLinkedNode next;
    DLinkedNode prev;


    /**
     * Constructor for Doubly linked nodes.
     * 
     * @param item the data
     * @param next the next node
     * @param prev the previous node
     */
    public DLinkedNode(Potion item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#store(edu.ics211.h10.Potion)
   */
  public void store(Potion p) {
    store(p, head);
    size++;
  }


  /**
   * Recursive helper method for store.
   * 
   * @param p the potion being added
   * @param node the node where it'll be stored
   */
  public void store(Potion p, DLinkedNode node) {
    if (node.item == null) { // nothing here
      node.item = p; // store here
    }
    else { // something here
      if (node.next == null) { // check next node
        node.next = new DLinkedNode(null, null, node); // create one if null
      }
      store(p, node.next); // attempt to store at next node
    }

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#timedStore(edu.ics211.h10.Potion)
   */
  @Override
  public long timedStore(Potion p) {
    long startTime = System.nanoTime();
    store(p);
    return System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#retrieve(edu.ics211.h10.Potion)
   */
  @Override
  public Potion retrieve(Potion p) {
    return retrieve(p, head);
  }


  /**
   * Helper method for retrieve method.
   * 
   * @param p the potion to be retrieved
   * @return
   */
  private Potion retrieve(Potion p, DLinkedNode node) {
    if (p.equals(node.item)) {
      Potion retVal = node.item;
      node.item = null;
      node.prev.next = node.next;
      size--;
      return retVal;
    }
    else {
      return retrieve(p, node.next);
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#timedRetrieve(edu.ics211.h10.Potion)
   */
  @Override
  public long timedRetrieve(Potion p) {
    long startTime = System.nanoTime();
    retrieve(p);
    return System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#size()
   */
  @Override
  public int size() {
    return size;
  }


  /**
   * Creates a single and only instance of potion bag.
   * 
   * @return the instance of this potion bag.
   */
  public static SlowPotionBag getInstance() {
    if (instance == null) {
      instance = new SlowPotionBag();
    }
    return instance;
  }

}
