/**
 * BohemianPilsner.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h01;

/**
 * @author Emeri Joe Dingal @see Beer Class JavaDocs. This class is a Bohemian Pilsner
 *
 */
public class BohemianPilsner extends Pilsner {
  /**
   * This constructor creates a Bohemian Pilsner given a name, ibu, and abv.
   * 
   * @param name
   * @param ibu
   * @param abv
   */
  public BohemianPilsner(String name, Integer ibu, Double abv) {
    if (ibu < 35 || ibu > 45 || abv < 4.2 || abv > 5.4)
      throw new IllegalArgumentException();
    else {
      this.ibu = ibu;
      this.abv = abv;
      this.setName(name);

    }
  }


  /**
   * This constructo creates a Bohemian Pilsner given only a name. Math.random() code from (1)Stack Overflow
   * 
   * @param name
   */
  public BohemianPilsner(String name) {
    super(name, "Pilsner", (int) ((Math.random() * (45 - 35)) + 35), ((Math.random() * (5.4 - 4.2)) + 4.2));
  }
}
