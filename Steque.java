/*
 *  File: Steque.java
 *  Author: 
 *  Date: 18th Nov, 2021
 *  ---------------------------------------
 *  Steque is stack-ended queue data structure which supports
 *  stack operations: pop and push, along with queue enqueue 
 *  operation.
 *  
 *  Salient features:
 *  1. Operations like push, pop, enqueue are supported.
 *  2. NullPointerException is thrown when null element is inserted.
 *  3. UnsupportedOperationException is thrown when using remove() method.
 *  4. The data structure is iterable and is implemented for generic type.
 *  
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 
 * Steque is a stack-ended data structure which 
 * supports stack operations as well as queue's 
 * enqueue operation.
 * 
 * @author 
 * @version 1.0
 *
 */
public class Steque<Item> implements Iterable<Item> {
    
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next; 
     }
    /**
     * constructs a steque object.
     */
    public Steque() {
        first=null;
        last=null;
        n=0;

    }
    
    
    /**
     * inserts an item in the steque in queue fashion.
     * @param item Item to be inserted.
     */
    public void enqueue(Item item) {
        if(item==null) throw new IllegalArgumentException();
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else  oldlast.next = last;
        n++;
    }
    
    
    /**
     * inserts an item in the steque in stack fashion.
     * @param item Item to be inserted.
     */
    //time complexity is O(1);space complexity O(N)
    public void push(Item item) {
        if(item==null)
            throw new IllegalArgumentException();
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        if(last==null)
            last=first;
        n++;

    }
    
    /**
     * pops a least recent item in steque.
     * @return Item object from steque.
     */
    //time complexity is O(1);space complexity O(N)
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;

    }
    
    /**
     * checks to see if steque is empty.
     * @return true if steque is empty, false otherwise.
     */
    //time complexity is O(1);space complexity 0
    public boolean isEmpty() {
        return (first == null||last==null);
    }
    
    /**
     * return the number of elements currently in the steque.
     * @return size as integer.
     */
    //time complexity is O(1);space complexity O
    public int size() {
        return n;

    }
    
    /**
     * returns an iterator over the elements 
     * stored in steque.
     * 
     */
    public Iterator<Item> iterator() {

    }


}
