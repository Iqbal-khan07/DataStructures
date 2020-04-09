import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Arrays;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Mar 30, 2020.
 */
public class Main {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 */


	public static void main(String[] args) {
//		Graph g = createRandomUnweightedGraphIter(10);
//		System.out.print(g);

				
		
		/////// Diakstra ////////
		
//		WeightedGraph g = new WeightedGraph();
//		String[] nums = {"A","B","C","D","E","F","G"};
////						{ 0 , 1 , 2 , 3 , 4 , 5 , 6}
//	
//	
//		for(String str: nums) {
//			g.addNode(str);
//		
//		}
//		
//		HashSet<Node> set = g.getAllNodes();
//		Node[] nodes = new Node[set.size()];
//		nodes = g.getAllNodes().toArray(nodes);
//		Arrays.sort(nodes);
//		
//		g.addWeightedEdge(nodes[0], nodes[1], 2);
//		g.addWeightedEdge(nodes[0], nodes[2], 4);
//		g.addWeightedEdge(nodes[0], nodes[5], 5);
//		g.addWeightedEdge(nodes[0], nodes[3], 7);
//		
//		g.addWeightedEdge(nodes[1], nodes[0], 2);
//		g.addWeightedEdge(nodes[1], nodes[3], 6);
//		g.addWeightedEdge(nodes[1], nodes[4], 3);
//		g.addWeightedEdge(nodes[1], nodes[6], 8);
//		
//		g.addWeightedEdge(nodes[2], nodes[0], 4);
//		g.addWeightedEdge(nodes[2], nodes[5], 6);
//		
//		g.addWeightedEdge(nodes[3], nodes[0], 7);
//		g.addWeightedEdge(nodes[3], nodes[1], 6);
//		g.addWeightedEdge(nodes[3], nodes[5], 10);
//		g.addWeightedEdge(nodes[3], nodes[6], 6);
//		
//		g.addWeightedEdge(nodes[4], nodes[1], 3);
//		g.addWeightedEdge(nodes[4], nodes[6], 7);
//		
//		g.addWeightedEdge(nodes[5], nodes[2], 6);
//		g.addWeightedEdge(nodes[5], nodes[3], 10);
//		g.addWeightedEdge(nodes[5], nodes[0], 5);
//		g.addWeightedEdge(nodes[5], nodes[6], 6);
//		
//		g.addWeightedEdge(nodes[6], nodes[1], 8);
//		g.addWeightedEdge(nodes[6], nodes[3], 6);
//		g.addWeightedEdge(nodes[6], nodes[4], 7);
//		g.addWeightedEdge(nodes[6], nodes[5], 6);
//		
//		System.out.print("Phew");
//		
//		HashMap<Node, Integer> map = Main.dijkstras(nodes[0]);
//		
		////////////////// Breadth First Traversal and Depth First Search //////////////// 
		
//		UndirectedGraph g = new UndirectedGraph();
//		String[] nums = { 0 , 1 , 2 , 3 , 4 , 5 , 6, 7, 8, 9, 10};
//						
//		Node[] nodes = new Node[nums.length];
//		Node node;
//		int i=0;
//		for(String str: nums) {
//			g.addNode(node = new Node(str));
//			nodes[i++] = node;
//		}
//		
//		g.addUndirectedEdge(nodes[0], nodes[2]);
//		g.addUndirectedEdge(nodes[1], nodes[2]);
//		g.addUndirectedEdge(nodes[2], nodes[3]);
//		g.addUndirectedEdge(nodes[2], nodes[4]);
//		g.addUndirectedEdge(nodes[3], nodes[4]);
//		g.addUndirectedEdge(nodes[4], nodes[5]);
//		g.addUndirectedEdge(nodes[5], nodes[6]);
//		g.addUndirectedEdge(nodes[6], nodes[7]);
//		g.addUndirectedEdge(nodes[7], nodes[8]);
//		g.addUndirectedEdge(nodes[8], nodes[9]);
		
//		ArrayList<Node> path = GraphSearch.DFSIter(g, nodes[0], nodes[9]);
//		System.out.println(path);
//		ArrayList<Node> path1 = GraphSearch.DFSRec(g, nodes[0], nodes[9]);
//		System.out.println(path1);
//		
//		ArrayList<Node> path2 = GraphSearch.BFTIter(g);
//		System.out.println(path2);
//		ArrayList<Node> path3 = GraphSearch.BFTRec(g);
//		System.out.println(path3);

//		Graph linkedList = Main.createLinkedList(10000);
//		ArrayList<Node> list = Main.BFTIterLinkedList(linkedList);
//		ArrayList<Node> list1 = Main.BFTRecLinkedList(g);
//		System.out.println(list);
		
		
		////////////   A* Algoritm ////////////
//		GridGraph g = createRandomGridGraph(100);
		
//		GridGraph g = new GridGraph();
//		String[] nums = {"A","B","C","D","E","F","G"};
////						{ 0 , 1 , 2 , 3 , 4 , 5 , 6}
//		
//		for(String str: nums) {
//			g.addGridNode(0, 0, str);
//		}
//		
//		HashSet<GridNode> set = g.getAllNodes();
//		GridNode[] nodes = new GridNode[set.size()];
//		nodes = g.getAllNodes().toArray(nodes);
//		Arrays.sort(nodes);
//		
//		
//		g.addWeightedEdge(nodes[0], nodes[1], 2);
//		g.addWeightedEdge(nodes[0], nodes[2], 4);
//		g.addWeightedEdge(nodes[0], nodes[5], 5);
//		g.addWeightedEdge(nodes[0], nodes[3], 7);
//		
//		g.addWeightedEdge(nodes[1], nodes[0], 2);
//		g.addWeightedEdge(nodes[1], nodes[3], 6);
//		g.addWeightedEdge(nodes[1], nodes[4], 3);
//		g.addWeightedEdge(nodes[1], nodes[6], 8);
//		
//		g.addWeightedEdge(nodes[2], nodes[0], 4);
//		g.addWeightedEdge(nodes[2], nodes[5], 6);
//		
//		g.addWeightedEdge(nodes[3], nodes[0], 7);
//		g.addWeightedEdge(nodes[3], nodes[1], 6);
//		g.addWeightedEdge(nodes[3], nodes[5], 10);
//		g.addWeightedEdge(nodes[3], nodes[6], 6);
//		
//		g.addWeightedEdge(nodes[4], nodes[1], 3);
//		g.addWeightedEdge(nodes[4], nodes[6], 7);
//		
//		g.addWeightedEdge(nodes[5], nodes[2], 6);
//		g.addWeightedEdge(nodes[5], nodes[3], 10);
//		g.addWeightedEdge(nodes[5], nodes[0], 5);
//		g.addWeightedEdge(nodes[5], nodes[6], 6);
//		
//		g.addWeightedEdge(nodes[6], nodes[1], 8);
//		g.addWeightedEdge(nodes[6], nodes[3], 6);
//		g.addWeightedEdge(nodes[6], nodes[4], 7);
//		g.addWeightedEdge(nodes[6], nodes[5], 6);
//		
//		ArrayList<GridNode> out = Main.astar(nodes[0], nodes[6]);
//		
//		GridGraph g = createRandomGridGraph(3);
//		HashSet<GridNode> set = g.getAllNodes();
//		GridNode[] nodes = new GridNode[set.size()];
//		nodes = g.getAllNodes().toArray(nodes);
//		Arrays.sort(nodes);
//		ArrayList<GridNode> out = Main.astar(nodes[0], nodes[nodes.length-1]);
//		System.out.print("Phew");
//		
		
		/// TOPOSORT /////
		
		DirectedGraph g = new DirectedGraph();
		String[] nums = {"A","B","C","D","E", "F", "G"};
////						{ 0 , 1 , 2 , 3 , 4}
		
		for(String str: nums) {
			g.addNode(str);
		}
		
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		// A DAG Graph
		g.addDirectedEdge(nodes[0], nodes[1]);
		g.addDirectedEdge(nodes[0], nodes[2]);
		g.addDirectedEdge(nodes[0], nodes[5]);
		
		g.addDirectedEdge(nodes[1], nodes[4]);
		g.addDirectedEdge(nodes[1], nodes[3]);
		
		g.addDirectedEdge(nodes[2], nodes[3]);
		g.addDirectedEdge(nodes[2], nodes[5]);
		
		g.addDirectedEdge(nodes[3], nodes[6]);
		g.addDirectedEdge(nodes[3], nodes[4]);

		g.addDirectedEdge(nodes[6], nodes[5]);
		

		DirectedGraph g1 = Main.createRandomDAGIter(10000);
		ArrayList<Node> output = TopoSort.Kahns(g1);
		ArrayList<Node> output1 = TopoSort.mDFS(g1);
		
		
	}
	
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
	
	public static void addNeighbourEdgeWIthProbablity(GridGraph g, int index, int size, GridNode[] nodes, int direction) {
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
	
	public static ArrayList<GridNode> astar(final GridNode sourceNode, final GridNode destNode){
		PriorityQueue<Set<GridNode, Integer>> min_queue = new PriorityQueue<Set<GridNode, Integer>>();
		HashMap<GridNode, Integer> distances = new HashMap<>();
		HashSet<GridNode> exausted = new HashSet<>();
		
		distances.put(sourceNode, 0);
		GridNode curr = sourceNode;
		while(!curr.equals(destNode)) {
			List<GridNode> neighbours = curr.getEdges();
			for(GridNode neighbour: neighbours) {
				if(!exausted.contains(neighbour)) {
					int distancetoNeighbour = distances.get(curr) + curr.getEdgeWeight(neighbour);
					if(distances.get(neighbour) == null || distances.get(neighbour) > distancetoNeighbour) {
						distances.put(neighbour, distancetoNeighbour);
						min_queue.add(new Set<GridNode, Integer>(neighbour, distancetoNeighbour+heuristic(neighbour, destNode)));
						neighbour.setParent(curr);
					}	
				}
			}
			exausted.add(curr);
			Set<GridNode, Integer> s = min_queue.poll();
			if(s!=null) {
				curr = s.getNode();
			}else {
				curr = null;
			}
		}
		
		ArrayList<GridNode> path = new ArrayList<>();
		curr = destNode;
		while(curr.getParent() != null) {
			path.add(0, curr);
			curr = curr.getParent();
		}
		path.add(0, curr);
		
		return path;
	}
	
	public static int heuristic(final GridNode node, final GridNode target) {
		return (target.x - node.x) + (target.y - node.y);
//		HashMap<String, Integer> val = new HashMap<String, Integer>();
//		String[] s = {"A", "B", "C", "D", "E", "F", "G"};
//		int[] v = {10, 5, 10, 6, 5, 2, 0};
//		for(int i=0; i< s.length; i++) {
//			val.put(s[i], v[i]);
//		}
//		return val.get(node.value);
	}
	
	public static HashMap<Node, Integer> dijkstras(final Node start){
		PriorityQueue<Set<Node, Integer>> min_queue = new PriorityQueue<Set<Node, Integer>>();
		HashMap<Node, Integer> distances = new HashMap<>();
		HashSet<Node> exausted = new HashSet<>();
		
		distances.put(start, 0);
		Node curr = start;
		while(curr != null && distances.containsKey(curr)) {
			List<Node> neighbours = curr.getEdges();
			for(Node neighbour: neighbours) {
				if(!exausted.contains(neighbour)) {
					int distancetoNeighbour = distances.get(curr) + curr.getEdgeWeight(neighbour);
					if(distances.get(neighbour) == null || distances.get(neighbour) > distancetoNeighbour) {
						distances.put(neighbour, distancetoNeighbour);
						min_queue.add(new Set<Node, Integer>(neighbour, distancetoNeighbour));
						neighbour.setParent(curr);
					}	
				}
			}
			exausted.add(curr);
			Set<Node, Integer> s = min_queue.poll();
			if(s!=null) {
				curr = s.getNode();
			}else {
				curr = null;
			}
		}
		return distances;
	}
	
	public static ArrayList<Node> BFTRecLinkedList(final Graph graph){
		return GraphSearch.BFTRec(graph);
	}
	
	public static ArrayList<Node> BFTIterLinkedList(final Graph graph){
		return GraphSearch.BFTIter(graph);
	}
}
