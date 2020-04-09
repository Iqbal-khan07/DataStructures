
/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Apr 6, 2020.
 */
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
