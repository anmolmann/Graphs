
public class Cycle {
	boolean []marked;
    public boolean isTree(Graph g) {
    	this.marked = new boolean[g.V()];
    	for(int i = 0; i < g.V(); i++) {
    		if(!this.marked[i])
    			if(isTree(g, i, -1)) return true;
    	}
    	return false;
    }
    
    private boolean isTree(Graph g, int v, int p) {
    	this.marked[v] = true;
    	for(Integer w : g.adj(v)) {
    		if(!this.marked[w]) {
    			if(isTree(g, w, v)) return true;
    		}
    		else {
    			if(w != p) return true;
    		}
    	}
    	return false;
    }
}
