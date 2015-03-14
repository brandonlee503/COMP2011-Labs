import java.util.Random;

public class sortCompApp{

	public static void main(String[] args){
		executionTime(100);
		executionTime(1000);
		executionTime(10000);
	}
	
	public static void executionTime(int size){
		
		//Create objects for each type of search
		ArrayBub bubObj = new ArrayBub(size);
		ArrayIns insObj = new ArrayIns(size);
		ArraySel selObj = new ArraySel(size);
		
		//Fill each array object with randomized integers
		for(int i=0; i<size; i++){
			Random rn = new Random();
			int randomNum = rn.nextInt(size);
			bubObj.insert(randomNum);
			insObj.insert(randomNum);
			selObj.insert(randomNum);
		}
		
		//Measure time for each sort
		long bubStart = System.nanoTime();
		bubObj.bubbleSort();
		long bubEnd = System.nanoTime();
		
		long insStart = System.nanoTime();
		insObj.insertionSort();
		long insEnd = System.nanoTime();
				
		long selStart = System.nanoTime();
		selObj.selectionSort();
		long selEnd = System.nanoTime();
		
		//Print out results
		System.out.println("Tested Array Size = " + size);
		System.out.println("\t   Bubble Sort - " + "The execution time is " + (bubEnd - bubStart) + " nanoseconds!");
		System.out.println("\tInsertion Sort - " + "The execution time is " + (insEnd - insStart) + " nanoseconds!");
		System.out.println("\tSelection Sort - " + "The execution time is " + (selEnd - selStart) + " nanoseconds!");
	}
}