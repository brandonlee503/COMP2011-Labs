import java.util.*;

class Link
   {
   public int iData;                 // data item
   public Link next;                  // next link in list
// -------------------------------------------------------------
   public Link(int d)                // constructor
      { iData = d; }
// -------------------------------------------------------------
   public void displayLink()          // display this link
      { System.out.print(iData + " "); }
// -------------------------------------------------------------
   }  // end class Link
////////////////////////////////////////////////////////////////
class FirstLastList
   {
   private Link first;               // ref to first link
   private Link last;                // ref to last link
// -------------------------------------------------------------
   public FirstLastList()            // constructor
      {
      first = null;                  // no links on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertFirst(int i)  // insert at front of list
      {
      Link newLink = new Link(i);   // make new link

      if( isEmpty() )                // if empty list,
         last = newLink;             // newLink <-- last
      newLink.next = first;          // newLink --> old first
      first = newLink;               // first --> newLink
      }
// -------------------------------------------------------------
   public void insertLast(int i)   // insert at end of list
      {
      Link newLink = new Link(i);   // make new link
      if( isEmpty() )                // if empty list,
         first = newLink;            // first --> newLink
      else
         last.next = newLink;        // old last --> newLink
      last = newLink;                // newLink <-- last
      }
// -------------------------------------------------------------
   public int deleteFirst()         // delete first link
      {                              // (assumes non-empty list)
      int temp = first.iData;
      if(first.next == null)         // if only one item
         last = null;                // null <-- last
      first = first.next;            // first --> old next
      return temp;
      }
//--------------------------------------------------------------
   public void displayFirstLast()
   {
	   if (first != null)
		   System.out.println("First-" + first.iData + "; Last-" + last.iData);
	   else 
		   System.out.println("The list is empty");
   }
// -------------------------------------------------------------
   public void displayList()
      {
      System.out.print("List (first-->last): ");
      Link current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayLink();      // print data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
    public void removeDupLink(){
    	int maxVal = 0;
    	Link current1 = first;
    	while(current1 != null){
    		if(current1.iData > maxVal)
    			maxVal = current1.iData;                                                           //Get max key value
    		current1 = current1.next;
    	}
    	
    	HashTable theTable = new HashTable(maxVal);												   //Declare hashtable and hashset
    	DataItem theDataItem;
    	Set<Integer> theSet = new HashSet<Integer>();
    	
    	while(!isEmpty()){
    		if(theTable.find(first.iData) == null && !theSet.contains(first.iData)){              //If key is not in hashtable or hashset
    			theDataItem = new DataItem(first.iData);						                  //Insert it into the hashtable and set
    			theTable.insert(theDataItem);
    			theSet.add(first.iData);
    		}else
    			theTable.delete(first.iData);									                  //Otherwise, delete it from the hashtable
    		deleteFirst();																	      //Remove link from linked list in the process
    	}
    	
    	for(int i=0; i<maxVal+1; i++){															  //For all iData values remaining in hashtable,
    		if(theTable.find(i) != null)														  //reinsert into linked list
    			insertFirst(theTable.delete(i).getKey());
    	}
    }
// -------------------------------------------------------------
   }  // end class FirstLastList
////////////////////////////////////////////////////////////////
class FirstLastApp
   {
   public static void main(String[] args)
      {                              // make a new list
      FirstLastList theList = new FirstLastList();

      theList.insertFirst(22);       // insert at front
      theList.insertFirst(33);
      theList.insertFirst(33);
      theList.insertFirst(22);
      
      theList.displayList();
      theList.removeDupLink();
      theList.displayList();
      theList.displayFirstLast();
      }  // end main()
   }  // end class FirstLastApp
////////////////////////////////////////////////////////////////
