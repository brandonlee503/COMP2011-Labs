// sortedList.java
// demonstrates sorted list
// to run this program: C>java SortedListApp
////////////////////////////////////////////////////////////////
class Link
   {
   public long dData;                  // data item
   public Link next;                   // next link in list
// -------------------------------------------------------------
   public Link(long dd)                // constructor
      { dData = dd; }
// -------------------------------------------------------------
   public void displayLink()           // display this link
      { System.out.print(dData + " "); }
   }  // end class Link
////////////////////////////////////////////////////////////////
class SortedList
   {
   public Link first;                 // ref to first item
// -------------------------------------------------------------
   public SortedList()                 // constructor
      { first = null; }
// -------------------------------------------------------------
   public boolean isEmpty()            // true if no links
      { return (first==null); }
// -------------------------------------------------------------
   public void insert(long key)        // insert, in order
      {
      Link newLink = new Link(key);    // make new link
      Link previous = null;            // start at first
      Link current = first;
                                       // until end of list,
      while(current != null && key > current.dData)
         {                             // or key > current,
         previous = current;
         current = current.next;       // go to next item
         }
      if(previous==null)               // at beginning of list
         first = newLink;              // first --> newLink
      else                             // not at beginning
         previous.next = newLink;      // old prev --> newLink
      newLink.next = current;          // newLink --> old currnt
      
      }  // end insert()
// -------------------------------------------------------------
   public Link remove()           // return & delete first link
      {                           // (assumes non-empty list)
      Link temp = first;               // save first
      first = first.next;              // delete first
      return temp;                     // return value
      }
// -------------------------------------------------------------
   public void displayList()
      {
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
   }  // end class SortedList
////////////////////////////////////////////////////////////////
class SortedListApp
   {
   public static void main(String[] args)
      {                            
      SortedList list1 = new SortedList(); //create two sorted lists
      SortedList list2 = new SortedList();
      
      list1.insert(10); //fill list 1
      list1.insert(50);
      list1.insert(30);
      list1.insert(80);
      
      list2.insert(40); //fill list 2
      list2.insert(20);
      list2.insert(60);
      list2.insert(70);
      
      list1.displayList();
      list2.displayList();
      
      SortedList finalList = mergeList(list1, list2); //call function
      finalList.displayList();
      
      }  // end main()
   
   public static SortedList mergeList(SortedList list1, SortedList list2){
	   SortedList finalList = new SortedList();
	   SortedList list1flip = new SortedList(); //Create two extra lists to flip linked list
	   SortedList list2flip = new SortedList();
	   
	   //Flip first link list so new list is sorted by decreasingly
	   while( !list1.isEmpty() ){ 
		   Link newLink = list1.remove();
		   newLink.next = list1flip.first;
		   list1flip.first = newLink;
	   }
	   
	   //Flip second linked list so new list is sorted decreasingly
	   while( !list2.isEmpty() ){
		   Link newLink = list2.remove();
		   newLink.next = list2flip.first;
		   list2flip.first = newLink;
	   }
	   //Go through each link and directly link them into a new list in order
	   //While both aren't empty, move link with higher value to back of the final list
	   while( !list1flip.isEmpty() && !list2flip.isEmpty() ){		   
		   if(list1flip.first.dData > list2flip.first.dData){ //Move list1flip first value to back of final
			   Link newLink = list1flip.remove();
			   newLink.next = finalList.first;
			   finalList.first = newLink;
		   }else{
			   Link newLink = list2flip.remove(); //Move list2flip first value to back of final
			   newLink.next = finalList.first;
			   finalList.first = newLink;
		   }
	   }
	   while( !list1flip.isEmpty() ){ //Move the remaining in list1flip to the final List
		   Link newLink = list1flip.remove();
		   newLink.next = finalList.first;
		   finalList.first = newLink;
	   }
	   while( !list2flip.isEmpty() ){ //Move the remaining in list2flip to the final list
		   Link newLink = list2flip.remove();
		   newLink.next = finalList.first;
		   finalList.first = newLink;
	   }
	   return finalList;
   }
   
   }  // end class SortedListApp
////////////////////////////////////////////////////////////////