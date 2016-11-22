package diGraph;

import java.util.LinkedList;

public class DiGraph {
	private LinkedList<Integer>[] adj;
    private int V;
    private int E;
    
    public DiGraph(int V) {
    	this.V = V;
    	this.adj = new LinkedList[V];
    	for(int i = 0; i < V; i++) 
    		this.adj[i] = new LinkedList<Integer>();
    	this.E = 0;
    }
     
    public void addEdge(int v, int w) {
    	this.adj[v].add(w);
    	this.E++;
    }
    
    public int V() {
    	return this.V;
    }
    
    public int E() {
    	return this.E;
    }
    
    public Iterable<Integer> adj(int v) {
    	return this.adj[v];
    }
    
    public DiGraph reverse() {
    	DiGraph d = new DiGraph(this.V());
    	for(int i = 0; i < this.V(); i++) {
    		for(Integer w : this.adj(i))
    			d.addEdge(w, i);
    	}
    	return d;
    }
}
