import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class GridGraph{
	private List<GridNode> vertices;
	
	public GridGraph() {
		vertices = new ArrayList<>();
	}
	
	public void addGridNode(final int x, final int y, final String nodeVal) {
		vertices.add(new GridNode(x, y, nodeVal));
	}
	
	public void addGridNode(final int x, final int y, final int nodeVal) {
		vertices.add(new GridNode(x, y, Integer.toString(nodeVal)));
	}
	
	public void addUndirectedEdge(final GridNode first, final GridNode second) {
		if((Math.abs(first.x - second.x) == 1 && Math.abs(first.y - second.y) == 0) || (Math.abs(first.y - second.y) == 1 && Math.abs(first.x - second.x) == 0)) {
			first.addEdge(second);
			second.addEdge(first);
		}
	}
	
	public void addWeightedEdge(final GridNode first, final GridNode second, int weight) {
		if((Math.abs(first.x - second.x) == 1 && Math.abs(first.y - second.y) == 0) || (Math.abs(first.y - second.y) == 1 && Math.abs(first.x - second.x) == 0)) {
			first.addEdge(second, weight);
		}
	}
	
	public void removeUndirectedEdge(final GridNode first, final GridNode second) {
		List<GridNode> fNeighbours = first.getEdges();
		if(fNeighbours.contains(second)) {
			first.removeEdge(second);
			second.removeEdge(first);
		}	
	}
	
	public HashSet<GridNode> getAllNodes(){
		HashSet<GridNode> nodes = new HashSet<>();
		nodes.addAll(this.vertices);
		return nodes;
	}

}
