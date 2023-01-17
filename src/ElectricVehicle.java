import java.text.DecimalFormat;
/**
 * Hanru Chen
 * This class represents an electric vehicle. An electric vehicle has a name,
 * battery size, state of charge, and current efficiency
 */

public class ElectricVehicle {
  private String names;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private final double defaultEfficiency;

  /**
   * This is the overloaded constructor for the ElectricVehicle class.
   *
   * @param names  the name to be given to this electric vehicle
   * @param batterySize  the battery size to be given to this electric vehicle
   * @param stateOfCharge  the state of charge of this electric vehicle
   * @param defaultEfficiency  default efficiency assigned to this electric vehicle
   */
  
  public ElectricVehicle(String names, double batterySize,
      double stateOfCharge, double defaultEfficiency) {
    this.names = names;
    this.batterySize = batterySize;
    this.stateOfCharge = stateOfCharge;
    this.defaultEfficiency = defaultEfficiency;
    this.currentEfficiency = defaultEfficiency;
    if (this.batterySize < 10.0) this.batterySize = 10;
    if (this.batterySize > 150.0) this.batterySize = 150.0;
    if (this.defaultEfficiency < 0.5) this.currentEfficiency = 0.5;
    if (this.defaultEfficiency > 4.5) this.currentEfficiency = 4.5;
    if (this.names == null) this.names = "unknown EV";
    if (this.names.equals("")) this.names = "unknown EV";
    if (this.stateOfCharge < 0.15) this.stateOfCharge = 0.15;
    if (this.stateOfCharge > 1.0) this.stateOfCharge = 1.0;
  }
  
  /**
   * Return the range of the electric vehicle.
   *
   * @return the range of electric vehicle can reach
   */
  public double range() {
    return this.currentEfficiency * this.stateOfCharge * this.batterySize;
  }
  
  /**
   * This method is to update electric vehicle efficiency.
   * Return nothing.
   * Take current temperature as parameter
   *
   * @param currentTemp  the current temperature(Fahrenheit)
   */
  public void updateEfficiency(double currentTemp) {
    if (65.0 <= currentTemp && currentTemp <= 77.0) this.currentEfficiency = this.defaultEfficiency;
    if (currentTemp > 77.0) this.currentEfficiency = 0.85 * this.defaultEfficiency;
    if (currentTemp < 65.0) this.currentEfficiency =
            (1 - ((65.0 - currentTemp) * 0.01)) * this.defaultEfficiency ;
    if (this.currentEfficiency < 0.5 * this.defaultEfficiency) this.currentEfficiency =
            0.5 * this.defaultEfficiency;
  }
  
  /**
   * Return current efficiency.
   *
   * @return current efficiency
   */
  public double getEfficiency() {
    return this.currentEfficiency;
  }
  
  /**
   * Return battery size.
   *
   * @return battery size
   */
  public double getBatterySize() {
    return this.batterySize;
  }
  
  /**
   * Return state of charge.
   *
   * @return state of charge
   */
  public double getStateOfCharge() {
    return this.stateOfCharge;
  }
  
  /**
   * Return name.
   *
   * @return name
   */
  public String getName() {
    return this.names;
  }
  
  /**
   * Set a new value for the state of charge.
   * Still need to set up constraints for state of charge.
   */
  public void setStateOfCharge(double stateOfCharge) {
    if (stateOfCharge > 1.0) this.stateOfCharge = 1.0;
    if (stateOfCharge < 0.15) this.stateOfCharge = 0.15;
  }
  
  /**
   * Return string with EV object's name, state of charge, and range.
   *
   * @return EV object with name, state of charge, and range.
   */
  
  public String toString() {
    DecimalFormat commaFormat;
    commaFormat = new DecimalFormat("#.0");
    return "%s: %s%% Range (miles): %.1f".formatted(getName(),
            commaFormat.format(this.stateOfCharge * 100.0), range());
  }
}
