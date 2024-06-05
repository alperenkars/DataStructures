package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import given.iGraph;


import autograder.Util;

/*
 * The class that will hold your graph algorithm implementations
 * Implement:
 * - Depth first search
 * - Breadth first search
 * - Dijkstra's single-source all-destinations shortest path algorithm
 * 
 * Feel free to add any addition methods and fields as you like
 */
public class GraphAlgorithms<V extends Comparable<V>> {
  
  /*
   * YOU CAN ADD ANY FIELDS AND ADDITIONAL METHODS AS YOU LIKE
   * 
   */
  
  public static boolean usageCheck = false;
  
  /*
   * WARNING: MUST USE THIS FUNCTION TO SORT THE 
   * NEIGHBORS (the adjacent call in the pseudocodes)
   * FOR DFS AND BFS
   * 
   * THIS IS DONE TO MAKE AUTOGRADING EASIER
   */
  public Iterable<V> iterableToSortedIterable(Iterable<V> inIterable) {
    usageCheck = true;
    List<V> sorted = new ArrayList<>();
    for (V i : inIterable) {
      sorted.add(i);
    }
    Collections.sort(sorted);
    return sorted;
  }
  
  /*
   * Runs depth first search on the given graph G and
   * returns a list of vertices in the visited order, 
   * starting from the startvertex.
   * 
   */
  public List<V> DFS(iGraph<V> G, V startVertex) {
	 
	List<V> visited = new ArrayList<>();
    usageCheck = false;
    List<V> ret = new ArrayList<>();
    ret.add(startVertex);
    while(!ret.isEmpty()) {
    	V u=ret.get(ret.size()-1);
    	ret.remove(ret.size()-1);
    	if(!visited.contains(u)) {
    		visited.add(u);
    		for(V w:iterableToSortedIterable(G.outgoingNeighbors(u))) {
    			if(!visited.contains(w)) {
    			
    				ret.add(w);
    			}
    		}
    		
    	}
    }
    return visited;
  }
  
  /*
   * Runs Dijkstras single source all-destinations shortest path 
   * algorithm on the given graph G and returns a map of vertices
   * and their associated minimum costs, starting from the startvertex.
   * 
   */
  public HashMap<V,Float> Dijkstras(iGraph<V> G, V startVertex) {	  
	  //distance map to keep final distances  
	  HashMap<V,Float> dist=new HashMap<V,Float>();
	   
	  //adding all vertices to distance
	  for(V vrt:G.vertices()) {
		  dist.put(vrt, Float.MAX_VALUE);		  }
	//replacing startVertex's distance to be 0
	  dist.replace(startVertex, (float) 0);
	  
	  //pq for keeping min distances
	  PriorityQueue<V> pq = new PriorityQueue<V>();
	  pq.add(startVertex);  
	  while(!pq.isEmpty()) {
		//a list to check if a V is visited
		  List<V> visited = new ArrayList<>();
		  V u=pq.remove();
		  if(!visited.contains(u)) {
			  visited.add(u);			  
			  for(V w:G.outgoingNeighbors(u)) {
				  if(!visited.contains(w)&&dist.get(w)>dist.get(u)+G.getEdgeWeight(u, w)) {
					  if(w.toString().equals("E")) {
						//  System.out.println("aaaaaaaaaa"+dist.get(u)+G.getEdgeWeight(u, w));
					  }
					  dist.replace(w, dist.get(u)+G.getEdgeWeight(u, w));
					  pq.add(w);
					  
					  
				  }
			  }
		  }
	  }
	  //to remove uninvolved vertices in directed case
	  List<V> hlp = new ArrayList<>();
	  for(V v:dist.keySet()) {
		  hlp.add(v);
	  }
	  for(V v:hlp) {
		  if(dist.get(v).equals(Float.MAX_VALUE)) {
			  dist.remove(v);		  }
	  }
	  return dist;
  }
	 

  
  
  /*
   *  Returns true if the given graph is cyclic, false otherwise
   */
  public boolean isCyclic(iGraph<V> G) {
	  List<V> L = new ArrayList<>();
	  List<V> S = new ArrayList<>();
	  HashMap<V,Integer> C=new HashMap<V,Integer>();
	  for(V v:G.vertices()) {
		  if(G.inDegree(v)==0) {
			  S.add(v);
		  }
		  C.put(v, G.inDegree(v));
	  }
	  while(!S.isEmpty()) {
		  V t=S.remove(S.size()-1);	  
		  L.add(t);
		  for(V u:G.outgoingNeighbors(t)) {
			  C.replace(u, C.get(u)-1);
			  if(C.get(u)==0) {
				  S.add( u);
			  }
		  }
	  }
	  if(L.size()!=G.numVertices()) {
		  return true;
	  }
	  return false;

   
  }
  
  
  
 

}
