// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////
class Link
   {
   public int iData;              // data item
   public double dData;           // data item
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id, double dd) // constructor
      {
      iData = id;                 // initialize data
      dData = dd;                 // ('next' is automatically
      }                           //  set to null)
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkList()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      {
      return (first==null);
      }
// -------------------------------------------------------------
                                  // insert at start of list
   public void insertFirst(int id, double dd)
      {                           // make new link
      Link newLink = new Link(id, dd);
      newLink.next = first;       // newLink --> old first
      first = newLink;            // first --> newLink
      }
// -------------------------------------------------------------
   public Link deleteFirst()      // delete first item
      {                           // (assumes list not empty)
      Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp;                // return deleted link
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
// -------------------------------------------------------------
   }  // end class LinkList
////////////////////////////////////////////////////////////////
class LinkListApp
   {
   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make new list
      
      theList.insertFirst(22, 2.99);      // insert four items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);
      
      theList.displayList();              // display list
      
      LinkList the_List = theList;
      
      int links=0;
      LinkList tempList = new LinkList();  //Create temporary list
      
      while( !the_List.isEmpty() ){
    	  Link tLink = the_List.deleteFirst();
    	  tempList.insertFirst(tLink.iData, tLink.dData);
    	  links++;
      }
      
      System.out.println("Number of links is: " + links);  //Print number of links
      
      if(links <= 1){  //Check if list is has 0 or 1 links
    	  System.out.println("There are not enough links to split!");
      }
      else{ //Check if list is even or odd
    	  if(links % 2 == 0){  //The list is even
    		  System.out.println("The list is even!");
    		  for(int i=0; i<links/2; i++){ //Move exactly half of the links
    			  Link reLink = tempList.deleteFirst();
    			  the_List.insertFirst(reLink.iData, reLink.dData);
    		  }
    	  }
    	  else{ //The list is odd
    		  System.out.println("The list is odd!");
    		  for(int i=0; i<(links/2)+1; i++){ //Move exactly half of the links plus one extra
    			  Link reLink = tempList.deleteFirst();
    			  the_List.insertFirst(reLink.iData, reLink.dData);
    		  }
    	  }
          //Move all links to the first and second lists correspondingly
          LinkList firstList = the_List;
          LinkList secondList = tempList;
          
          //Display Results
          System.out.println("The first Linklist: ");
          firstList.displayList();
          System.out.println("The second Linklist: ");
          secondList.displayList(); 	  
      }
   }  // end main()
}  // end class LinkListApp
////////////////////////////////////////////////////////////////
