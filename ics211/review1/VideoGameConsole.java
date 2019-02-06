package edu.ics211.review1;

public abstract class VideoGameConsole {
  
  private String manufacturer;
  private String model;
  private String submodel;
  private double price;
  
  public VideoGameConsole(String manufacturer, String model, String submodel, double price) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.submodel = submodel;
    this.price = price;
  }
  
  /**
   * Gets Manufacture
   * @return manufacture
   */
  public String getManufacturer() {
    return this.manufacturer;
  }
  
  /**
   * Gets Model
   * @return model
   */
  public String getModel() {
    return this.model;
  }
  
  /**
   * Gets Submodel
   * @return submodel
   */
  public String getSubmodel() {
    return this.submodel;
  }
  
  /**
   * Gets price
   * @return price
   */
  public double getPrice() {
    return this.price;
  }

}
