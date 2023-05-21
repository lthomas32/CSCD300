//Lewis Thomas
//cscd 300


import java.util.NoSuchElementException;

public class ListQueue implements Queue{
    protected Node head;   //the reference pointing to the head item. The head of the queue is also the head of the list
    protected Node tail;   //the reference pointing to the tail item. The tail of the queue is also the tail of the list.
    protected int size;    //the number of items in the queue

    public ListQueue(){
	head = null;
	tail = null; 
	size = 0;
    }

    public int size(){
        return this.size;
    }
    
    public String front(){
        if (this.size == 0)
            throw new NoSuchElementException();
        return this.head.getElement();
    }
    
    public void enqueue(String item){
        Node newNode = new Node(item, null);
        if (this.size == 0){
            this.head = this.tail = newNode;
        }
        else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }
    

    public String dequeue(){
        if (this.size == 0)
            throw new NoSuchElementException();
        String item = this.head.getElement();
        this.head = this.head.getNext();
        this.size--;
        if (this.size == 0)
            this.tail = null;
        return item;
    }
}



