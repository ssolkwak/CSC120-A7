/* This is a stub for the Cafe class */
public class Cafe extends Building{
    private int nCoffeeOunces; 
    private int nSugarPackets;
    private int nCreams; 
    private int nCups; 

    /**
     * full Cafe constructor which creates a building with stocks in inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /* Overloaded constructor with name, adress, nFloors, and default stocks inventory */
    public Cafe(String name, String address, int nFloors) {
       this(name, address, nFloors, 300, 300, 300, 300);
    }

    /* Overloaded constructor with name and address */
    public Cafe(String name, String address) {
        this(name, address, 1);
    }

    /**
     * Decrease the stocked ingredients by values given in parameters. If the stock is below the requested amount, restock the inventory. 
     * @param size size of the coffee to be sold
     * @param nSugarPackets number of sugar packets to be sold
     * @param nCreams number of creams to be sold
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups >= 1){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        } else {
            this.restock(400, 100, 100, 100);
        }
    }
    
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /** 
    * Overrrided showOptions including Cafe specific method options
    */
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee(a,b,c)\n + restock(a,b,c,d)");
    }

    /* Overrided goToFloor() which doesn't permit movement off the first floor */
    public void goToFloor(int floorNum) {
        if(floorNum == 1){
          super.goToFloor(floorNum);
        } else {
          System.out.println("This floor is not permitted.");
        }
    }
    
    /* Overrided goUp() which doesn't permit movement off the first floor */
    public void goUp(){
        System.out.println("This floor is not permitted.");
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        Cafe cc = new Cafe("CC", "100 Elm St", 1);
        cc.showOptions();
        cc.enter();
        cc.goUp();
        cc.goToFloor(2);
    }
    
}
