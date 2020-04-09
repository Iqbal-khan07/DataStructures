import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Apr 7, 2020.
 */
public class GridNode implements Comparable<GridNode>{
	int x, y;
	String value;
	private GridNode parent = null;
	private List<GridNode> edges;
	private HashMap<GridNode, Integer> weights;
	
	public GridNode(final int x, final int y, String nodeVal) {
		this.x = x;
		this.y = y;
		this.value = nodeVal;
		this.edges = new ArrayList<>();
	}
	
	public void setParent(final GridNode n) {
		this.parent = n;
	}
	
	public int getEdgeWeight(final GridNode node) {
		if(edges.contains(node)) {
			if(weights.containsKey(node)) {
				return weights.get(node);
			}else {
				return 1;
			}
		}
		return -1;
	}
	
	public GridNode getParent() {
		return this.parent;
	}
	
	public void addEdge(final GridNode node) {
		if(weights == null) {
			weights = new HashMap<>();
		}
		edges.add(node);
		weights.put(node, 0);
	}
	
	public void addEdge(final GridNode node, final int weight) {
		if(weights == null) {
			weights = new HashMap<>();
		}
		edges.add(node);
		weights.put(node, weight);
	}
	
	public void removeEdge(final GridNode node) {
		edges.remove(node);
	}
	
	public List<GridNode> getEdges(){
		return this.edges;
	}
	
	@Override
	public String toString() {
		return this.value + "=>"+ "(" + this.x +","+ this.y+")";
	}
	
	@Override
	public int compareTo(GridNode n) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		if(pattern.matcher(this.value).matches()) {
			return Integer.parseInt(this.value) - Integer.parseInt(n.value);
		}
		return this.value.compareTo(n.value);
		 		
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) { 
            return true; 
        } 
 
        if (!(o instanceof GridNode)) { 
            return false; 
        } 
        
        GridNode n = (GridNode) o;
        
		return (n.x == this.x) && (n.y == this.y);
//        return n.value == this.value;
	}
	

	
}
