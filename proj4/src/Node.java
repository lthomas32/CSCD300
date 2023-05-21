/*
  Node of a singly linked list. 

  Author: Bojian Xu, bojianxu@gmail.com
*/


public class  Node{
    private String element; 
    /* 
       You can add any other fields that you need to save in a node,
       depending on the applications that your program is serving for. 
    */
    
    private Node next;  //the link referencing to the next node in the link list.
    
    public Node(String element, Node next){
	this.element = element; 
	this.next = next; 
    }

    public String getElement() { return element; }
    public Node getNext() { return next; }
    public void setElement(String element) { this.element = element; }
    public void setNext(Node next) { this.next = next; }
}

