
public class Connected {
	
    private boolean[][] marked;
    private static int max = 0;
    
    private boolean isOutOfBound(int [][]a, int r, int c) {
    	return (r >= 0) && (r < a.length) &&
    		   (c >= 0) && (c < a.length) &&
    		   (!this.marked[r][c]) && (a[r][c] == 1);
    }
    
    private int dfs(int [][]a, int r, int c, int temp) {
    	this.marked[r][c] = true;
    	// check all the neighbours or the adjacency list
    	for(int i = -1; i < 2; i++) {
    		for(int j = -1; j < 2; j++) {
    			if(i == 0 && j == 0) continue;
    			if(this.isOutOfBound(a, r + i, c + j)) {
    				++temp;
    				temp = this.dfs(a, r + i, c + j, temp);
    			}
    		}	
    	}
    	return max > temp? max : temp;
    }
    
    public int totalIslands(int [][]a) {
    	this.marked = new boolean[a.length][a.length];
    	int count = 0, cells = 0, m;
    	for(int i = 0; i < a.length; ++i) {
    		for(int j = 0; j < a.length; ++j) {
    			if(!this.marked[i][j] && a[i][j] == 1) {
    				++count;
    				cells = cells > (m = this.dfs(a, i, j, 1)) ? cells : m;
    			}
    		}
    	}
    	max = cells;
    	return count;
    }
    
    public int maxCells() {
    	return max;
    }
}
