import java.util.Stack;
import diGraph.*;
public class TopologicalSort {
	boolean []marked;
	
	public Stack<Integer> order(DiGraph g) {
    	this.marked = new boolean[g.V()];
    	Stack<Integer> s = new Stack<Integer>();
    	for(int i = 0; i < g.V(); i++) {
    		if(!this.marked[i]) order(g, i, s);
    	}
    	return s;
    }
    
    private void order(DiGraph g, int v, Stack<Integer> s) {
    	this.marked[v] = true;
    	for(Integer w : g.adj(v)) {
    		if(!this.marked[w]) order(g, w, s);
    	}
    	s.push(v);
    }
}
