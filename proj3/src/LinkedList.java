import java.util.NoSuchElementException;

public class LinkedList {
    protected Node cursor;
    protected int size;

    public LinkedList(){
        cursor = null;
        size = 0;
    }

    public void advance(){ // this moves the line of code to the next node. No point if its size is less than 2
        if (size > 1)
            this.cursor = this.cursor.getNext();
    }

    public void reverse(){
        if (size > 1)
            this.cursor = this.cursor.getPrev();
    }
    public void addAfter(final Node v) { //this is adding after cursor
        if (v == null)
            throw new IllegalArgumentException("null Node addAfter");
        if(size == 0) {
            this.cursor = v;
            this.cursor.setNext(this.cursor);
            this.cursor.setPrev(this.cursor);
        } else if (this.size == 1) {
            this.cursor.setNext(v);
            this.cursor.setPrev(v);
            v.setNext(this.cursor);
            v.setPrev(this.cursor);
        } else {
            v.setNext(this.cursor.getNext());
            v.setPrev(this.cursor);
            this.cursor.getNext().setPrev(v);
            this.cursor.setNext(v);
        }
        size++;
    }

    public void addBefore(final Node v){ //time cost is O(Size)
        if (v == null)
            throw new IllegalArgumentException("Null node addBefore");
        if (this.size <=1)
            addAfter(v);
        else{
            v.setNext(this.cursor);
            v.setPrev(this.cursor.getPrev());
            this.cursor.getPrev().setNext(v);
            this.cursor.setPrev(v);
            size ++; //increment size;

        }
    }

    public boolean addSorted(Node v){
        if (v == null)
            throw new IllegalArgumentException("addSorted received null Node");
        if (this.size == 0){
            this.addAfter(v);
            return true;
        }
        if (this.size == 1){
            this.addAfter(v);
            if(this.cursor.getId() > v.getId())
                this.advance();
            return true;
        }
        if (v.getId() < this.cursor.getId()){
            this.addBefore(v);
            this.reverse();
            return true;
        }
        if (v.getId() < this.cursor.getNext().getId()){
            this.addAfter(v);
            return true;
        }
        if (v.getId() > this.cursor.getPrev().getId()){
            this.addBefore(v);
            return true;
        }

        Node curr = this.cursor;

        for (;v.getId() > curr.getId(); curr = curr.getNext())
            ;

        v.setNext(curr);
        v.setPrev(curr.getPrev());
        curr.getPrev().setNext(v);
        curr.setPrev(v);
        this.size++;

        return true;
    }

    public void removeAfter(){
        if (this.size == 0)
            throw new NoSuchElementException("List is empty");
        if (size == 1)
            cursor = null;
        else{
            Node deleted = cursor.getNext();
            this.cursor.setNext(deleted.getNext());
            this.cursor.getNext().setPrev(this.cursor);
        }
        this.size--;
    }

    public void removeBefore(){
        if (this.size == 0)
            return;
        if (this.size <= 2)
            removeAfter();
        else{
            Node cur;


            Node deleted = this.cursor.getPrev();
            this.cursor.setPrev(deleted.getPrev());
            this.cursor.getPrev().setNext(this.cursor);
            size--;

        }

    }
     public boolean remove(Node v){
        if (this.size == 0)
            throw new NoSuchElementException("List is empty");
        if(v == this.cursor){
            this.advance();
            this.removeBefore();
            return true;
        }
        if(this.size == 2){
            this.removeAfter();
            return true;
        }

        v.getNext().setPrev(v.getPrev());
        v.getPrev().setNext(v.getNext());
        this.size--;
        return false;

     }

    public Node getCursor() {return this.cursor;}

    public int size() {return this.size;}

    public String toString(){
        if (this.size == 0)
            return "Empty List";

        Node curr = this.cursor;
        String result = this.cursor + "\n";

        while(curr.getNext() != cursor){
            result += curr.getNext() + "\n";
            curr = curr.getNext();
        }
        return result;

    }




}
