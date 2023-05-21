/*
   Implement the Iterator interface for the nested MyListIterator class
   which occurs at the bottom of the source code.
   
   Check the Java IPI documentation on Iterator for the three methods
   you must write.  Those methods are hasNext, next, and remove.
   Note that the third method, remove, is optional.
   For your implementation of remove, throw an UnsupportedOperationException.
   Include in your thrown exception the message
   'remove not implemented for MyListIterator'
   
   Look carefully at the iterator method of MyList to see what information
   is passed to the MyListIterator constructor to help you with writing
   your methods.  Also look at the fields provided in the MyListIterator
   class.  You will need those fields to properly implement your methods.
   
   NOTE: The Iterator interface allows you to use an enhanced for loop
   (sometimes called the foreach loop) on any class that implements
   the interface.  Iterator is typically attached to classes that contain
   some form of collection of data (array, ArrayList, etc.) as one of 
   its primary fields.
   
   The Iterator is used to keep track of the current location in a collection
   and move through the collection one step at a time.  What 'one step at a
   time means' can vary from collection to collection.  With something like an
   array or ArrayList, one step at at time just means advance to the next item
   in the array/ArrayList.

*/

import java.util.ArrayList;
import java.util.Iterator;

public class MyList implements Iterable
{
   private ArrayList<String> list;
   
   public MyList()
   {
      this.list = new ArrayList<String>();
   
   }//end default constructor
   
   public void addLast(String str)
   {
      this.list.add(str);
   }//end addLast
   
   public int size()
   {
      return this.list.size();
   
   }//end size method
   
   public String toString()
   {
      String result = "";
      
      for (Object o: this)
         result += o + "\r\n";
         
      return result;
   
   }//end toString
   
   public Iterator iterator()
   {
      return new MyListIterator();
   }//end iterator -- required by Iterable interface

//***************************************************************************   
   //Nested class to provide a means of iterating across the MyList collection
   //*Implement* the Iterator interface and provide the methods required by that
   //interface based on discussion from the Java API documentation.
   public class MyListIterator implements Iterator
   {  
      private int cur = 0;

      
      public MyListIterator()
      {

      }
      
      public boolean hasNext()
      {
        if (cur < list.size())
           return true;
        return false;
      }//end hasNext
      
      public Object next()
      {
         Object temp = list.get(cur);
         cur++;
         return temp;

      }//end next
      
      public void remove()
      {
      }
   
   }//end nested class MyListIterator

   
}//end class MyList