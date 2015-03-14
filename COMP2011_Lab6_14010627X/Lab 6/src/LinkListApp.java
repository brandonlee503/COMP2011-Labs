// simpleLinkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////
class Link
   {
   public int iData;              // data item
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id) 		  // constructor
      {
      iData = id;                 // initialize data
      		                  // ('next' is automatically
      }                           //  set to null)
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      {
      System.out.print("{" + iData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
   {
   public Link first;            // ref to first link on list

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
   public void insertFirst(int id)
      {                           // make new link
      Link newLink = new Link(id);
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
class LinkListApp{
	
   public static void main(String[] args){
      LinkList list1 = new LinkList();  //Make a new list
      LinkList list2 = new LinkList();
      
      //Building list1 for integer "3987"
      list1.insertFirst(7);
      list1.insertFirst(8);
      list1.insertFirst(9);
      list1.insertFirst(3);
      
      //Display List
      list1.displayList();
      
      //Building list2 for integer "9935"
      list2.insertFirst(5);
      list2.insertFirst(3);
      list2.insertFirst(9);
      list2.insertFirst(9);
      
      //Display List
      list2.displayList();
      
     if(isLess(list1, list2) == true){
    	 System.out.println("list1 is less than list2");
     }else{
    	 System.out.println("list2 is less than list1");
     }
   }  // end main()
   
   public static boolean isLess(LinkList list1, LinkList list2){
	  //Create two lists to move links into
      LinkList listOne = new LinkList();
      LinkList listTwo = new LinkList(); 
	   
      //Set variable for multiply proper 10s to the corresponding digit
      int tens_l1 = 1;
      int tens_l2 = 1;
      //Set variable to hold total value
      int list1Total = 0;
      int list2Total = 0;
      //Set variable to count total number of digits
      int size_l1 = 0;
      int size_l2 = 0;
      
      //Count total number of digits in list
      while( !list1.isEmpty() ){
    	  Link temp = list1.deleteFirst(); //Remove link from list
    	  listOne.insertFirst(temp.iData); //Place link in temp list (flips it over)
    	  size_l1++; //Increment for each digit
      }      
      
      //For each digit in list, remove from list and store in total value
      for(int i=0; i < size_l1; i++){
    	  Link tempAdd = listOne.deleteFirst();
    	  list1Total += (tempAdd.iData * tens_l1); //Multiply by corresponding value
    	  tens_l1 *= 10; //Increment multiplyer variable by 10
      }
      
      //Repeat all processes for for second linked list
      while( !list2.isEmpty() ){
    	  Link temp = list2.deleteFirst();
    	  listTwo.insertFirst(temp.iData);
    	  size_l2++;
      }
      
      for(int i=0; i<size_l2; i++){
    	  Link tempAdd = listTwo.deleteFirst();
    	  list2Total += (tempAdd.iData * tens_l2);
    	  tens_l2 *= 10; 
      }

      //Print results
      System.out.println("List 1 Total: " + list1Total);
      System.out.println("List 2 Total: " + list2Total);
      
      //Return if list1 is less than list2
      return (list1Total < list2Total);
   }
}  // end class LinkListApp
////////////////////////////////////////////////////////////////
