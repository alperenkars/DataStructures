package code;
import java.util.LinkedList;

import given.iGraph;

public class DirectedWeightedGraph<V> implements iGraph<V>  {

  /*
   * YOU CAN ADD ANY FIELDS AND ADDITIONAL METHODS AS YOU LIKE
   * 
   */
	public LinkedList<Vertex> vertexes;
	public LinkedList<Edge> edges;
  
	
	public DirectedWeightedGraph(){
		this.vertexes=new LinkedList<Vertex>();
		this.edges=new LinkedList<Edge>();
		
	}
  @Override
  public String toString() {
    String tmp = "Directed Weighted Graph";
    return tmp;
  }

  // Adds a vertex to the graph, with no edges
  @Override
  public void insertVertex(V v) {
    // TODO Auto-generated method stub
	Vertex vert=findVertex(v);
	if(vert==null) {
    Vertex a=new Vertex(v);
    vertexes.add(a);}
  }
  
  public Vertex findVertex(V v) {
	  for(Vertex a:vertexes) {
		  if(a.content.equals(v)) {
			  return a;
		  }
	  }
	  return null;
  }
  public Edge findEdge(Vertex a,Vertex b) {
	 
	  if(a==null||b==null||findVertex(a.content)==null||findVertex(b.content)==null) {
		  return null;
	  }
	  //CORNERS ARE NOT DESIGNED IN DIRECTED ORDER, CHECK IT OUT IF PROBLEM OCCURS
	  for(Edge e:edges) {
		 if(e.source.equals(a)&&e.target.equals(b)) {
			 return e;
		 }
	  }
	  return null;
  }

  /*
   * Removes a vertex from the graph. If the vertex is not in the graph, return null.
   * Otherwise, return the removed vertex. Make sure to remove all edges connecting to the vertex too.
  */
  @Override
  public V removeVertex(V v) { 
	 Vertex a=findVertex(v);
	 
     if(a!=null) {
    	 	LinkedList<Edge> edgs=new LinkedList<Edge>();
    	//	System.out.printf("\nCHAR: %s, NUMEDGES: %d",v,a.allEdges.size());
    		for(Edge e:a.allEdges) {
    		edgs.add(e);
    		
    }
    		for(Edge e:edgs) {
    			e.remove();
    		}
    		//System.out.printf("\n 2 CHAR: %s, NUMEDGES: %d",v,a.allEdges.size());
    		
    		vertexes.remove(a);
    		return v;}
  
    return null;
  }

  /*
   * Return true if there is an edge connecting v1 to v2 (directed edge)
   */
  @Override
  public boolean areAdjacent(V v1, V v2) {
    // TODO Auto-generated method stub
	 Vertex a=findVertex(v1);
	 Vertex b=findVertex(v2);
	 if(!(a==null)&&!(b==null)) {
		 if(a.outNeighbors.contains(b)&&b.inNeighbors.contains(a)) {
			 return true;
		 }
		 return false;
	 }
	 return false;
  
  }

  /*
   * Insert a (directed) edge connecting the source vertex to the target vertex. Use 1 for the weight of the edge
   */
  @Override
  public void insertEdge(V source, V target) {
    // TODO Auto-generated method stub
	Vertex a=findVertex(source);
	Vertex b=findVertex(target);
	Edge ed=findEdge(a,b);
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

  /*
   * Insert a (directed) edge connecting the source vertex to the target vertex, with the given weight
   */
  @Override
  public void insertEdge(V source, V target, float weight) {
	  
    // TODO Auto-generated method stub
	  Vertex a=findVertex(source);
		Vertex b=findVertex(target);
		Edge edg=findEdge(a,b);
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

  /*
   * Remove the (directed) edge between source and target
   */
  @Override
  public boolean removeEdge(V source, V target) {
    // TODO Auto-generated method stub
	Vertex a=findVertex(source);
	Vertex b=findVertex(target);

    Edge e=findEdge(a,b);
    if(e==null) {
    	return false;
    }
    if(e.source.equals(a)&&e.target.equals(b)) {
    	e.remove();
    	
        return true;
    }
    return false;
  }

  /*
   * Get the weight of the (directed) edge from source to target
   */
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

  /*
   * return the number of vertices in the graph
   */
  @Override
  public int numVertices() {
   return vertexes.size();
   
  }

  /*
   * Return an iterable of all the vertices in the graph
   */
  @Override
  public Iterable<V> vertices() {
    // TODO Auto-generated method stub
	LinkedList<V> vert=new LinkedList<V>();
    for(Vertex a:vertexes) {
    	vert.add(a.content);
    }
    return vert;
  }

  /*
   * Return the number of edges in the graph
   */
  @Override
  public int numEdges() {
    
    return edges.size();
  }

  @Override
  public boolean isDirected() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isWeighted() {
    // TODO Auto-generated method stub
    return true;
  }

  /*
   * Return the number of edges leading out of the vertex v
   */
  @Override
  public int outDegree(V v) {
    Vertex a=findVertex(v);
    if(a!=null) {
    	return a.outEdges.size();
    }
    return -1;
  }

  /*
   * Return the number of edges entering the vertex v
   */
  @Override
  public int inDegree(V v) {
	  Vertex a=findVertex(v);
	    if(a!=null) {
	    	return a.inEdges.size();
	    }
	    return -1;
  }

  /*
   * Return an iterable of all outgoing neighbors of the vertex v
   */
  @Override
  public Iterable<V> outgoingNeighbors(V v) {
	  Vertex a=findVertex(v);
	    if(a!=null) {
	    	LinkedList<V> vert=new LinkedList<V>();
	        for(Vertex vt:a.outNeighbors) {
	        	vert.add(vt.content);
	        }
	        return vert;
	    }
	    return null;
  }

  /*
   * Return an iterable of all incoming neighbors of the vertex v
   */
  @Override
  public Iterable<V> incomingNeighbors(V v) {
	  Vertex a=findVertex(v);
	    if(a!=null) {
	    	LinkedList<V> vert=new LinkedList<V>();
	        for(Vertex vt:a.inNeighbors) {
	        	vert.add(vt.content);
	        }
	        return vert;
	    }
	    return null;
  }
  
  public class Vertex{
	  public LinkedList<Vertex> allNeighbors;
	  public LinkedList<Vertex> inNeighbors;
	  public LinkedList<Vertex> outNeighbors;
	  public LinkedList<Edge> allEdges;
	  public LinkedList<Edge> inEdges;
	  public LinkedList<Edge> outEdges;
	  public V content;
	  public Vertex(V v) {
		  this.content=v;
		  this.allNeighbors=new LinkedList<Vertex>();
		  this.inNeighbors=new LinkedList<Vertex>();
		  this.outNeighbors=new LinkedList<Vertex>();
		  this.allEdges=new LinkedList<Edge>();
		  this.inEdges=new LinkedList<Edge>();
		  this.outEdges=new LinkedList<Edge>();
	  }
	  
  }
  
  public class Edge{
	  public LinkedList<Vertex> corners;
	  public float weight;
	  public Vertex source;
	  public Vertex target;
	  
	  public Edge(Vertex a, Vertex b, float weight) {
		  this.corners= new LinkedList<Vertex>();
		  this.weight=weight;
		  //CORNERS ARE NOT DESIGNED IN DIRECTED ORDER, CHECK IT OUT IF PROBLEM OCCURS
		  if(!corners.contains(b)) {
			  this.corners.add(b);
		  }
		  if(!corners.contains(a)) {
			  this.corners.add(a);
		  }
		  
		  this.source=a;
		  this.target=b;
		  
		  if(!a.allEdges.contains(this)) {
			  a.allEdges.add(this);
		  }
		  if(!a.outEdges.contains(this)) {
			  a.outEdges.add(this);
		  }
		 
		  if(!a.outNeighbors.contains(b)) {
			  a.outNeighbors.add(b);
		  }
		  if(!a.allNeighbors.contains(b)) {
			  a.allNeighbors.add(b);
		  }
		  if(!b.allEdges.contains(this)) {
			  b.allEdges.add(this);
		  }
		  if(!b.inEdges.contains(this)) {
			  b.inEdges.add(this);
		  }
		  if(!b.inNeighbors.contains(a)) {
			  b.inNeighbors.add(a);
		  }
		  if(!b.allNeighbors.contains(a)) {
			  b.allNeighbors.add(a);
		  }
		
		  
	  }
	  public void remove() {
		 
			  
			 
			  source.outEdges.remove(this);
			  source.allEdges.remove(this);
			  source.allNeighbors.remove(target);
			  source.outNeighbors.remove(target);
			  target.inEdges.remove(this);
			  target.allEdges.remove(this);
			  target.allNeighbors.remove(source);
			  target.inNeighbors.remove(source);
			  edges.remove(this);
		  
		  
	
	  }
	 
	  
  }
}
