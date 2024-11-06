/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  /**
   * Full Constructor for Library that creates a building with an empty collection Hashtable
   * @param name name of library
   * @param address address of library
   * @param nFloors floors of library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /* Overloaded constructor with address */
  public Library(String address){
    this("<Name Unkown>", address, 1);
  }

  /* Overloaded constructor with name and address */
  public Library(String name, String address){
    this(name, address, 1);
  }

  /**
   * Checks if the title is in the collection
   * @param title name and author of the book 
   * @return T/F if the title is in the collection
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }
  
  /**
   * Checks if the title is available or checked out
   * @param title name and author of the book
   * @return T/F if the title is available for check out
   */
  public boolean isAvailable(String title){
    if (this.containsTitle(title)){
      return this.collection.get(title);
    } else {
      System.out.println(title + " is not in the collection.");
      return false; 
    }
  }

  /**
   * adds a book to the collection
   * @param title name and author of the book
   */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /**
   * removes a book from the collection
   * @param title name and author of the book
   * @return the title removed or that the title is not in the collection
   */
  public String removeTitle(String title){
    if (this.containsTitle(title)){
      this.collection.remove(title);
      return title;
    } else {
      return title + " is not in the collection.";
    }
  }
 
  /**
   * Checks out a book by changing availability value to false in collection hashtable
   * @param title name and author of the book
   */
  public void checkOut(String title){
    if (this.isAvailable(title)){
      this.collection.put(title, false);
    } else {
      System.out.println(title + " is unavailable.");
    }
  }

  /**
   * Returns the book by setting availability to true. Prints a message if the book was not checked out.
   * @param title name and author of the book
   */
  public void returnBook(String title){
    if (!this.isAvailable(title)){
      this.collection.put(title, true);
    } else {
      System.out.println(title + "is already returned.");
    }
  }

  /**
   * Prints out the entire collection along with the availability
   */
  public void printCollection(){
    System.out.println("Collection:");
    for (String title : this.collection.keySet()){
      System.out.print("Title: " + title);
      if (this.isAvailable(title)){
        System.out.println(", available");
      } else {
        System.out.println(", unavailable");
      }
    }
  }

   /** 
    * Overrrided showOptions including Library specific method options
    */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + checkOut(title)\n + returnBook(title)");
  }

  /** allows movement between non adjecent floors */
  public void goToFloor(int floorNum) {
    super.goToFloor(floorNum);
  }

  /**
   * Main method
   * @param args
   */
  public static void main(String[] args) {
    Library neilson = new Library("Neilson", "7 Neilson Dr", 3);
    neilson.addTitle("Chagall and the Bible by Rosensaft");
    neilson.addTitle("Goya's Caprichos by Schulz");
    neilson.addTitle("Hamlet by William Shakespeare");
    neilson.checkOut("Hamlet");

    neilson.printCollection();
    neilson.showOptions();
  }
  
}