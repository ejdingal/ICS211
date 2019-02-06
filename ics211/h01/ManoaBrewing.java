/**
 * ManoaBrewing.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h01;

/**
 * @author Emeri Joe Dingal. Recieved help from TA. Worked with Angeli Amascual, Kade Shiroma, Kason Shiroma. The
 * problem is to create a Manoa Brewery class that can create different types of beers (pass ManoaBrewingTest JUnit
 * test).
 *
 */
public class ManoaBrewing implements IBrewery {
  private static ManoaBrewing instance;


  /**
   * This method creates the single ManoaBrewing Instance. If there is already an instance, it returns that instance, if
   * there is no instance, it will create one.
   * 
   * @return ManoaBrewing instance
   */
  public static ManoaBrewing getInstance() {
    if (instance == null) {
      instance = new ManoaBrewing();
    }
    return instance;

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h01.IBrewery#brewBeer(java.lang.String, java.lang.String)
   */
  @Override
  public Beer brewBeer(String name, String type) {
    // TODO Auto-generated method stub
    if (type == IBrewery.PILSNER) {
      Pilsner pilsner = new Pilsner(name);
      return pilsner;
    }
    else if (type == IBrewery.BOHEMIAN_PILSNER) {
      BohemianPilsner bp = new BohemianPilsner(name);
      return bp;
    }
    else if (type == IBrewery.INDIA_PALE_ALE) {
      IndiaPaleAle ipa = new IndiaPaleAle(name);
      return ipa;
    }
    else {
      throw new IllegalArgumentException();
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h01.IBrewery#brewPilsner(java.lang.String, java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewPilsner(String name, Integer ibu, Double abv) {
    // TODO Auto-generated method stub
    Pilsner p = new Pilsner(name, ibu, abv);
    return p;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h01.IBrewery#brewBohemianPilsner(java.lang.String, java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewBohemianPilsner(String name, Integer ibu, Double abv) {
    // TODO Auto-generated method stub
    BohemianPilsner b = new BohemianPilsner(name, ibu, abv);
    return b;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h01.IBrewery#brewIndiaPaleAle(java.lang.String, java.lang.Integer, java.lang.Double)
   */
  @Override
  public Beer brewIndiaPaleAle(String name, Integer ibu, Double abv) {
    // TODO Auto-generated method stub
    IndiaPaleAle i = new IndiaPaleAle(name, ibu, abv);
    return i;
  }
}
