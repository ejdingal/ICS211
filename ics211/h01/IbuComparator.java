/**
 * IbuComparator.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h01;

import java.util.Comparator;

/**
 * @author Emeri Joe Dingal
 *
 */
public class IbuComparator implements Comparator<Beer> {

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(Beer o1, Beer o2) {
    // TODO Auto-generated method stub
    return o1.getIbu().compareTo(o2.getIbu());
  }

}
