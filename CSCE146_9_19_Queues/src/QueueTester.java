/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 19, 2017
 * 11:08:31 AM
 */

/**
 * @author aylanickerson
 *
 */
import java.util.*;
public class QueueTester {
public static void main(String[] args) {
	QueueInterface<Integer> queue = new LinkedListQueue<Integer>();
	
	for(int i=0;i<10;i++)
		queue.enqueue(i);
	
	for(int i=0; i<10;i++)
		System.out.println(queue.dequeue());
	
	Queue<Integer> queue2=new LinkedList<Integer>();
}
}
