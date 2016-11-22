import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	private int[] edgeTo;
    private boolean []marked;	// by default all the values are false
    
    public BFS(Graph G, int s) {
    	this.marked = new boolean[G.V()];
    	this.edgeTo = new int[G.V()];
    	for(int i = 0; i < G.V(); i++)
    		this.edgeTo[i] = Integer.MAX_VALUE;	// initialise edgeTo[] to infinity first;
    	bfs(G, s);
    }
    
    private void bfs(Graph G, int v) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(v);
    	while(!q.isEmpty()) {
    		int w = q.poll();
    		this.marked[w] = true;
    		for(Integer i: G.adj(w)) {
    			if(!this.marked[i]) {
    				this.marked[i] = true;
    				this.edgeTo[i] = w;
    				q.add(i);
    			}
    		}
    	}
    }
    
    public boolean hasPathTo(int w) {
    	return this.marked[w];
    }    
    
    public void shortestPath(int f, int e) {
    	if(!marked[f] || !marked[e]) { 
    		System.out.println("Not connected");
    		return;
    	}
    	Stack<Integer> s = new Stack<Integer>();
    	while(e != f) {
    		s.push(e);
    		e = this.edgeTo[e];
    	}
    	s.push(f);
    	while(!s.isEmpty()) System.out.print(s.pop() + " ");
    }
}
