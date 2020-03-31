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
	private HashMap<Node, HashSet<Node>> ajjList;
	private Node head = null;
	
	public Graph() {
		ajjList = new HashMap<>();
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public void addNode(final Node n) {
		if(head == null) {
			head = n;
		}
		ajjList.putIfAbsent(n, new HashSet<Node>());
	}
	
	public HashSet<Node> getNeighbours(final Node n){
		return ajjList.get(n);
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
		ajjList.get(from).add(to);
	}
	
	public void removeDirectedEdge(final Node from, final Node to) {
		ajjList.get(from).remove(to);
	}
	
	public HashSet<Node> getAllNodes(){
		return (HashSet<Node>) this.ajjList.keySet();
	}
	

}
