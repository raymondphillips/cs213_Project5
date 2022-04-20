package cafe;

import src.cafe.Customizable;
import src.cafe.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * An instance of this class has a unique order number and keeps the list
 * of menu items added by the user. This class implements the Customizable
 * interface above, to provide the behavior of adding and removing menu items.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class Order implements Customizable {
    public int orderNum;
    public List<MenuItem> items;

    /**
     * constructor for the order class
     * @param orderNum
     */
    public Order(int orderNum){
        this.items = new ArrayList<MenuItem>();
        this.orderNum = orderNum;
    }

    /**
     * an interface method that adds items to lists
     * @param obj takes in an object to add to the list
     * @return true if it was added false, if it was unable to do so
     */
    public boolean add(Object obj){
        if(obj instanceof MenuItem && this.items.indexOf((MenuItem) obj) == -1){
            this.items.add((MenuItem) obj);
            return true;
        }

        return false;
    }
    /**
     * an interface method that removes items from lists
     * @param obj takes in an object to remove it from the list
     * @return true if it was removed false, if it was unable to do so
     */
    public boolean remove(Object obj) {
        if(obj instanceof MenuItem && this.items.indexOf((MenuItem)obj) != -1){
            this.items.remove((MenuItem) obj);
            return true;
        }
        return false;
    }

    /**
     * a method to get the string representation of an order
     * @return string representation of an order
     */
    @Override
    public String toString(){
        double total = 0.00;
        String toReturn = "";
        toReturn += "Order ID: " + this.orderNum + "\n";
        for(int i = 0; i < this.items.size(); i++){
            toReturn += this.items.get(i).toString() + "\n";
            total += this.items.get(i).itemPrice();
        }
        toReturn += "Total Price: $" + String.format("%.2f", total) + "\n";

        return toReturn;
    }
}