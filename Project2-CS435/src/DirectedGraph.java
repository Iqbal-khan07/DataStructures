

public class DirectedGraph extends Graph{
	public DirectedGraph() {
		super();
	}
	
	public void addDirectedEdge(final Node first, final Node second) {
		first.addEdge(second);
	}
	
	public void removeDirectedEdge(final Node first, final Node second) {
		first.removeEdge(second);
	}	
	
}
