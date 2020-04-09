import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Apr 6, 2020.
 */
public abstract class Graph {
	protected List<Node> vertices;
	
	public Graph() {
		vertices = new ArrayList<>();
	}
	
	public void addNode(String nodeVal) {
		vertices.add(new Node(nodeVal));
	}
	
	public void addNode(int nodeVal) {
		vertices.add(new Node(Integer.toString(nodeVal)));
	}
	
	public HashSet<Node> getAllNodes(){
		HashSet<Node> nodes = new HashSet<>();
		nodes.addAll(this.vertices);
		return nodes;
	}	
}
