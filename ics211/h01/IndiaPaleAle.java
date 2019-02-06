/**
 * IndiaPaleAle.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h01;

/**
 * @author Emeri Joe Dingal @see Beer Class JavaDocs. This class is an Indian Pale Ale.
 */
public class IndiaPaleAle extends Pilsner {
  /**
   * This constructor creates an IPA using a given name, ibu, and abv.
   * 
   * @param name
   * @param ibu
   * @param abv
   */
  public IndiaPaleAle(String name, Integer ibu, Double abv) {
    if (ibu < 40 || ibu > 100 || abv < 5.0 || abv > 10.0)
      throw new IllegalArgumentException();
    else {
      this.ibu = ibu;
      this.abv = abv;
      this.setName(name);
    }
  }


  /**
   * This constructor creates and IPA given only a name. Math.random() code from (1)Stack Overflow
   * 
   * @param name
   */
  public IndiaPaleAle(String name) {
    super(name, "Pilsner", (int) ((Math.random() * (100 - 40)) + 40), ((Math.random() * (10.0 - 5.0)) + 5.0));
  }
}
