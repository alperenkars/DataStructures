package code;

import java.util.Random;

import given.AbstractArraySort;

/*
 * Implement the quick-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class QuickSort<K extends Comparable<K>> extends AbstractArraySort<K> {
  // Add any fields here

  public QuickSort() {
    name = "Quicksort";

    // Initialize anything else here
  }

  // useful if we want to return a pair of indices from the partition function.
  // You do not need to use this if you are just returning and integer from the
  // partition
  public class indexPair {
    public int p1, p2;

    indexPair(int pos1, int pos2) {
      p1 = pos1;
      p2 = pos2;
    }

    public String toString() {
      return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
    }
  }

  @Override
  public void sort(K[] inputArray) {
    // TODO:: Implement the quicksort algorithm here [ascending order]

    // Suggestion:
    // Implement the helper method quickSort() below and just call it once here.
	  quickSort(inputArray,0,inputArray.length-1);

  }

  // Public since we are going to check its output!
  public indexPair partition(K[] inputArray, int lo, int hi, int p) {
    // TODO:: Implement a partitioning function here
	  swap(inputArray, p, hi);
	  int u=lo;
	  int g=hi-1;
	  while(u<=g) {
		  while(u<=g&&!(compare(inputArray[u],inputArray[hi])>0)) {
			  u+=1;
		  }
		  while(u<=g&&(compare(inputArray[g],inputArray[hi])>0)) {
			  g-=1;
		  }
		  if(u<=g) {
			  swap(inputArray,u,g);
			  u+=1;
			  g-=1;
		  }
		  
	  }
	  swap(inputArray,u,hi);
	  indexPair ret=new indexPair(u-1,u+1);
    return ret;
  }

  /*
   * Alternative, if you are just returning an integer
   * public int partition(K[] inputArray, int lo, int hi, int p)
   * {
   * //TODO:: Implement a partitioning function here
   * return null;
   * }
   */

  // The below methods are given given as suggestion. You do not need to use them.
  // Feel free to add more methods
  protected int pickPivot(K[] inpuArray, int lo, int hi) {
    // TODO: Pick a pivot selection method and implement it
	  Random rand= new Random();
      int pivot = rand.nextInt(hi-lo)+lo;
      
    return pivot;
  }

  protected void quickSort(K[] inputArray, int lo, int hi) {
    // TODO: Implement the quicksort here with it's recursive logic and
    // just call it once in the sort() function.
	  if(lo<hi) {
		  int p=pickPivot(inputArray, lo, hi);
		  indexPair index=partition(inputArray, lo, hi, p);
		  quickSort(inputArray, lo, index.p1);
		  quickSort(inputArray, index.p2, hi);
	  }

  }

}
