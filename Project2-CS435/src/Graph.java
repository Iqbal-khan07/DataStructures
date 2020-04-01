import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
	
/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Mar 30, 2020.
 */
public class Graph {
	private List<Node> vertices;
	private Node head = null;
	
	public Graph() {
		vertices = new ArrayList<>();
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public void addNode(final Node n) {
		if(head == null) {
			head = n;
		}
		vertices.add(n);
	}
	
	public void addUndirectedEdge(final Node first, final Node second) {
		addDirectedEdge(first, second);
		addDirectedEdge(second, first);
	}
	
	public void removeUndirectedEdge(final Node first, final Node second) {
		removeDirectedEdge(first, second);
		removeDirectedEdge(second, first);
	}
	
	public void addDirectedEdge(final Node from, final Node to) {
		from.addEdge(to);
	}
	
	public void removeDirectedEdge(final Node from, final Node to) {
		from.removeEdge(to);
	}
	
	public HashSet<Node> getAllNodes(){
		HashSet<Node> nodes = new HashSet<>();
		nodes.addAll(this.vertices);
		return nodes;
	}
	

}
