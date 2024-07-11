package com.techlabs.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueTest {

	public static void main(String[] args) {
		Queue queue = new LinkedList();

		// Adding elements
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.offer("C");
		queue.offer(3); // heterogeneous data allowed

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
