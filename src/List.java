import java.util.Iterator;

/**
 * A simple list interface. You can add items to the list
 * search, and determine the list size.
 */
public interface List<T> extends Iterable<T> {
    /**
     * Adds the given item at the beginning of the list.
     */
    void addFirst(T item);

    /**
     * Returns true if list contains item, false otherwise
     */
    boolean contains(T item);

    /**
     * Returns the number of items currently in the stack.
     */
    int size();

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty();
}


