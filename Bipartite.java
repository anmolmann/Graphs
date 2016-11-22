// assume adjacent nodes to be distinctly colored red and black respectively
public class Bipartite {
	boolean RED = true;
	boolean []marked;
	boolean color;
	boolean []colors;
	
	public boolean isBipartite(Graph g) {
		
		this.marked = new boolean[g.V()];
		this.colors = new boolean[g.V()];
		
		this.colors[0] = RED;
		
		if(!isBipartite(g, 0)) return false;
		
		for(int i = 0; i < g.V(); i++) {
			if(!this.marked[i]) return false;
		}
		
		return true;
	}
	
	private boolean isBipartite(Graph g, int v) {
		this.marked[v] = true;
		for(Integer w: g.adj(v)) {
			if(!this.marked[w]) {
				this.colors[w] = !this.colors[v];
				isBipartite(g, w);
			}
			else {
				if(this.colors[w] == this.colors[v]) return false;
			}
		}
		return true;
	}
}
