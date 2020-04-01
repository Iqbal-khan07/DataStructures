import java.util.List;
import java.util.ArrayList;
/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Mar 30, 2020.
 */
public class Node {
	private int value;
	private List<Node> edges;
	
	public Node(int n) {
		this.edges = new ArrayList<>();
		this.value = n;
	}
	
	public void addEdge(final Node node) {
		edges.add(node);
	}
	
	public void removeEdge(final Node node) {
		edges.remove(node);
	}
	
	public List<Node> getEdges(){
		return this.edges;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}

}
