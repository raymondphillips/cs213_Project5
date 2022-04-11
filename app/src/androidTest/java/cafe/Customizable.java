package cafe;

/**
 * an interface class that has two methods that allow for the addition and
 * deletion of objects.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public interface Customizable{
    /**
     * an interface method that adds items to lists
     * @param obj takes in an object to add to the list
     * @return true if it was added false, if it was unable to do so
     */
    boolean add(Object obj);
    /**
     * an interface method that removes items from lists
     * @param obj takes in an object to remove it from the list
     * @return true if it was removed false, if it was unable to do so
     */
    boolean remove(Object obj);
}