/*
  Test progream for the implementation of the FIFO queue data structure. 

  Author: Bojian Xu, bojianxu@gmail.com
 */

public class Test_Queue{
    public static void main(String[] args){
	//Queue queue = new ArrayQueue(1);   //test the array-based implementation.
	Queue queue = new ListQueue();  //test the linked list-based implementation.

	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.enqueue("hello");
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.enqueue("cscd300");
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.enqueue("too");
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.enqueue("much");
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.enqueue("work");
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.enqueue("I");
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.enqueue("will");
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.enqueue("survive");
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

	queue.dequeue();
	System.out.println("queue size: " + queue.size() + ".  Front item: " + queue.front());

    }

}

