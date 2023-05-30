

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkListTest {
    @Nested
    public class Reverse{
        @Test
        public void reverseLinkedList(){
            LinkedList<String> list = new LinkedList<>();
            list.addFirst("A");
            list.addFirst("B");
            list.addFirst("C");
            list.addFirst("D");
            list.addFirst("E");
            list.reverseLinkedList();
            assertEquals("A B C D E ", list.toString());
        }

        @Test
        public void reverseLinkedList2Items(){
            LinkedList<String> list = new LinkedList<>();
            list.addFirst("A");
            list.addFirst("B");
            list.reverseLinkedList();
            assertEquals("A B ", list.toString());
        }

    }

    @Nested
    public class SelectionSort {
        @Test
        public void selectionSort(){
            LinkedList<String> list = new LinkedList<>();
            list.addFirst("A");
            list.addFirst("B");
            list.addFirst("C");
            list.addFirst("D");
            list.addFirst("E");
            list.selectionSort();
            assertEquals("A B C D E ", list.toString());
        }

        @Test
        public void selectionSort2Items(){
            LinkedList<String> list = new LinkedList<>();
            list.addFirst("A");
            list.addFirst("B");
            list.selectionSort();
            assertEquals("A B ", list.toString());
        }

        @Test
        public void selectionSort2(){
            LinkedList<String> list = new LinkedList<>();
            list.addFirst("E");
            list.addFirst("F");
            list.addFirst("D");
            list.addFirst("C");
            list.addFirst("A");
            list.addFirst("B");
            list.selectionSort();
            assertEquals("A B C D E F ", list.toString());
        }
    }

    @Nested
    public class BubbleSort{
        @Test
        public void bubbleSort(){
            LinkedList<String> list = new LinkedList<>();
            list.addFirst("A");
            list.addFirst("B");
            list.addFirst("C");
            list.addFirst("D");
            list.addFirst("E");
            list.bubbleSort();
            assertEquals("A B C D E ", list.toString());
        }

        @Test
        public void bubbleSort2Items(){
            LinkedList<String> list = new LinkedList<>();
            list.addFirst("A");
            list.addFirst("B");
            list.bubbleSort();
            assertEquals("A B ", list.toString());
        }

        @Test
        public void bubbleSort2(){
            LinkedList <String> list = new LinkedList<>();
            list.addFirst("E");
            list.addFirst("F");
            list.addFirst("D");
            list.addFirst("C");
            list.addFirst("A");
            list.addFirst("B");
            list.bubbleSort();
            assertEquals("A B C D E F ", list.toString());
        }
    }

    @Nested
    public class Iterator{
        @Test
        public void testListIterator() {
            LinkedList<String> testList = new LinkedList<>();
            testList.addLast("1");
            testList.addLast("2");
            testList.addLast("3");
            testList.addLast("4");
            testList.addLast("5");
            testList.addLast("6");
            String result = "";
            for(String a: testList)
                result += a + " ";
            assertEquals("1 2 3 4 5 6 ", result);
            System.out.println();

        }


    }

    @Nested
    public class Sorting{
        @Test
        public void mergeSortTest(){
            int [] unsorted = {5, 4, 3, 2, 1};
            int [] sorted = {1, 2, 3, 4, 5};
            Sort.mergeSort(unsorted, 0 , unsorted.length - 1);
            assertArrayEquals(sorted, unsorted);
        }
    }

}
