/* This is a stub for the House class */

import java.util.ArrayList;
public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;
  
  /**
   * House constructor which creates a building with an empty arraylist of residents and boolean of having dining room
   * @param name name of house
   * @param address address of house
   * @param nFloors floors in house building
   * @param dining if the house has a dining hall
   */
  public House(String name, String address, int nFloors, boolean dining, boolean elevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = dining;
    this.hasElevator = elevator;
    System.out.println("You have built a house: 🏠");
  }

  /* Overloaded constrctor with name, address */
  public House(String name, String address){
    this(name, address, 1, false, false);
  }

  /* Overloaded constructor without dining and elevator availability */
  public House(String name, String address, int nFloors){
    this(name, address, nFloors, false, false);
  }

  /**
   * Getter for hasDiningRoom
   * @return T/F if the house has a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Getter for hasElevator
   * @return T/F if the house has an elevator
   */
  public boolean hasElevator(){
    return this.hasElevator;
  }
   
  /**
   * Gets the number of residents in the house
   * @return integer number of residents
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * checks if the indicated person is a resident of the house
   * @param name name of the person
   * @return T/F if name is a resident
   */
  public boolean isResident(String name){
    return this.residents.contains(name);
  }

  /**
   * Adds the resident to the residents arraylist
   * @param name name of the new resident
   */
  public void moveIn(String name){
    this.residents.add(name);
  }

  /**
   * removes the resident from the residents arraylist if the person is an existing resident
   * @param name name of the resident
   * @return String of the name of the resident if they successfully moved out or that the person is not an existing resident
   */
  public String moveOut(String name){
    if (this.isResident(name)){
      this.residents.remove(name);
      return name + " has moved out.";
    } else {
      return name + " is not a resident.";
    }
  }

  /** 
   * Overloaded showOptions including House specific method options
   */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + moveIn(name)\n + moveOut(name)");
  }

  public void goToFloor(int floorNum) {
    if(this.hasElevator){
      super.goToFloor(floorNum);
    } else {
      System.out.println(this.name +" has no elevator. Please use goUp() and goDown() methods to move floors.");
    }
  }

/**
 * main to test methods
 * @param args
 */  public static void main(String[] args) {
    House lamont = new House("Lamont", "17 Prospect St", 4, true, false);
    System.out.println(lamont);
    lamont.moveIn("Sophia");
    lamont.moveIn("Katherine");
    System.out.println(lamont.residents);
    System.out.println(lamont.moveOut("Katherine"));
    System.out.println(lamont.residents);
    System.out.println(lamont.moveOut("Katherine"));
    lamont.showOptions();
    lamont.enter();
    lamont.goToFloor(2);
  }

}