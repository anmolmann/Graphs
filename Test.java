import java.util.Scanner;
import java.util.Stack;

import diGraph.*;
public class Test {
    public static void main(String args[]) {
 
    	Graph g = new Graph(8);
    	g.addEdge(1, 4);
    	g.addEdge(1, 3);
    	g.addEdge(3, 5);
    	g.addEdge(4, 5);
    	g.addEdge(0, 2);
    	g.addEdge(6, 5);  // put this line afterwards and the path between 6 and 5 will become 6 4 1 3 5
    	g.addEdge(4, 6);
    	g.addEdge(6, 6);
    	g.addEdge(6, 7);
    	g.addEdge(3, 7);

    	
    	// WHETHER A SELF LOOP EXISTS IN A GRAPH OR NOT
    	System.out.println("Has self loop? " + g.hasSelfLoop());
    	
    	// DEGREE OF A VERTEX
    	System.out.println("Degree : " + g.degree(5));
    	
    	// MAX DEGREE IN THE GRAPH
    	System.out.println("Max degree : " + g.maxDegree());
    	
    	// WHETHER A PATH EXISTS BETWEEN TWO VERTICES OR NOT (implemented using depth first search algorithm)
    	DFS d = new DFS(g, 6);
    	System.out.println("\nDoes Path exist between vertex 6 and 2? " + d.hasPathTo(2));
    	
    	// PATH BETWEEN TWO VERTICES
    	System.out.print("\nPATH between vertex 6 and 5 : ");
    	d.path(5);
    	
    	//SHORTEST PATH
    	BFS b = new BFS(g, 1);
    	System.out.println("\nhas path to : " + b.hasPathTo(6));
    	System.out.print("\nSHORTEST PATH between vertex 1 and 7 : ");
    	b.shortestPath(1, 7);
    	
    	
    	Graph g3 = new Graph(5);
    	g3.addEdge(0, 1);
    	g3.addEdge(1, 2);
    	g3.addEdge(0, 3);
    	g3.addEdge(2, 3);
    	g3.addEdge(2, 4);
    	g3.addEdge(0, 2);
    	
    	
    	// CYCLE IN A GRAPH OR whether the given structure is a tree or not
    	Cycle is_tree = new Cycle();
    	System.out.println("\n\nisTree ? :- " + is_tree.isTree(g3));
    	
    	
    	// isBipartite 
    	Bipartite bipartite = new Bipartite();
    	System.out.println("\nisBipartite ? " + bipartite.isBipartite(g3));
    	
    	
    	//TOPOLOGICAL SORT
    	
    	TopologicalSort topology = new TopologicalSort();
    	DiGraph g2 = new DiGraph(8);
    	g2.addEdge(1, 3);
    	g2.addEdge(2, 1);
    	g2.addEdge(3, 2);
    	g2.addEdge(3, 4);
    	g2.addEdge(4, 5);
    	g2.addEdge(5, 6);
    	g2.addEdge(6, 4);
    	g2.addEdge(7, 0);
    	g2.addEdge(0, 7);
    	g2.addEdge(7, 4);
    	System.out.print("\nTOPOLICAL SORT : ");
    	Stack<Integer> s = topology.order(g2);
    	while(!s.isEmpty()) System.out.print(s.pop() + " ");
    	
    	// STRONGLY CONNECTED COMPONENTS
    	SCC scc = new SCC();
    	s = topology.order(g2.reverse());
    	System.out.println("\n\nNo of Strongly connected components : " + scc.components(g2, s));
    	
    	// CONNECTED GRAPH / GRID
    	
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int [][]a = new int[N][N];
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++)
    			a[i][j] = sc.nextInt();
    	sc.close();
    	Connected c = new Connected();
    	System.out.println("Total islands : " + c.totalIslands(a));
    	
    	// MAX CELLS IN A CONNECTED GRID
    	System.out.println("Max cells in an island : " + c.maxCells());
    	
    }
}
