
public class Stack <T> extends Quack<T>{

	/**
	 * push(next)
	 * ----------
	 * PRE: stack is not null
	 * POST: adds next to the top of the stack
	 */
	public void push(T next) {
		super.append(next); // adds next to end of quack
	}
	
	/**
	 * pop()
	 * -----
	 * PRE: stack is not null
	 * POST: if stack is empty, returns null,
	 * 		 if stack is occupied, removes and returns the object at the top of the stack
	 */
	public T pop() {
		return super.remove(super.size() - 1); // removes the object at the end of the quack
	}
	
	/**
	 * peek()
	 * ------
	 * PRE: stack is not null
	 * POST: if stack is empty, returns null.
	 * 		 if stack is occupied, returns object at top of stack, without removing it.
	 */
	public T peek() {
		return super.get(super.size() - 1); // gets the object at the end of the quack
	}
	
	/**
	 * main
	 * ------
	 * Tests methods in the Stack class
	 */
	public static void main(String[] args) {
		Stack<Integer> empty = new Stack<>();
		Stack<Integer> one = new Stack<>();
		Stack<Integer> multiple = new Stack<>();
		
		one.push(1);
		multiple.push(1);
		multiple.push(2);
		multiple.push(3);
		
		System.out.println("Empty (should print nothing): " + empty);
		System.out.println("One (should print '1': " + one);
		System.out.println("Multiple (should print '1 2 3'): " + multiple);
		
		test(empty.peek() == null, "peek() on empty");
		test(one.peek() == 1, "peek() on one");
		test(multiple.peek() == 3, "peek() on multiple");
		
		System.out.println("After peek(), empty should remain the same (should print nothing): " + empty);
		System.out.println("After peek(), one should remain the same (should print '1'): " + one);
		System.out.println("After peek(), multiple should remain the same (should print '1 2 3'): " + multiple);
		
		test(empty.pop() == null, "pop() on empty");
		test(one.pop() == 1, "pop() on one");
		test(multiple.pop() == 3, "pop() on multiple");
		
		System.out.println("After peek(), empty should remain the same (should print nothing): " + empty);
		System.out.println("After peek(), one should be empty (should print nothing): " + one);
		System.out.println("After peek(), multiple should print '1 2': " + multiple);
	}
	
	
}
