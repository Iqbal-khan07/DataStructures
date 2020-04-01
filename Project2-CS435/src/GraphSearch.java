import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Mar 30, 2020.
 */
public class GraphSearch {
	
	public static ArrayList<Node> DFSRec(final Node start, final Node end) {
		ArrayList<Node> path = new ArrayList<>();
		HashSet<Node> visited = new HashSet<>();
		boolean found = DFS(start, end, path, visited);
		if(found) {
			return path;
		}else {
			return null;
		}
		
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
		}else {
			return null;
		}
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
}
