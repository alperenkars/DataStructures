package code;

import java.util.LinkedList;

import code.DirectedWeightedGraph.Edge;
import code.DirectedWeightedGraph.Vertex;

public class UndirectedWeightedGraph<V> extends DirectedWeightedGraph<V> {

  /*
   * YOU CAN ADD ANY FIELDS AND ADDITIONAL METHODS AS YOU LIKE
   * 
   */


	
	
  @Override
  public String toString() {
    String tmp = "Undirected Weighted Graph";
    return tmp;
  }

  @Override
  public void insertVertex(V v) {
   super.insertVertex(v);
    
  }

  @Override
  public V removeVertex(V v) {
   return super.removeVertex(v);
  }

  @Override
  public boolean areAdjacent(V v1, V v2) {
	  Vertex a=findVertex(v1);
		 Vertex b=findVertex(v2);
		 if(!(a==null)&&!(b==null)) {
			 if(a.allNeighbors.contains(b)&&b.allNeighbors.contains(a)) {
				 return true;
			 }
			 return false;
		 }
		 return false;
  }

  @Override
  public void insertEdge(V source, V target) {
	  Vertex a=findVertex(source);
		Vertex b=findVertex(target);
		Edge ed=this.findEdge(a,b);
		if(ed==null) {
	    
		if(a==null) {
			insertVertex(source);
			a=findVertex(source);
		}
		if(b==null) {
			insertVertex(target);
			b=findVertex(target);
		}
		Edge e=new Edge(a, b, 1);
	    edges.add(e);}
    
  }

  @Override
  public void insertEdge(V source, V target, float weight) {
	  Vertex a=findVertex(source);
		Vertex b=findVertex(target);
		Edge edg=this.findEdge(a,b);
		if(edg!=null) {
			edg.weight=weight;
		}
		else {
		if(a==null) {
			insertVertex(source);
			a=findVertex(source);
		}
		if(b==null) {
			insertVertex(target);
			b=findVertex(target);
		}
		
		
	    Edge e=new Edge(a, b, weight);
	    edges.add(e);}
    
  }

  @Override
  public boolean removeEdge(V source, V target) {
	  Vertex a=findVertex(source);
		Vertex b=findVertex(target);

	    Edge e=this.findEdge(a,b);
	    if(e==null) {
	    	return false;
	    }
	    else {
	    	e.remove();
	    	
	        return true;}
	   
  }
  public Edge findEdge(Vertex a,Vertex b) {
		 
	  if(a==null||b==null||findVertex(a.content)==null||findVertex(b.content)==null) {
		  return null;
	  }
	  //CORNERS ARE NOT DESIGNED IN DIRECTED ORDER, CHECK IT OUT IF PROBLEM OCCURS
	  for(Edge e:edges) {
		 if(e.corners.contains(a)&&e.corners.contains(b)) {
			 return e;
		 }
	  }
	  return null;
  }

  @Override
  public float getEdgeWeight(V source, V target) {
    // TODO Auto-generated method stub
	  Vertex a=findVertex(source);
	  Vertex b=findVertex(target);

	    Edge e=this.findEdge(a,b);
	    if(e==null) {
	    	return Float.MAX_VALUE;
	    }
	    return e.weight;
  }

  @Override
  public int numVertices() {
    // TODO Auto-generated method stub
    return vertexes.size();
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
    return false;
  }

  @Override
  public boolean isWeighted() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public int outDegree(V v) {
    // TODO Auto-ge
	  Vertex a=findVertex(v);
	    if(a!=null) {
	    	return a.allEdges.size();
	    }
	    return -1;
  }

  @Override
  public int inDegree(V v) {
    // TODO Auto-generated method stub
    return outDegree(v);
  }

  @Override
  public Iterable<V> outgoingNeighbors(V v) {
	  Vertex a=findVertex(v);
	    if(a!=null) {
	    	LinkedList<V> vert=new LinkedList<V>();
	        for(Vertex vt:a.allNeighbors) {
	        	vert.add(vt.content);
	        }
	        return vert;
	    }
	    return null;
  }

  @Override
  public Iterable<V> incomingNeighbors(V v) {
    // TODO Auto-generated method stub
    return outgoingNeighbors(v);
  }
  
  
}
