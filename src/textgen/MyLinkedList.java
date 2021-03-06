package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>();
		tail = new LLNode<E>();
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element)
	{
	    LLNode<E> node = new LLNode<E>(element);
	    node.next = tail;
	    if(size == 0) {
	    	node.prev = head;
	    	head.next = node;
	    	tail.prev = node;
		} else {
			node.prev = tail.prev;
			tail.prev.next = node;
			tail.prev = node;
		}
		size++;
	    return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
	    if(index < 0 || index >= size) {
	    	throw new IndexOutOfBoundsException("Check out of bounds");
		}
		LLNode<E> node = head.next;
		for(int i = 0; i < index; i++) {
	    	node = node.next;
		}
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
	    if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
        LLNode<E> newNode = new LLNode<E>(element);
		if(size == 0) {
	        newNode.prev = head;
	        newNode.next = tail;
	        head.next = newNode;
	        tail.prev = newNode;
	        size++;
	        return;
        }
		LLNode<E> node = head.next; // add after the node at index index
	    for(int i = 0; i < index; i++) {
	    	node = node.next;
		}
	    newNode.prev = node;
	    newNode.next = node.next;
	    node.next.prev = newNode;
	    node.next = newNode;
	    size++;
	}

	/** Return the size of the list */
	public int size() 
	{
	    return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		LLNode<E> node = head.next;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
		size--;
		return node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		if(element == null) {
		    throw new NullPointerException("Null Pointer Exception");
        }
		LLNode<E> node = head.next;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		node.data = element;
		return element;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode() {
		this.prev = null;
		this.next = null;
	}

}
