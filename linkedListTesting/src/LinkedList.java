import java.util.Iterator;

public class LinkedList<T extends Comparable<? super T>> implements Iterable<T>{
    Node head;
    private int size;
    private class Node {
        private T element;
        private Node next;

        public Node(final T element,final Node next){
            this.element = element;
            this.next = next;
        }
        public Node (final T element){
            this(element, null);
        }

        public T getElement() { return element; }
        public Node getNext() { return next; }
        public void setElement(T element) { this.element = element; }
        public void setNext(Node next) { this.next = next; }

    }

    public void addFirst(final T element){
        head = new Node(element, head);
        size++;
    }

    public void addLast(final T element){
        if (size == 0)
            addFirst(element);
        else{
            Node current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(new Node(element));
            size++;
        }
    }

    public void addAfter(final Node before, final Node after){
        if(after == null)
            return;
        else if (before == null){
            after.setNext(this.head);
            this.head = after;
            size++;
        }
        else{
            after.setNext(before.getNext());
            before.setNext(after);
            size++;
        }
    }

    public void removeFirst(){
        if (size == 0)
            return;
        else{
            head = head.getNext();
            size--;
        }
    }

    public void removeLast(){
        if (size == 0)
            return;
        else if (size == 1){
            head = null;
            size = 0;
        }
        else{
            Node current = head;
            while (current.getNext().getNext() != null)
                current = current.getNext();
            current.setNext(null);
            size--;
        }
    }

    public Node remove(Node before, Node deleted){
        if (deleted == null)
            return null;
        else if (before == null){
            removeFirst();
            return deleted;
        }
        else{
            before.setNext(deleted.getNext());
            deleted.setNext(null);
            size--;
            return deleted;
        }
    }

    public void reverseLinkedList(){
        if (this.size<=1)
            return;


        Node current = this.head.getNext();
        Node prev = this.head;
        Node walker = current.getNext();
        this.head.setNext(null);

            while(walker != null){
                current.setNext(prev);
                prev = current;
                current = walker;
                walker = walker.getNext();
            }
            current.setNext(prev);
            this.head = current;

    }

    public void selectionSort(){
        if(this.size <= 1)
            return;

        Node curr = this.head;
        Node prev = null;
        Node min = null;
        Node prevMin = null;
        Node prevSearch = null;
        Node search = null;
//test
        for(; curr.getNext() != null; curr = curr.getNext()) {
            min = prevSearch = curr;
            prevMin = prev;
            for (search = curr.getNext(); search != null; search = search.getNext()) {
                if (min.getElement().compareTo(search.getElement()) > 0){
                    prevMin = prevSearch;
                    min = search;
                }
                prevSearch = search;
            }


            if (min != curr) {
                if (prevMin == curr) {
                    remove(prev, curr);
                    addAfter(min, curr);
                }
                else {
                    remove(prevMin, min);
                    remove(prev, curr);
                    addAfter(prevMin, curr);
                    addAfter(prev, min);
                }
                curr = min;
            }
            prev = curr;
        }
    }

    public void bubbleSort(){
        if (size > 1){
            Node curr, prev;
            int right = this.size - 1;

            while(right >= 0){
                prev = null;
                int index = 0;
                int new_right = -1;


                for (curr = this.head; index < right; curr = curr.getNext(),index++) {
                    if (curr.getElement().compareTo(curr.getNext().getElement()) > 0) {
                        curr = swap(prev,curr,curr.getNext());
                        new_right = index;

                    }
                    prev = curr;

                }
                right = new_right;
            }
        }
    }


    private Node swap(Node prev, Node curr, Node next){
        if (prev == null){
            curr.setNext(next.getNext());
            next.setNext(curr);
            this.head = next;
            return next;
        }
        else{
            curr.setNext(next.getNext());
            next.setNext(curr);
            prev.setNext(next);
            return next;
        }
    }



    @Override
    public String toString(){
        String result = "";
        Node current = head;
        while (current != null){
            result += current.getElement() + " ";
            current = current.getNext();
        }
        return result;
    }



    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        Node curr = head;
        @Override
        public boolean hasNext() {
            return (curr != null);
        }

        @Override
        public T next() {
            T temp = curr.getElement();
            curr = curr.getNext();
            return temp;
        }
    }


}
