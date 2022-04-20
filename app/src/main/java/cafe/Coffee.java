package cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * An instance of this class has a unique order number and keeps the list
 * of menu items added by the user. This class implements the Customizable
 * interface above, to provide the behavior of adding and removing menu items.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class Coffee extends MenuItem implements Customizable{
    public List<String> addons;
    public String size;
    public double cost;
    private double shortPrice = 1.69;
    private double tallPrice = 2.09;
    private double grandePrice = 2.49;
    private double ventiPrice = 2.89;
    private double addonPricePer = 0.30;

    private double roundingMargin = 100.0;

    /**
     * a method to get the item price of a coffee order
     * @return the coffee price of an order
     */
    @Override
    public double itemPrice(){
        double total = 0.00;
        switch(this.size){
            case "Short":
                total += shortPrice;
                break;
            case "Tall":
                total += tallPrice;
                break;
            case "Grande":
                total += grandePrice;
                break;
            case "Venti":
                total += ventiPrice;
                break;
        }

        total += (addonPricePer * this.addons.size());
        return total;
    }
    /**
     * coffee class constructor
     * @param size of the coffee
     */
    public Coffee(String size){
        this.size = size;
        this.addons = new ArrayList<String>();
    }

    /**
     * a method to add coffee object to a list
     * @param obj takes in an object to add to the list
     * @return true if successful, false otherwise
     */
    @Override
    public boolean add(Object obj) {
//        CheckBox current = (CheckBox) obj;
//        if(this.addons != null && this.addons.indexOf(current.getId()) != -1){
//            return false;
//        }
//
//        this.addons.add(current.getId());
        return true;
    }
    /**
     * a method to remove a coffee item from the list
     * @param obj takes in an object to remove it from the list
     * @return true if successful otherwise false
     */
    @Override
    public boolean remove(Object obj) {
//        CheckBox current = (CheckBox) obj;
//        if(this.addons != null && this.addons.indexOf(current.getId()) == -1){
//            return false;
//        }
//
//        this.addons.remove(current.getId());
        return true;
    }
    /**
     * a method to return the string representation of a coffee order
     * @return the string representation of coffee order
     */
    @Override
    public String toString(){
        String toReturn = "Coffee-" + this.size + "-Addons:-";
        if(this.addons.size() == 0){
            toReturn += "None (Black)";
        } else{
            for(int i = 0; i < this.addons.size(); i++){
                switch(this.addons.get(i)){
                    case "creamCheckBox": toReturn += "Cream";
                    break;
                    case "syrupCheckBox": toReturn += "Syrup";
                    break;
                    case "milkCheckBox": toReturn += "Milk";
                    break;
                    case "caramelCheckBox": toReturn += "Caramel";
                    break;
                    case "whippedCreamCheckBox": toReturn += "Whipped Cream";
                }

                //if not last add comma
                if(i < this.addons.size()-1) {
                    toReturn += "-";
                }
            }
        }

        return toReturn;
    }
}