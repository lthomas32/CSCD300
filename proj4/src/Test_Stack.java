/*
  Test progream for the implementation of the stack data structure. 

  Author: Bojian Xu, bojianxu@gmail.com
 */

public class Test_Stack{
    public static void main(String[] args){
	//Stack stack = new ArrayStack();   //test the array-based implementation.
	Stack stack = new ListStack();  //test the linked list-based implementation.

	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.push("hello");
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.push("cscd300");
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.push("too");
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.push("much");
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.push("work");
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.push("I");
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.push("will");
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.push("survive");
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

	stack.pop();
	System.out.println("stack size: " + stack.size() + ".  Top item: " + stack.top());

    }

}

