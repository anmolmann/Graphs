// complexity -> number of edges
import java.util.Stack;

public class DFS {
	private int[] edgeTo;
    private boolean []marked;	// by default all the values are false
    
    DFS() {}
    
    public DFS(Graph G, int s) {
    	this.marked = new boolean[G.V()];
    	this.edgeTo = new int[G.V()];
    	for(int i = 0; i < G.V(); i++)
    		this.edgeTo[i] = Integer.MAX_VALUE;	// initialise edgeTo[] to infinity first;
    	this.edgeTo[s] = 0;
    	dfs(G, s);
    }
    
    private void dfs(Graph G, int v) {
    	marked[v] = true;
    	
    	for(Integer w : G.adj(v)) {
    		if(!marked[w]) {
    			this.edgeTo[w] = v;
    			dfs(G, w);
    		}
    	}
    }
    
    public boolean hasPathTo(int w) {
    	return this.marked[w];
    }
    
    public void path(int w) {
    	if(!this.marked[w]) {
    		System.out.print("Path does not exist");
    		return;
    	}
    	Stack<Integer> s = new Stack<Integer>();
    	while(w != 0) {
    		s.push(w);
    		w = this.edgeTo[w];
    	}
    	
    	while(!s.isEmpty())
    		System.out.print(s.pop() + " ");
    }
}
