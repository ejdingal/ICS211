/**
 * Pilsner.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h01;

/**
 * @author Emeri Joe Dingal. @see Beer Class JavaDocs. This class is a Pilsner.
 *
 */
public class Pilsner extends Beer {

  Pilsner() {

  }


  /**
   * This method creates a Pilsner given only a name. Math.random() code from (1)Stack Overflow
   * 
   * @param name
   */
  public Pilsner(String name) {
    super(name, "Pilsner", (int) ((Math.random() * (45 - 25)) + 25), ((Math.random() * (6 - 4.2)) + 4.2));

  }


  /**
   * 
   * This method creates a Pilsner given a name, ibu, and abv.
   * 
   * @param name
   * @param ibu
   * @param abv
   */
  public Pilsner(String name, Integer ibu, Double abv) {
    if (ibu < 25 || ibu > 45 || abv < 4.2 || abv > 6.0)
      throw new IllegalArgumentException();
    else {
      this.ibu = ibu;
      this.abv = abv;
      this.setName(name);

    }
  }


  /**
   * This method creates a pilsner given a name, type, ibu, and abv.
   * 
   * @param name
   * @param type
   * @param ibu
   * @param abv
   */
  public Pilsner(String name, String type, Integer ibu, Double abv) {
    super(name, "Pilsner", ibu, abv);

    // TODO Auto-generated constructor stub
  }

}
