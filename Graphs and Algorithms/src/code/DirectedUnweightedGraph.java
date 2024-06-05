package code;

import code.DirectedWeightedGraph.Edge;
import code.DirectedWeightedGraph.Vertex;

public class DirectedUnweightedGraph<V> extends DirectedWeightedGraph<V> {
  
  /*
   * YOU CAN ADD ANY FIELDS AND ADDITIONAL METHODS AS YOU LIKE
   * 
   */
  
  @Override
  public String toString() {
    String tmp = "Directed Unweighted Graph";
    return tmp;
  }

  @Override
  public void insertVertex(V v) {
    // TODO Auto-generated method stub
	  super.insertVertex(v);
    
  }

  @Override
  public V removeVertex(V v) {
    // TODO Auto-generated method stub
	  return super.removeVertex(v);
  }

  @Override
  public boolean areAdjacent(V v1, V v2) {
    // TODO Auto-generated method stub
	  return super.areAdjacent(v1,v2);
  }

  @Override
  public void insertEdge(V source, V target) {
    super.insertEdge(source, target);
    
  }

  @Override
  public void insertEdge(V source, V target, float weight) {
   super.insertEdge(source, target, weight);
    
  }

  @Override
  public boolean removeEdge(V source, V target) {
    return super.removeEdge(source, target);
  }

  @Override
  public float getEdgeWeight(V source, V target) {
	  Vertex a=findVertex(source);
	  Vertex b=findVertex(target);

	    Edge e=findEdge(a,b);
	    if(e==null) {
	    	return 0;
	    }
	    return 1;
  }

  @Override
  public int numVertices() {
    // TODO Auto-generated method stub
    return super.numVertices();
  }

  @Override
  public Iterable<V> vertices() {
    // TODO Auto-generated method stub
    return super.vertices();
  }

  @Override
  public int numEdges() {
    // TODO Auto-generated method stub
    return super.numEdges();
  }

  @Override
  public boolean isDirected() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isWeighted() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int outDegree(V v) {
    // TODO Auto-generated method stub
    return super.outDegree(v);
  }

  @Override
  public int inDegree(V v) {
    // TODO Auto-generated method stub
    return super.inDegree(v);
  }

  @Override
  public Iterable<V> outgoingNeighbors(V v) {
    // TODO Auto-generated method stub
    return super.outgoingNeighbors(v);
  }

  @Override
  public Iterable<V> incomingNeighbors(V v) {
    // TODO Auto-generated method stub
    return super.incomingNeighbors(v);
  }
}
