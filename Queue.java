
public class Queue <T> extends Quack<T>{

	/**
	 * main
	 * -----
	 * Tests methods in the Queue class
	 */
	public static void main(String[] args) {
		Queue<Integer> empty = new Queue<>();
		Queue<Integer> one = new Queue<>();
		Queue<Integer> multiple = new Queue<>();
		
		one.enqueue(1);
		multiple.enqueue(1);
		multiple.enqueue(2);
		multiple.enqueue(3);
		
		System.out.println("Empty (should print nothing): " + empty);
		System.out.println("One (should print '1': " + one);
		System.out.println("Multiple (should print '1 2 3'): " + multiple);
		
		test(empty.dequeue() == null, "dequeue() on empty");
		test(one.dequeue() == 1, "pop() on one");
		test(multiple.dequeue() == 1, "pop() on multiple");
		
		System.out.println("After dequeue(), empty should remain the same (should print nothing): " + empty);
		System.out.println("After dequeue(), one should be empty (should print nothing): " + one);
		System.out.println("After dequeue(), multiple should print '2 3': " + multiple);
	}
	
	/**
	 * enqueue(data)
	 * -------------
	 * PRE: queue is not null
	 * POST: data passed will be added to the end of the queue
	 */
	public void enqueue(T data) {
		super.append(data); // adds data to end of quack
	}
	
	/**
	 * dequeue()
	 * ---------
	 * PRE: queue is not null
	 * POST: if queue is empty, returns null
	 * 		 if queue is occupied, removes and returns the first object in queue
	 */
	public T dequeue() {
		return super.remove(0); // removes first object of the quack
	}
	
	
}
