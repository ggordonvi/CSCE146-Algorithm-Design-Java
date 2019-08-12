/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 19, 2017
 * 10:14:08 AM
 */

/**
 * @author aylanickerson
 *
 */
public interface QueueInterface <T>{ //interfaces are blueprints for classes that become blueprints for instances
	public void enqueue(T data); //add data
	public T dequeue();//removes data
	public T peek();//returns the object but doesnt remove the object
	public void print();
}
