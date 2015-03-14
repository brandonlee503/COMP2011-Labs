class Stack
   {
   private int maxSize;        // size of stack array
   private long[] stackArray;
   private int top;            // top of stack
//--------------------------------------------------------------
   public Stack(int s)         // constructor
      {
      maxSize = s;             // set array size
      stackArray = new long[maxSize];  // create array
      top = -1;                // no items yet
      }
//--------------------------------------------------------------
   public void push(long j)    // put item on top of stack
      {
      stackArray[++top] = j;     // increment top, insert item
      }
//--------------------------------------------------------------
   public long pop()           // take item from top of stack
      {
      return stackArray[top--];  // access item, decrement top
      }
//--------------------------------------------------------------
   public long peek()          // peek at top of stack
      {
      return stackArray[top];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      {
      return (top == -1);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if stack is full
      {
      return (top == maxSize-1);
      }
//--------------------------------------------------------------
   }
class Queue {
	private int maxSize;
	//--------------------------------------------------------------
	public Queue(int s){
		maxSize=s;
	}
	Stack inbox = new Stack(5);
	Stack outbox = new Stack(5);
	//--------------------------------------------------------------
	public void insert(long j){
		inbox.push(j);
	}
	//--------------------------------------------------------------
	public long remove(){
		if(outbox.isEmpty()){
			while(!inbox.isEmpty()){
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}
	//--------------------------------------------------------------
	public boolean isEmpty(){
		return inbox.isEmpty();
	}
}

class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);
      
      theQueue.remove();              // remove 3 items
      theQueue.remove();              //    (10, 20, 30)
      theQueue.remove();
      
      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);

      while( !theQueue.isEmpty() )    // remove and display
         {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
         }
      for(int i=0; i<3; i++){
    	  long x = theQueue.remove();
    	  System.out.print(x);
    	  System.out.print(" ");
      }
      System.out.println("");
      }  // end main()
   }  // end class QueueApp
////////////////////////////////////////////////////////////////
