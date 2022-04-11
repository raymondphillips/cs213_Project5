package cafe;

/**
 * This is the superclass of all menu items, such as donuts and coffee. Any
 * class defined for a menu item must extend this class.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class MenuItem{

    /**
     * a method to calculate the price of an item on the menu
     * @return a double that is the price of the item
     */
    public double itemPrice(){
        return 0.0;
    }
}