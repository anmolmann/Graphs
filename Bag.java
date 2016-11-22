/*import java.util.Iterator;

public class Bag implements Iterable<Integer>{

	private Node first, last;
	int N;
	
	private static class Node {
		private Node next;
		private int value;
		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	Bag() {
		this.first = null;
	}
	void enqueue(int n) {
		if(first == null) {
			first = new Node(n);
			last = first;
		}
		Node t = new Node(n);
		last.next = t;		
		N++;
	}
	
	@Override
	public Iterator<Integer> iterator() {	// so that the original object state is fixed 
		return new CustomIterator();		// therefore, maintain multiple iterators
	}
	
    private class CustomIterator implements Iterator<Integer> {

    	Node curr = first;
		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public Integer next() {
			Node t = curr;
			curr = curr.next;
			return t.value;
		}
    	
    }
}

class Graph{
	int v;
	Bag[] adj;
	public Graph(int v) {
		this.v = v;
		this.adj = new Bag[v];
		for(int i = 0; i < v; i++) {
			this.adj[i] = new Bag();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].enqueue(w);
		adj[w].enqueue(v);
	}
}
*/