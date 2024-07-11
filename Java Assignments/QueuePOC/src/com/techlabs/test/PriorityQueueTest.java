/*
 * There are three chained interfaces from queue.
 * 					--> Dequeue
 * 					--> Blocking queue
 * 					--> Blocking dequeue
 * 
 * There are two classes that implement queue
 * 					---> Priority queue
 * 					---> LinkedList
 * 
 *  Queue is used when there is priority to process the group of elements
 *  
 *  Queue follows FIFO concept
 *  
 *  							LinkedList				Priority Queue
 *  
 *  	Insertion order			preserved				preserved
 *  	Duplicate elements		allowed					allowed
 *  	Heterogeneous data		allowed 				not allowed
 *  
 *  
 *  Methods implemented by Queue interface in these two classes
 *  
 *				--> Methods to insert elements in queue (Elements are inserted from tail of queue)
 *								--> add() -> returns true on successful insertion of element or else gives exception
 *								--> offer() -> returns true on successful insertion of element or else returns false
 *
 *				--> Methods to retrieve head element from queue
 *								-->element() -> returns nosuchelementfound exception when there are no elements in queue
 *								-->peek() -> returns null when there are no elements in queue
 *
 *				--> Methods to remove and return header element
 *								-->remove() -> if elmts present return head elmt and remove head elmt and if queue is empty gives exception
 *								-->poll() -> if elmts present return head elmt and remove head elmt if queue is empty return null
 */

package com.techlabs.test;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue queue = new PriorityQueue();

		// Adding elements
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.offer("C");
		queue.offer(3); // heterogeneous data not allowed

		System.out.println(queue);

		// methods to get head element
		System.out.println(queue.element());
		System.out.println(queue.peek());

		// Return and remove head element
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);

		// Iterator
		Iterator iterator = queue.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// Enhanced for loop
		for (Object q : queue) {
			System.out.println(q);
		}

	}

}
