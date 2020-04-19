import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;


public class GraphSearch {
	
	public static ArrayList<Node> DFSRec(final Node start, final Node end) {
		ArrayList<Node> path = new ArrayList<>();
		HashSet<Node> visited = new HashSet<>();
		boolean found = DFS(start, end, path, visited);
		if(found) {
			return path;
		}
		return null;
	}
	
	private static boolean DFS(final Node curr, final Node end, final ArrayList<Node> path, final HashSet<Node> visited) {
		visited.add(curr);
		path.add(curr);
		if(curr == end) {
			return true;
		}
		for(Node n: curr.getEdges()) {
			if(!visited.contains(n)) {
				return DFS(n, end, path, visited);
			}
		}
		return false;
	}
	
	public static ArrayList<Node> DFSIter(final Node start, final Node end) {
		Stack<Node> stack = new Stack<>();
		ArrayList<Node> path = new ArrayList<>();
		HashSet<Node> visited = new HashSet<>();
		boolean found = false;
		stack.push(start);
		Node curr;
		while(!stack.empty()) {
			curr = stack.pop();
			
			if(!visited.contains(curr)) {
				visited.add(curr);
				path.add(curr);
				if(curr == end) {
					found = true;
					break;
				}
				for(Node n: curr.getEdges()) {
					stack.push(n);
				}		
			}
		}
		
		if(found) {
			return path;
		}
		return null;
	}
	
	public static ArrayList<Node> BFTIter(final Graph g) {
		
		ArrayList<Node> path = new ArrayList<>();
		HashSet<Node> visited = new HashSet<>();
		HashSet<Node> vertices = g.getAllNodes();
		
		for(Node n: vertices) {
			if(!visited.contains(n)) {
				GraphSearch.BFTIter(n, visited, path);
			}
		}
		
		return path;
	}
	
	public static void BFTIter(final Node start, HashSet<Node> visited, ArrayList<Node> path){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(start);
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(!visited.contains(curr)) {
				visited.add(curr);
				path.add(curr);
				
				for(Node n: curr.getEdges()) {
					queue.add(n);
				}		
			}
		}
	}
	
	public static ArrayList<Node> BFTRec(final Graph g) {
		ArrayList<Node> path = new ArrayList<>();
		HashSet<Node> visited = new HashSet<>();
		HashSet<Node> vertices = g.getAllNodes();
		
		for(Node n: vertices) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(n);
			BFT(path, queue, visited);	
		}			
		return path;
	}
	
	private static void BFT(final ArrayList<Node> path, final Queue<Node> queue, final HashSet<Node> visited) {
		if(!queue.isEmpty()) {
			Node curr = queue.poll();
				
			if(!visited.contains(curr)) {
				for(Node neigh: curr.getEdges()) {
					queue.add(neigh);
				}
				
				visited.add(curr);
				path.add(curr);
	    	}
			BFT(path, queue, visited);
		}
	}
	
	public static ArrayList<GridNode> astar(final GridNode sourceNode, final GridNode destNode){
		PriorityQueue<Set<GridNode, Integer>> min_queue = new PriorityQueue<Set<GridNode, Integer>>();
		HashMap<GridNode, Integer> distances = new HashMap<>();
		HashSet<GridNode> exausted = new HashSet<>();
		
		distances.put(sourceNode, 0);
		min_queue.add(new Set<GridNode, Integer>(sourceNode, heuristic(sourceNode, destNode)));
		GridNode curr = sourceNode;
		while(curr != null && !curr.equals(destNode)) {
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
			while(s != null && exausted.contains(s.getNode())) {
				s = min_queue.poll();
			}
			
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
		if(!path.isEmpty()) {
			path.add(0, curr);
		}
		
		return path;
	}
	
	private static int heuristic(final GridNode node, final GridNode target) {
		return Math.abs(target.x - node.x) + Math.abs(target.y - node.y);
		
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
			while(s != null && exausted.contains(s.getNode())) {
				s = min_queue.poll();
			}
			
			if(s!=null) {
				curr = s.getNode();
			}else {
				curr = null;
			}
		}
		return distances;
	}
}
