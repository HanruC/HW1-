import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 * A JUnit test class for the ElectricVehicle class.
 * Set two tests - Ford and BMW examples.
 */
public class ElectricVehicleTest {
  private ElectricVehicle Ford;
  private ElectricVehicle BMW;
  
  /**
   * Set up values for these two test examples.
   */
  @Before
  public void setUp() {
    Ford = new ElectricVehicle("FordEV", 140, 0.8, 4.5);
    BMW = new ElectricVehicle("BMW_i4", 160, 0.14, 4.8);
  }
  
  /**
   * Test for range （currentEfficiency * stateOfCharge * batterySize).
   * First test: Ford range - 4.5 * 0.8 * 140 = 504 which is expected output.
   * Second test: BMW range - 4.5(> 4.5) * 0.15(< 0.15) * 150(> 150) = 101.25 - expected output.
   */
  @Test
  public void range_test() {
    assertEquals(504.0, Ford.range(), 0.01);
    assertEquals(101.25, BMW.range(), 0.01);
    
  }
  
  /**
   * Test if current efficiency will change upon different temperature.
   * Temperature 1: 70.0. Using Ford example to test if the current efficiency will be updated.
   * Ford default efficiency: 4.5. Expected current efficiency under 70.0: 4.5.
   * Temperature 2: 79.0. Using BMW example to test if the current efficiency will be updated.
   * BMW default efficiency: 4.8. Expected current efficiency under 79.0: 0.85 * 4.5 = 3.825.
   * Temperature 3: 14.0. Using BMW example to test if the current efficiency will be updated.
   * BMW default efficiency: 4.8. Expected current efficiency under 14.0: 2.25
   */
  @Test
  public void updateEfficiency_test() {
    double temperature1 = 70.0;
    double temperature2 = 79.0;
    double temperature3 = 14.0;
    
    Ford.updateEfficiency(temperature1);
    double currentEfficiency1 = Ford.getEfficiency();
    assertEquals(4.5, currentEfficiency1, 0.01);
    
    BMW.updateEfficiency(temperature2);
    double currentEfficiency2 = BMW.getEfficiency();
    assertEquals(3.825, currentEfficiency2, 0.01);
    
    BMW.updateEfficiency(temperature3);
    double currentEfficiency3 = BMW.getEfficiency();
    assertEquals(2.25, currentEfficiency3, 0.01);
  }
  
  /**
   * This is the test to test get current efficiency.
   * Using BMW and Ford example to test if it will get correct output current efficiency.
   */
  @Test
  public void getEfficiency_test() {
    assertEquals(4.5, Ford.getEfficiency(), 0.01);
    assertEquals(4.5, BMW.getEfficiency(), 0.01);
  }
  
  /**
   * This is the test to get battery size of the vehicle.
   * Using BMW and Ford example to test whether it will get correct output battery size.
   */
  @Test
  public void getBatterySize_test() {
    assertEquals(140, Ford.getBatterySize(), 0.01);
    assertEquals(150, BMW.getBatterySize(), 0.01);
  }
  
  /**
   * This is the test to get state of charge of the vehicle.
   * Using BMW and Ford example to test whether it will get correct output state of charge.
   */
  @Test
  public void getStateOfCharge_test() {
    assertEquals(0.8, Ford.getStateOfCharge(), 0.01);
    assertEquals(0.15, BMW.getStateOfCharge(), 0.01);
  }
  
  /**
   * This is the test to get the name of the vehicle.
   * Using BMW and Ford example to test whether it will get correct output names.
   */
  @Test
  public void getName_test() {
    assertEquals("FordEV", Ford.getName());
    assertEquals("BMW_i4", BMW.getName());
  }
  
  /**
   * This is the test to show if the method will set a new value to state of charge.
   * Pass getStateOfCharge method to test.
   * Pass Ford and BMW examples and set up new value of state of charge to these two examples.
   */
  @Test
  public void setStateOfCharge_test() {
    double new_stateOfCharge1 = 0.8;
    double new_stateOfCharge2 = 1.3;
    Ford.setStateOfCharge(new_stateOfCharge1);
    double currentStateOfCharge1 = Ford.getStateOfCharge();
    assertEquals(0.8, currentStateOfCharge1, 0.01);
    BMW.setStateOfCharge(new_stateOfCharge2);
    double currentStateOfCharge2 = BMW.getStateOfCharge();
    assertEquals(1.0, currentStateOfCharge2, 0.01);
  }
  
  /**
   * This is the test to show if the string outputs, according to two examples, are correct.
   */
  @Test
  public void testToString_test() {
    assertEquals("FordEV: 80.0% Range (miles): 504.0", Ford.toString());
    assertEquals("BMW_i4: 15.0% Range (miles): 101.2", BMW.toString());
    
  }
}