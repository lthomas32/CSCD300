//Author: Lewis Thomas
//CSCD300
//Assignment 4
public class ListStack implements Stack {
    protected Node top;
    protected int size;


    public ListStack(){
        this.top = null;
        this.size = 0;

    }

    public int size(){return this.size;}
    public String top(){
        if (size == 0)
            return null;

        return this.top.getElement();
    }

    public void push(String item){
        if (item == null)
            return;

        Node nn = new Node(item,this.top);
        this.top = nn;
        size++;
    }

    public String pop(){
        if (size == 0)
            return null;

        Node deleted = this.top;
        this.top = this.top.getNext();
        size--;

        deleted.setNext(null);
        return deleted.getElement();
    }


}