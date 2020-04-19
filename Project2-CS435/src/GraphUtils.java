import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Apr 19, 2020.
 */
public class GraphUtils {
	public static Graph createRandomUnweightedGraphIter(int n) {
		UndirectedGraph g = new UndirectedGraph();
		
		Random rand = new Random();

		for(int i=0; i<n; i++) {
			g.addNode(i);
		}
		
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		int randIndex1, randIndex2;
		int maxVertices = n * (n - 1);
		for(int i=0; i < maxVertices; i++) {
			randIndex1 = rand.nextInt(n);
			randIndex2 = rand.nextInt(n);
			g.addUndirectedEdge(nodes[randIndex1], nodes[randIndex2]);
		}
		
		for(int i=0; i < maxVertices/4; i++) {
			randIndex1 = rand.nextInt(n);
			randIndex2 = rand.nextInt(n);
			g.removeUndirectedEdge(nodes[randIndex1], nodes[randIndex2]);
		}
		return g;
	}
	
	public static Graph createLinkedList(int n) {
		DirectedGraph g = new DirectedGraph();
		
		for(int i=0; i<n; i++) {
			g.addNode(i);
		}
		
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		for(int i=0, j=1; j < n; i++, j++) {
			g.addDirectedEdge(nodes[i], nodes[j]);
		}
		
		return g;
	}
	
	public static Graph createRandomCompleteWeightedGraph(final int n) {
		WeightedGraph g = new WeightedGraph();
		Random rand = new Random(1);
		
		for(int i=0; i<n; i++) {			
			g.addNode(i);
		}
		
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		for(Node node: nodes) {
			for(int i=0; i<n; i++) {
				if(node != nodes[i]) {
					int randWeight = rand.nextInt(100);
					g.addWeightedEdge(node, nodes[i], randWeight);
				}
			}
		}
		
		return g;
	}
	
	public Graph createWeightedLinkedList(final int n) {
		WeightedGraph g = new WeightedGraph();
		Random rand = new Random(1);
		
		for(int i=0; i<n; i++) {
			g.addNode(i);
		}
		
		
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		
		for(int i=0, j=1; j < n; i++, j++) {
			int randWeight = rand.nextInt(100);
			g.addWeightedEdge(nodes[i], nodes[j], randWeight);
		}
		
		return g;
	}
	
	public static DirectedGraph createRandomDAGIter(final int n) {
		DirectedGraph g = new DirectedGraph();
		Random rand = new Random(1);
		
		for(int i=0; i<n; i++) {			
			g.addNode(i);
		}
		
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		int gridSize = (int)Math.sqrt(n);
		
		for(int r=0; r < gridSize; r++) {
			for(int c=0; c < gridSize; c++) {
				Node curr = nodes[r * gridSize + c];
				
				if(rand.nextInt(100) > 40){
					// right
					int rightIndex = r * gridSize + c + 1;
					if(rightIndex < n) {
						g.addDirectedEdge(curr, nodes[rightIndex]);
					}
				}
				if(rand.nextInt(100) > 40){
					// forward
					int forwardIndex = (r+1) * gridSize + c;
					if(forwardIndex < n) {
						g.addDirectedEdge(curr, nodes[forwardIndex]);
					}
				}
			}
		}
		
		return g;
	}
	
	public static GridGraph createRandomGridGraph(int n) {
		GridGraph g = new GridGraph();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				g.addGridNode(j, i, i*n + j);
			}
		}
		
		HashSet<GridNode> set = g.getAllNodes();
		GridNode[] nodes = new GridNode[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		for(int i=0; i < n*n; i++) {
			addNeighbourEdgeWIthProbablity(g, i, n, nodes, 1);
			addNeighbourEdgeWIthProbablity(g, i, n, nodes, -1);
			addNeighbourEdgeWIthProbablity(g, i, n, nodes, n);
			addNeighbourEdgeWIthProbablity(g, i, n, nodes, -n);
		}
		return g;
	}
	
	private static void addNeighbourEdgeWIthProbablity(GridGraph g, int index, int size, GridNode[] nodes, int direction) {
		GridNode cell = nodes[index];
		Random rand = new Random();
		
		if(index+direction >= 0 && index+direction < size*size - 1) {
			if(rand.nextInt(100) > 50) {
				GridNode neighbour = nodes[index+direction];
				if(!cell.getEdges().contains(neighbour)){
					g.addUndirectedEdge(cell, neighbour);
				}
			}
		}
	}


}
