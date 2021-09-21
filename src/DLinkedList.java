import java.util.*;

/**
 * Class impliments generic list, and iterable, to use a nested node class that allowes for a doubly linked list
 * Nodes are given access to next and previpus to allow for 2 way traversal 
 */

public class DLinkedList<T> implements List<T>, Iterable<T>{
    private class Node{
        T data;
        private Node prev;
        private Node next;

        public Node(T data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
    Node tail;  

    /**
     *  Default constructor for DLinkedList
     */
    public DLinkedList() {
        head = null;
        tail = null;
    }

    /**
     *  This method takes generic data creates a new node wit hit
     *  Node is then set as head (beginning of list)
     * 
     *  @param data generic 
     *  @return void
     */
    public void addFirst(T data) {
        head = new Node(data, head, null);
        Node second = head.next;

        if (second != null) { // already ay least one node in list
            second.prev = head;
        } else { // first addition to the list
            tail = head;
        }
    }

    /**
     *  This method takes generic item and iterates through the DLL 
     *  If item is found within the list, method returns true, else false
     * 
     *  @param item generic
     *  @return true if item is found, else false
     */
    public boolean contains(T item) {
        Node pointer = head;
        boolean result = false;

        while(pointer != null && !result) {
            if(pointer.data.equals(item)) {
                result = true;
            } else {
                pointer = pointer.next;
            }
        }
        return result;
    }

    /**
     *  This method returns the size of DLL
     * 
     *  @return int size of DLL (note that last index is at size - 1)
     */
    public int size() {
        Node pointer = head;
        int size = 0;

        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }
        return (size);
    }

    public boolean isEmpty() {
        return (head == null);
    }

    /**
     *  This class is the iterator object for the DLinkedList class
     *  Impliments Iterator and overrites methods of Iterator
     */
    private class DListIterator implements Iterator<T> {
        private Node nextNode = head;

        /**
         *  This method determines if a node is null
         *  @return true if node != null
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        /**
         *  This method is used to access the values of DLL while iterating through
         * 
         *  @return the generic element T
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = nextNode.data;
            nextNode = nextNode.next;
            return data;
        }
    }
    // returns the DListIterator class above when iterator is used
    @Override
    public Iterator<T> iterator() {
        return new DListIterator();
    }
}
