/*
   Tester class for the Iterator interface you must implement
   for the nested MyListIterator class.
   
   Do not change the code for this class.
   
   See results from output.txt for what a correctly implemented Iterator
   for the MyListIterator class should produce.
*/
import java.util.*;

public class Tester
{
   public static void main(String [] args)
   {
      //make a list with three elements in it
      MyList list = new MyList();
      list.addLast("apple");
      list.addLast("banana");
      list.addLast("cherry");
      
      //use an iterator to explicitly walk through the list
      System.out.println("Using an explicit iterator to walk through list");
      Iterator iter = list.iterator();
      
      while (iter.hasNext())
      {
         System.out.println(iter.next());
      }
      //now use enhanced for loop to do the same
      System.out.println("\r\nUsing enhanced for loop to test Iterator");
      for (Object o: list)      
         System.out.println(o);
         
      //next we will use a single item list
      System.out.println("\r\nTesting on a single item list");
      list = new MyList();
      list.addLast("single item");
      
      for (Object o: list)      
         System.out.println(o);
      
      
      //now try on empty list
      System.out.println("\r\nTesting on MyList object that is empty using enhanced for loop");
      MyList list2 = new MyList();
      for (Object o: list2)
         System.out.println(o);
         
      try
      {
         iter.remove();
      }
      catch (UnsupportedOperationException exception)
      {
         System.out.println("\r\nUnsupported Operation Exception on call to remove.");
         System.out.println(exception.getMessage());
      
      }
   
   }//end main




}//end class Tester