package code;

import given.AbstractArraySort;

import java.util.Arrays;

import code.InsertionSort;

/*
 * Implement the tim-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 * 
 */

public class TimSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  // Add any fields here

  static int MIN_MERGE = 32;

  public TimSort() {
    name = "Timsort";

    // Initialize anything else here
  }

  @Override
  public void sort(K[] inputArray) {
    // TODO: Implement the tim-sort algorithm [ascending order]


	    for (int i = 0; i < inputArray.length; i+=MIN_MERGE)  
	        insertionSort(inputArray, i, Math.min((i+MIN_MERGE-1), (inputArray.length-1)));   
	  
	    for (int size = MIN_MERGE; size < inputArray.length; size = 2*size)  
	    {  
	        for (int beg = 0; beg < inputArray.length; beg += 2*size)  
	        {  
	           
	            int mid = beg + size -1;  
	            int end = Math.min((beg + 2*size - 1),(inputArray.length-1));  
	  
	            
	            if(mid < end)  
	            	//System.out.printf("\n mid end %d %d",mid,end);
	                merge(inputArray, beg, mid, end);  
	        }  
	    }  
   
    // Suggested implementation [See the pdf for more details]]:
    // 1. Sort individual subarrays of size MIN_MERGE (using insertion sort)
    // 2.1 Start merging from size MIN_MERGE (using merge function)
    // 2.2 Double the size on each iteration

	 
  }


  // Public since we are going to check its output!
  public void merge(K[] inputArray, int lo, int mid, int hi) {
    // TODO: Implement the merging algorithm. Same as the 'merge' of Merge Sort.
	  K[] clon=inputArray.clone();
	  mid+=1;
	  hi+=1;
	  int dm=mid;
	  
	  int dl=lo;
	  while(lo<mid&&hi>dm) {
	  if(compare(clon[lo],clon[dm])<0) {
		  
		  inputArray[dl]=clon[lo];
		  lo+=1;
	  }
	  else {
		
		  inputArray[dl]=clon[dm];
		 
		  dm+=1;
		  
	  }
	  dl+=1;
	  }
	  while(lo<mid) {
		  inputArray[dl]=clon[lo];
		  lo+=1;
		  dl+=1;
	  }
	  while(hi>dm) {
		  inputArray[dl]=clon[dm];
		  dm+=1;
		  dl+=1;
	  }
	  
  }

  // It's just the insertion sort we know but with the lo and hi parameters as an
  // extra. (Recommended for the implementation)

  // TODO: Implement the insertion sort algorithm. You can use your implementation
  // from InsertionSort.java.
  protected void insertionSort(K[] inputArray, int lo, int hi) {
	  for (int i = lo+1; i <= hi; i++)
      {
		  int j=i;
		  while(j>lo&&compare(inputArray[j-1],inputArray[j])>0) {
			  swap(inputArray,j,j-1);
			  j-=1;
		  }
        
      }
  }

  // Feel free to add more methods


}
