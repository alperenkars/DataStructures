package code;

import java.util.Arrays;

import given.AbstractArraySort;

/*
 * Implement the counting-sort algorithm here. You can look at the slides for the pseudo-codes.
 * You do not have to use swap or compare from the AbstractArraySort here
 * 
 * You may need to cast any K to Integer
 * 
 */

public class CountingSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  // Add any fields here

  public CountingSort() {
    name = "Countingsort";
  }

  @Override
  public void sort(K[] inputArray) {

    if (inputArray == null) {
      System.out.println("Null array");
      return;
    }
    if (inputArray.length < 1) {
      System.out.println("Empty array");
      return;
    }

    if (!(inputArray[0] instanceof Integer)) {
      System.out.println("Can only sort integers!");
      return;
    }

    // TODO:: Implement the counting-sort algorithm here [ascending order]
   
    K minKey=minimum(inputArray);
	  
    K maxKey=maximum(inputArray);

    
    int k=(int) maxKey-(int) minKey+1;
    int[] counts=new int[k];
    K[] clon=inputArray.clone();
   
 
    for(int i=0;i<clon.length;i++) {
    	counts[(int) clon[i]-(int) minKey]++;
    }
    
    for(int i=1;i<k;i++) {
    	counts[i]=counts[i]+counts[i-1];
    }
    for(int i=clon.length-1;i>=0;i--) {
    
    
    	K temp= clon[i];
    	inputArray[counts[(int) temp- (int) minKey]-1]=temp;
    	counts[(int) temp- (int) minKey]--;
    }
    
    
    
    
  }
  
 
  public K maximum(K[] arr)
  {
      int i;
       
    
      K max = arr[0];
       
    
      for (i = 1; i < arr.length; i++) {
          if (compare(arr[i], max)>0) {
              max = arr[i];}}
       
      return max;
  }
  
  public K minimum(K[] arr)
  {
      int i;
       
      
      K min = arr[0];
       
  
      for (i = 1; i < arr.length; i++) {
          if (compare(arr[i], min)<0) {
              min = arr[i];}}
       
      return min;
  }

}
