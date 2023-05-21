/*
   The interface for the FIFO queue data structure. 

   Author: Bojian Xu, bojianxu@gmail.com
*/

public interface Queue{
    public int size();  // return the number of items currently in the queue. 
    public String front(); // return the item at the head of the queue, but do not remove it from the queue.
    public void enqueue(String item); // insert the new item into the tail of the queue. 
    public String dequeue(); // return and remove the item at the head of queue. 
}






