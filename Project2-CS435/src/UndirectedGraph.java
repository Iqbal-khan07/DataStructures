
/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Mar 30, 2020.
 */
public class UndirectedGraph extends Graph{
	
	public UndirectedGraph() {
		super();
	}
	
	public void addUndirectedEdge(final Node first, final Node second) {
		addDirectedEdge(first, second);
		addDirectedEdge(second, first);
	}
	
	public void removeUndirectedEdge(final Node first, final Node second) {
		removeDirectedEdge(first, second);
		removeDirectedEdge(second, first);
	}
	
	private void addDirectedEdge(final Node from, final Node to) {
		from.addEdge(to);
	}
	
	private void removeDirectedEdge(final Node from, final Node to) {
		from.removeEdge(to);
	}

}
