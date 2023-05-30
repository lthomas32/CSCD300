

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;



public class QuickSortTesting {
    @Test
    public void intlinkedListQuickSort(){
        DLinkedList list = new DLinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.quickSort();
        assertEquals("1 2 3 4 5 ", list.toString());

    }

    @Test
    public void singleintLinkedListQuickSort(){
        DLinkedList list = new DLinkedList();
        list.addFirst(1);
        list.quickSort();
        assertEquals("1 ", list.toString());
    }

    @Test
    public void twoIntLinkedListQuickSort(){
        DLinkedList list = new DLinkedList();
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(3);
        list.quickSort();
        assertEquals("1 2 3 ", list.toString());
    }

    @Test
    public void longlistofIntQuickSort(){
        DLinkedList list = new DLinkedList();
        Random rand = new Random();
        for (int i = 0; i < 20000; i++){
            list.addFirst(rand.nextInt(5000));

        }
        Integer prev = null;
        list.quickSort();
        for(Integer num: list) {
            if (prev == null || prev <= num)
                prev = num;
            else
                fail();
        }
        //walk the list if the next one isnt bigger or equal fail

    }
}
