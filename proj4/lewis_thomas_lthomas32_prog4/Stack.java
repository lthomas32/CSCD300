/*
   The interface for the stack data structure. 

   Author: Bojian Xu, bojianxu@gmail.com
*/

public interface Stack{
    public int size();  // return the number of items currently in the stack. 
    public String top(); // return the top item in the stack, but do not remove it from the stack.
    public void push(String item); //push the new item into the top of the stack. 
    public String pop(); // return and remove the top time in the stack. 
}






