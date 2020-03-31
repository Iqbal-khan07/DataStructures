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
	
	public static ArrayList<Node> DFSRec(final Graph g, final Node start, final Node end) {
		ArrayList<Node> path = new ArrayList<>();
		HashSet<Node> visited = new HashSet<>();
		boolean found = DFS(start, end, path, visited, g);
		if(found) {
			return path;
		}else {
			return null;
		}
		
	}
	
	
	
	private static boolean DFS(final Node curr, final Node end, final ArrayList<Node> path, final HashSet<Node> visited, final Graph g) {
		visited.add(curr);
		path.add(curr);
		if(curr == end) {
			return true;
		}
		for(Node n: g.getNeighbours(curr)) {
			if(!visited.contains(n)) {
				return DFS(n, end, path, visited, g);
			}
		}
		return false;
	}
	
	public static ArrayList<Node> DFSIter(final Graph g, final Node start, final Node end) {
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
				
				for(Node n: g.getNeighbours(curr)) {
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
		Queue<Node> queue = new LinkedList<Node>();
		ArrayList<Node> path = new ArrayList<>();
		HashSet<Node> visited = new HashSet<>();
		queue.add(g.getHead());
		Node curr;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			if(!visited.contains(curr)) {
				visited.add(curr);
				path.add(curr);
				
				for(Node n: g.getNeighbours(curr)) {
					queue.add(n);
				}		
			}
		}
		return path;
	}
	
	public static ArrayList<Node> BFTRec(final Graph g) {
		ArrayList<Node> path = new ArrayList<>();
		HashSet<Node> visited = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(g.getHead());
		BFT(path, queue, visited, g);	
		
		return path;
	
	}
	
	private static void BFT(final ArrayList<Node> path, final Queue<Node> queue, final HashSet<Node> visited, final Graph g) {
		if(!queue.isEmpty()) {
			Node curr = queue.poll();
				
			if(!visited.contains(curr)) {
				for(Node neigh: g.getNeighbours(curr)) {
					queue.add(neigh);
				}
				
				visited.add(curr);
				path.add(curr);
	    	}
			BFT(path, queue, visited, g);
		}
	}
}
