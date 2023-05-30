
import java.util.Iterator;

public class DLinkedList implements Iterable<Integer> {
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        private Integer element;
        private Node next;
        private Node prev;

        public Node(final Integer element, final Node prev, final Node next){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        public Node (final int element){
            this(element, null, null);
        }

    }


    public DLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, this.head, null);
        this.head.next =this.tail;
        this.size = 0;
    }

    public void addFirst(final Integer num){
        Node first = new Node (num, this.head, this.head.next);
        first.next.prev = first;
        this.head.next = first;
        size++;
    }

    public void insertBefore(final Node original, final Node insertion){
        insertion.next = original;
        insertion.prev = original.prev;
        original.prev.next = insertion;
        original.prev = insertion;
        size++;
    }
    public void remove(final Node deleted){
        deleted.prev.next = deleted.next;
        deleted.next.prev = deleted.prev;
        size --;
        deleted.next = null;
        deleted.prev = null;
    }

    public void quickSort(){
        quickSort(this.head, this.tail);
    }

    private void quickSort(final Node left, final Node right) {
        //Basically if either are null it's bad, if left or right equal the wrong side also out of bounds.
        //if the prev or next = the end I know I only have one element who cares.
        //if left.next is the right my list is size zero since I start one from the left and right
        if (!(left == null || left == tail || right == null || right == head || right == left || left.prev == right ||
                left.next == tail || right.prev == head || left.next == right)) {
            Node pivot = pivot(left,right);
            quickSort(left, pivot);
            quickSort(pivot,right);
        }
    }

    private Node pivot(final Node start, final Node end){
        Node pivot = end.prev;
        Node index = start.next;
        Node i = start.next;

        while (i != pivot) {
            if (i.element <= pivot.element) {
                i = i.next;
                //I made my quickSortInsertion return 0 or 1
                int flag = quickSortInsertion(index, i.prev);
                //if its zero that means nothing happened so increment the index
                //if it did then index moved forward automatically
                if (flag == 0) {
                    index = index.next;
                }
            } else {
                i = i.next;
            }
        }
        quickSortInsertion(index, pivot);
        return pivot;
    }

    private int quickSortInsertion(final Node index, final Node pivot) {
        if (!(index == pivot || index == null || pivot == null)) {
            this.remove(pivot);
            this.insertBefore(index, pivot);
            return 1;
        }
        return 0;
    }

    @Override
    public String toString(){
        String result = "";
        Node current = this.head.next;
        while (current != this.tail){
            result += current.element + " ";
            current = current.next;
        }
        return result;
    }





    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer>{
        Node curr = head.next;
        @Override
        public boolean hasNext() {
            return (curr != tail);
        }

        @Override
        public Integer next() {
            Integer temp = curr.element;
            curr = curr.next;
            return temp;
        }
    }
}
