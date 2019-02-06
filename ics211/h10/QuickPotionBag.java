/**
 * QuickPotionBag.java
 * Copyright (c) Emeri Joe Dingal 2018
 */

package edu.ics211.h10;

import java.util.HashMap;

/**
 * A quick potion bag with the runtime of about O(1) using a hash table.
 * 
 * @author Emeri Joe Dingal
 *
 */
public class QuickPotionBag implements PotionBag {
  private static HashMap<Potion, Potion> table = new HashMap<Potion, Potion>(); // a hashtable
  private static QuickPotionBag instance; // a singleton instance


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#store(edu.ics211.h10.Potion)
   */
  @Override
  public void store(Potion p) {
    table.put(p, p);
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
    Potion retVal = (Potion) table.remove(p);
    return retVal;
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
    // TODO Auto-generated method stub
    return table.size();
  }


  /**
   * Creates a single and only instance of potion bag.
   * 
   * @return the instance of this potion bag.
   */
  public static QuickPotionBag getInstance() {
    if (instance == null) {
      instance = new QuickPotionBag();
    }
    return instance;
  }

}
