/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		String result = shortList.remove(0);
		assertEquals("Remove: check a is correct", "A", result);
		assertEquals("Remove: check element 0 is correct", "B", shortList.get(0));
		assertEquals("Remove: check size is correct", 1, shortList.size);

        try {
            emptyList.remove(0);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
	    boolean result = list1.add(1);
	    assertEquals("AddEnd: check return value is correct", true, result);
	    assertEquals("AddEdd: check the last node's value", (Integer)1, list1.get(list1.size - 1));
	    assertEquals("AddEdd: check size is correct", 4, list1.size);

	    emptyList.add(1);
        assertEquals("Add: check the added node's value", (Integer)1, emptyList.get(0));
        assertEquals("Add: check the size is correct", 1, emptyList.size);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
	    assertEquals("Size: check size is correct", 3, list1.size);
	    assertEquals("Size: check size is correct", 2, shortList.size);
	    assertEquals("Size: check size is correct", 0, emptyList.size);
	    assertEquals("Size: check size is correct", 10, longerList.size);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
	    list1.add(0, 3);
        assertEquals("Add: check the added node's value", (Integer)3, list1.get(1));
        assertEquals("Add: check the size is correct", 4, list1.size);
        shortList.add(1, "C");
        assertEquals("Add: check the added node's value", "C", shortList.get(2));
        assertEquals("ALLNode<E> newNode = new LLNode<E>(element);dd: check the size is correct", 3, shortList.size);
        longerList.add(longerList.size - 1, 100);
        assertEquals("Add: check the added node's value", (Integer)100, longerList.get(longerList.size - 1));
        assertEquals("Add: check the size is correct", 11, longerList.size);
        emptyList.add(0, 3);
        assertEquals("Add: check the added node's value", (Integer)3, emptyList.get(0));
        assertEquals("Add: check the size is correct", 1, emptyList.size);
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    list1.set(0, 3);
	    assertEquals("Set: check the modified value", (Integer)3, list1.get(0));
	    assertEquals("Set: check the size is correct", 3, list1.size);
        try {
            emptyList.set(0, 3);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }
        try{
            shortList.set(0, null);
            fail("Null Pointer Exception");
        }
        catch(NullPointerException e) {

        }
	}
	
	
	// TODO: Optionally add more test methods.
	
}
