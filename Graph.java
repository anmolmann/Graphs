import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;
    
    public Graph(int V) {
    	this.V = V;
    	this.adj = new LinkedList[V];
    	for(int i = 0; i < V; i++) 
    		this.adj[i] = new LinkedList<Integer>();
    	this.E = 0;
    }
     
    public void addEdge(int v, int w) {
    	this.adj[v].add(w);
    	this.adj[w].add(v);
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
    
    public boolean hasSelfLoop() {
    	for(int i = 0; i < this.V(); i++) {
    		for(int w: this.adj(i)) {
    			if(i == w) return true;
    		}
    	}
    	return false;
    }
    
    public int degree(int v) {
    	int deg = 0;
    	// or for(Integer i: this.adj(v)) deg++;
    	for (Iterator<Integer> iterator = this.adj(v).iterator(); iterator.hasNext();) {
			iterator.next();
			deg++;
		}
    	return deg;
    }
    
    public int maxDegree() {
    	int max = 0;
    	for(int v = 0; v < this.V(); v++) {
    		int deg = 0;
    		for(Integer i: this.adj(v))
    			deg++;
    		max = max > deg? max : deg;
    	}
    	return max;
    }
}
