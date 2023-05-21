//Lewis Thomas
//CSCD300

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayQueue implements Queue{
    protected int capacity;  //the array capacity
    public static final int CAPACITY = 1000; //the defaul array capacity

    protected String[] Q; //the physical array that holds the queue
    protected int head;   //the array index that points to the head item 
    protected int tail;   //the array index that points to the tail item; 
                          //this is different from the textbook implementation (GT, 5th Ed.)
    protected int size;   //the number of items in the queue

    protected File inf;
    protected Scanner fin;
    public ArrayQueue(){
	capacity = CAPACITY; 
	Q = new String[capacity];
	head = -1;
	tail = -1; 
	size = 0;
    }

    public ArrayQueue(int capacity, final String newFile){
        this.capacity = capacity;
        this.Q = new String[capacity];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
        this.inf = openFile(newFile);
        this.fin = openFileScanner(this.inf);
    }

    public int size(){
        return this.size;
    }
    
    public String front(){
        if (this.size == 0)
            throw new NoSuchElementException();
        return this.Q[this.head];
    }
    
    public void enqueue(String item){
        if (this.size == this.capacity)
            throw new IllegalStateException();
        if (this.size == 0){
            this.head = this.tail = 0;
        }
        else{
            this.tail = (this.tail + 1) % this.capacity;
        }
        this.Q[this.tail] = item;
        this.size++;
    }
    
    public String dequeue(){
        if (this.size == 0)
            throw new NoSuchElementException();
        String item = this.Q[this.head];
        this.Q[this.head] = null;
        this.head = (this.head + 1) % this.capacity;
        this.size--;
        return item;
    }

    private static File openFile(final String newFile) {
        //checking to arguments are valid
        if (newFile == null || newFile.isBlank())
            throw new IllegalArgumentException("Your file name was invalid");
        File inf = new File(newFile);

        //I was guaranteed a file. You did not insert the correct path.
        if(!(inf.exists()))
            throw new IllegalArgumentException("Your file does not exist");

        return inf;
    }
    private static Scanner openFileScanner(final File inf){
        if (inf == null)
            throw new IllegalArgumentException("File object is null in openFileScanner");

        try{
            return new Scanner(inf);
        }
        catch(FileNotFoundException e){
            throw new IllegalArgumentException("Invalid file path");
        }

    }

    public void close(){
        this.fin.close();
    }


}



