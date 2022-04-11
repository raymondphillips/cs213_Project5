package cafe;

/**
 * An instance of this class is a menu item in an order. This class must
 * extend MenuItem class and implement the Customizable interface above to
 * provide the behavior of adding and removing the add-ins.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class Donut extends MenuItem {
    private int quantity;
    private String type;
    private String flavor;

    private double holePrice = 0.39;
    private double yeastPrice = 1.59;
    private double cakePrice = 1.79;
    private double roundingMargin = 100.0;

    public Donut(String flavor, String type, int quantity){
        this.type = type;
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * a method to calculate the price of an item on the menu
     * @return a double that is the price of the item
     */
    @Override
    public double itemPrice(){
        if(type.equals("Hole")){
            //return Math.round((holePrice * quantity) * roundingMargin) / roundingMargin;
            return holePrice * quantity;
        } else if(type.equals("Yeast")){
            //return Math.round((yeastPrice * quantity) * roundingMargin) / roundingMargin;
            return yeastPrice * quantity;
        } else{
            //return Math.round((cakePrice * quantity) * roundingMargin) / roundingMargin;
            return cakePrice * quantity;
        }
    }

    /**
     * a method to get the string representation of a donut
     * @return the string reprsentation of a donut
     */
    @Override
    public String toString(){
        String toReturn = "Donut-" + this.quantity + "-" + type + "-" + flavor;
        return toReturn;
    }
}