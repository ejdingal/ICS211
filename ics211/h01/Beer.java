/**
 * Beer.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h01;

/**
 * @author Emeri Joe Dingal. Recieved help from TA. Worked with Angeli Amascual, Kade Shiroma, Kasen Shiroma. Sub
 * classes uses code from Stack Overflow Beer class is the base class for brewing different types of beers.
 */
public abstract class Beer implements Comparable<Beer> {
  private String name;
  private String type;
  protected Integer ibu;
  protected Double abv;


  /**
   * 
   */
  public Beer() {

  }


  /**
   * This constructor creates a new beer given a name and type.
   * 
   * @param name the name of this beer
   * @param type the type of this beer
   */
  public Beer(String name, String type) { // Constructor for beer using name and type only

    setName(name);
    this.type = type;

  }


  /**
   * This constructor creates a new beer given a name, type, ibu, and abv.
   * 
   * @param name the name of this beer
   * @param type the type of this beer
   * @param ibu the ibu of this beer
   * @param abv the abv of this beer
   */
  public Beer(String name, String type, Integer ibu, Double abv) { // Constructor for beer using all member variables.
    setName(name);
    this.type = type;
    this.ibu = ibu;
    this.abv = abv;
  }


  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Beer o) {
    // TODO Auto-generated method stub
    return this.name.compareTo(o.name);
  }


  /**
   * @return the name
   */
  public String getName() {
    return name;
  }


  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * @return the type
   */
  public String getType() {
    return type;
  }


  /**
   * @return the ibu
   */
  public Integer getIbu() {
    return ibu;
  }


  /**
   * @return the abv
   */
  public Double getAbv() {
    return abv;
  }

}
