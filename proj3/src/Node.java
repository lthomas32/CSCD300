//Lewis Thomas
//CSCD300
//Node for project 3
public class Node {


   private int id;
   private int processingTime;
   private Node prev; // the link referencing the previous node in the link list.
   private Node next; // the link referencing to the next node in the link list.



   public Node(final String element, final Node prev, final Node next) {
      String [] temp = element.split(",");
      this.id = Integer.parseInt(temp[0]);
      this.processingTime = Integer.parseInt(temp[1]);
      this.next = prev;
      this.prev = next;
      
   }
   public Node(final String element){ this(element,null,null);}

   public int getId() {
      return this.id;
   }

   public String toString(){
      return "ID: " + this.id + " Processing Time: " + this.processingTime;
   }
   public int getProcessingTime() { return this.processingTime; }
   public Node getNext() {
      return this.next;
   }
   public Node getPrev() {
      return this.prev;
   }
   public void setProcessingTime(final int processingTime) { this.processingTime = processingTime; };
   public void setNext(final Node next) {
      this.next = next;
   }
   public void setPrev(final Node prev) {
      this.prev = prev;
   }
    
} // end class DNode