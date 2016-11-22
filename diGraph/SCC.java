package diGraph;
import java.util.*;

public class SCC {
	boolean []marked;
	public void SCC(){}
	
	public int components(DiGraph g, Stack<Integer> s) {
		int count = 0;
		this.marked = new boolean[g.V()];
		while(!s.isEmpty()) {
			int temp = s.pop();
			if(!this.marked[temp]) {
				components_dfs(g, temp);
				count++;
			}
		}
		return count;
	}
	
	private void components_dfs(DiGraph g, int v) {
		this.marked[v] = true;
		for(Integer w : g.adj(v)) 
			if(!this.marked[w])
				components_dfs(g, w);
	}
}
