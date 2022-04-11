package cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * An instance of this class keeps a list of orders placed by the user.
 * This class implements the Customizable interface above to provide the
 * behavior of adding and removing orders.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class StoreOrders implements Customizable {
    public List<Order> orders;
    private int indexNotFound = -1;
    /**
     * constructor for the storeOrders class
     */
    public StoreOrders(){
        this.orders = new ArrayList<Order>();
    }

    /**
     * an interface method that adds items to lists
     * @param obj takes in an object to add to the list
     * @return true if it was added false, if it was unable to do so
     */
    public boolean add(Object obj){
        if(obj instanceof Order && this.orders.indexOf((Order) obj) == -1){
            this.orders.add((Order) obj);
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
        if(obj instanceof Order && this.orders.indexOf((Order)obj) != indexNotFound){
            this.orders.remove((Order) obj);
            return true;
        }
        return false;
    }
}