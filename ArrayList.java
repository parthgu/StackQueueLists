
public class ArrayList <T> {
	
	protected Node<T> head = null;
	
	/**
	 * Node
	 * ----
	 * Node is a private inner class that creates a link for the ArrayList
	 */
	private class Node<T1>{
		private T1 data;
		private Node<T1> next;
		
		/**
		 * Node(newData)
		 * --------------------
		 * Sets node's data to newData
		 */
		private Node(T1 newData) {
			this.data = newData;
		}
		
		/**
		 * Node(newData, link)
		 * -------------------
		 * Sets node's data to newData,
		 * Sets node's next to link node
		 */
		private Node(T1 newData, Node<T1> link) {
			this.data = newData;
			this.next = link;
		}
	}
	
	/**
	 * main
	 * -----
	 * Tests for methods in the ArrayList class
	 */
	public static void main(String[] args) {
		ArrayList<Integer> empty = new ArrayList<>();
	    ArrayList<Integer> one = new ArrayList<>();
	    ArrayList<Integer> multiple = new ArrayList<>();
		
	    one.append(5);
	    
	    multiple.append(10);
	    multiple.append(20);
	    multiple.append(30);

	    System.out.println("Empty (should print nothing): " + empty);     // ( note the implicit call to toString()! )
	    System.out.println("One (should print '5'): " + one);
	    System.out.println("Multiple (should print '10, 20, 30'): " + multiple);	

	    one.delete(0);
	    multiple.delete(1);
	    System.out.println("One (upon delete) (should be empty): " + one);
	    System.out.println("Multiple (upon delete) (should be '10, 30'): " + multiple);

	    System.out.print("Attempting an illicit insert at index 5. Error message should print: ");
	    one.insert(400, 5);
	    System.out.println("One (on insert) (should still be empty): " + one);
	    
	    empty.insert(1, 0);
	    test(empty.get(0) == 1, "insert() on empty ArrayList");
	    test(empty.remove(0) == 1, "remove() on ArrayList with one element");
	    test(empty.size() == 0, "size() on empty");
	    
	    empty.append(15);
	    test(empty.get(0) == 15, "append() on empty");
	    empty.remove(0);
	    test(empty.size() == 0, "size() on empty");
	    
	    one.append(100);
	    test(one.size() == 1, "size() on one");
	    one.append(50);
	    test(one.get(1) == 50, "append() on one");
	    
	    multiple.append(50);
	    test(multiple.size() == 3, "size() on multiple");
	    
	    empty.insert(1, 0);
	    test(empty.get(0) == 1, "insert() on empty");
	    empty.delete(0);
	    
	    one.insert(1000, 0);
	    test(one.get(0) == 1000, "insert() on one at head");
	    one.delete(0);
	    
	    one.insert(509, 1);
	    test(one.get(1) == 509, "insert() on one at end");
	    one.delete(1);
	    one.delete(1);
	    
	    multiple.insert(81, 0);
	    test(multiple.get(0) == 81, "insert() on multiple at head");
	    
	    multiple.insert(55, 2);
	    test(multiple.get(2) == 55, "insert() on multiple in body");
	    
	    multiple.insert(98, multiple.size());
	    test(multiple.get(multiple.size() - 1) == 98, "insert() on multiple at end");
	    
	    test(multiple.remove(0) == 81, "remove() on multiple at head");
	    
	    test(multiple.remove(multiple.size() - 1) == 98, "remove() on multiple at end");
	   
	    test(multiple.remove(2) == 30, "remove() on multiple in body");
	    
	    test(one.remove(0) == 100, "remove() on one");
	    one.append(25);
	    
	    test(multiple.indexOf(55) == 1, "indexOf() on multiple");
	    
	    test(one.indexOf(25) == 0, "indexOf() on one");
	    
	    test(empty.indexOf(1) == -1, "indexOf() on empty");
	    
	    ArrayList<Integer> empty2 = new ArrayList<>();
	    test(empty.equals(empty2), "equals() on both empty");
	    empty2.append(1);
	    test(empty.equals(empty2) == false, "equals() on empty (should be false)");
	    
	    ArrayList<Integer> one2 = new ArrayList<>();
	    one2.append(25);
	    test(one.equals(one2), "equals() on one");
	    one2.append(2);
	    test(one.equals(one2) == false, "equals() on one (should be false)");
	    
	    ArrayList<Integer> multiple2 = new ArrayList<>();
	    multiple2.append(10);
	    multiple2.append(55);
	    multiple2.append(50);
	    test(multiple.equals(multiple2), "equals() on multiple");
	    multiple.delete(0);
	    test(multiple.equals(multiple2) == false, "equals() on multiple (should be false)");
	    
	    ArrayList<String> str = new ArrayList<>();
	    test(multiple2.equals(str) == false, "equals() on ArrayLists with different types");
	    

	}
	
	/**
	 * test(testCondition, testName)
	 * ----
	 * PRE: testCondition is a boolean value
	 * POST: if testCondition true, prints "TEST PASSED"
	 * 		 if testCondition false, prints "TEST FAILED"
	 */
	public static void test(boolean testCondition, String testName) {
		if(testCondition)
			System.out.println(testName + ": TEST PASSED :)");
		else
			System.out.println(testName + ": TEST FALILED :(");
	}
	
	/**
	 * insert(newData, index)
	 * ----------------------
	 * PRE: ArrayList is not null
	 * POST: if index <= size,
	 * 	newData is inserted at index and shifts everything to right of the list right by one.
	 * 		 if index > size, nothing is inserted and prints "Nothing was inserted" 
	 */
	public void insert(T newData, int index) {
		if(index < 0 || index > this.size()) { // is index not in range?			System.out.println("Invalid index. Didn't insert");
			return;
		}
		if(index == this.size()) { // is index at the end of ArrayList?
			this.append(newData);
			return;
		}
		if(index == 0) { // is index at head?
			this.head = new Node(newData, this.head);
			return;
		}
		Node cursor = this.head;
		for(int i = 0; i < index - 1; i++) { // loop gets cursor to node behind index 
			cursor = cursor.next;
		}
		cursor.next = new Node(newData, cursor.next); 
		
		
	}
	
	/**
	 * remove(index)
	 * -------------
	 * PRE: ArrayList is not null
	 * POST: if index < size and index >= 0,
	 * 	the object at index is removed and returned from the list, 
	 * 	and everything to the right of index is shifted left
	 * 		 if index >= size or size < 0,
	 * 	returns null, nothing is shifted, and prints "Invalid index"
	 * 		
	 */
	public T remove(int index) {
		if(this.size() == 0) { // is list empty?
			System.out.println("List is empty. Returned null.");
		}
		if(index >= this.size() || index < 0) {
			System.out.println("Invalid index. Returned null.");
			return null;
		}
		if(index == 0) { // is index at the head?
			Node<T> temp = this.head;
			this.head = this.head.next;
			return temp.data;
		}
		return remove(index, this.head, 0);
	}
	
	/**
	 * remove(targetIndex, head, currentIndex)
	 * ---------------------------------------
	 * PRE: targetIndex > size, target >= 0, head is head of ArrayList, currentIndex == 0
	 * POST: deletes and returns object at the target index, and shifts everything after the index to the left
	 */
	private T remove(int targetIndex, Node<T> head, int curIndex) {
		if(targetIndex - 1 == curIndex) { // base case
			Node<T> temp = head.next;
			head.next = head.next.next;
			return temp.data;
		}
		return remove(targetIndex, head.next, curIndex + 1);
	}
	
	/**
	 * append(newData)
	 * ---------------
	 * PRE: ArrayList is not null
	 * POST: adds newData to the end of the ArrayList
	 */
	public void append(T newData) {
		if(this.head == null) { // is list empty?
			this.head = new Node(newData);
			return;
		}
		Node cursor = this.head;
		while(cursor.next != null) { // loop gets cursor to last element in ArrayList
			cursor = cursor.next;
		}
		cursor.next = new Node(newData);
	}
	
	/**
	 * delete(index)
	 * -------------
	 * PRE: ArrayList is not null
	 * POST: if ArrayList is empty or index > size or index < 0, nothing is deleted
	 * 		if ArrayList is occupied and index is in range, object at index is deleted and 
	 * 		everything to the right is shifted left
	 */
	public void delete(int index) {
		if(index >= this.size() || index < 0) // is index not in range?
			return;
		else if(this.size() == 0) // is list empty?
			return;
		else if(index == 0) { // is index at the head?
			this.head = this.head.next;
			return;
		}
		delete(index, this.head, 0);
	}
	
	/**
	 * delete(targetIndex, head, curIndex)
	 * ----------------------------------
	 * PRE: targetIndex >= 0, targetIndex < size, head is the ArrayList head, curIndex is 0
	 * POST: deletes the node at targetIndex and shifts everything to the right down
	 */
	private void delete(int targetIndex, Node<T> head, int curIndex) {
		if(head == null) // base case.
			return;
		else if(targetIndex - 1 == curIndex) {
			Node<T> temp = head.next.next;
			head.next = temp;
			return;
		}
		delete(targetIndex, head.next, curIndex + 1);
	}

	/**
	 * get(index)
	 * ----------
	 * PRE: ArrayList is not null
	 * POST: if index >= size or index < 0, returns null
	 * 		otherwise, returns the data of the ArrayList at index
	 */
	public T get(int index) {
		if(index >= this.size() || index < 0) { // is index not in range?
			System.out.println("Index does not exist. Returned null.");
			return null;
		}
		Node<T> cursor = this.head;
		for(int i = 0; i < index; i++) { // loop gets cursor to target index
			cursor = cursor.next;
		}
		return cursor.data;
	}
	
	
	/**
	 * size()
	 * ------
	 * PRE: ArrayList is not null
	 * POST: returns number of objects in the ArrayList
	 */
	public int size() {
		return size(this.head);
	}
	
	
	/**
	 * size(head)
	 * ---------
	 * PRE: head must be the ArrayList head
	 * POST: returns the number of objects in the ArrayList
	 */
	private int size(Node<T> head) {
		if(head == null) // base case
			return 0;
		else
			return 1 + size(head.next);
	}

	public boolean isEmpty() {
		if(this.head == null)
			return true;
		return false;
	}

	
	/**
	 * toString()
	 * ----------
	 * Returns the string representation of the ArrayList
	 * ex. "1 2 3 "
	 */
	@Override
	public String toString() {
		return toString(this.head);
	}
	
	
	/**
	 * toString(head)
	 * -------------
	 * PRE: head is the ArrayList head
	 * POST: Returns string representation of the ArrayList
	 * ex. "1 2 3 "
	 */
	private String toString(Node<T> head) {
		if(head == null) // base case
			return "";
		else return head.data + " " + toString(head.next);
	}
	
	/**
	 * indexOf(target)
	 * --------------
	 * Returns the index of first instance of the target in the ArrayList.
	 * If target is not in ArrayList, returns -1.
	 */
	public int indexOf(T target) {
		return indexOf(target, this.head);
	}
	
	/**
	 * indexOf(target, head)
	 * --------------------
	 * PRE: head is the ArrayList head
	 * POST: Returns the index of first instance of the target in the ArrayList.
	 * 		If target is not in ArrayList, returns -1.
	 */
	private int indexOf(T target, Node<T> head) {
		if(head == null) // base case #1
			return -1;
		else if(head.data.equals(target)) // base case #2
			return 0;
		else
			return 1 + indexOf(target, head.next);
	}

	
	/**
	 * equals(other)
	 * ------------
	 * PRE: other is not null
	 * POST: Returns true if every element in each ArrayList is equivalent
	 * 		returns false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		if(other.getClass() != this.getClass()) // checks if other object is a ArrayList
			return false;
		ArrayList<T> otherArrayList;
		try {
			otherArrayList = (ArrayList<T>) other;
		}
		catch(Exception e) {
			return false;
		}
		
		return equals(this.head, otherArrayList.head);
		
	}
	
	/**
	 * equals(thisHead, otherHead)
	 * ---------------------------
	 * PRE: thisHead is the head of this ArrayList, otherHead is the head of the other ArrayList
	 * POST: returns true if every element in this ArrayList is equivalent to other ArrayList
	 * 		returns false otherwise 
	 */
	private boolean equals(Node<T> thisHead, Node<T> otherHead) {
		if(thisHead == null ^ otherHead == null) // base case #1
			return false;
		if(thisHead == null && otherHead == null) // base case #2
			return true;
		if(thisHead.data != otherHead.data) // base case #3
			return false;
		return equals(thisHead.next, otherHead.next);
	}
}

