import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
/** 
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Mar 30, 2020.
 */
public class Node implements Comparable<Node> {
	private String value;
	Node parent;
	private List<Node> edges;
	private HashMap<Node, Integer> weights;
	
	public Node(String n) {
		this.edges = new ArrayList<>();
		this.value = n;
	}
	
	public void setParent(Node n) {
		this.parent = n;
	}
	
	public void addEdge(final Node node, int weight) {
		if(weights == null) {
			weights = new HashMap<>();
		}
		edges.add(node);
		weights.put(node, weight);
	}
	
	
	public void addEdge(final Node node) {
		edges.add(node);
	}
	
	public int getEdgeWeight(final Node node) {
		if(edges.contains(node)) {
			if(weights.containsKey(node)) {
				return weights.get(node);
			}else {
				return 1;
			}
		}
		return -1;
	}
	
	public void removeEdge(final Node node) {
		edges.remove(node);
	}
	
	public List<Node> getEdges(){
		return this.edges;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public int compareTo(Node n) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		if(pattern.matcher(this.value).matches()) {
			return Integer.parseInt(this.value) - Integer.parseInt(n.value);
		}
		return this.value.compareTo(n.value);	
	}

}
