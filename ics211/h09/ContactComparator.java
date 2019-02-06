/**
 * ContactComparator.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h09;

import java.util.Comparator;

/**
 * @author Emeri Joe Dingal
 *
 */
public class ContactComparator implements Comparator<Contact> {

  /* (non-Javadoc)
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(Contact o1, Contact o2) {
    if ((o1.getLastName()).compareTo(o2.getLastName()) != 0) { // if last names are not the same
      return (o1.getLastName().compareTo(o2.getLastName())); // compare their last name
    }
    else { // if last names are same
      return (o1.getFirstName().compareTo(o2.getFirstName())); // compare first name
    }
  }

}
