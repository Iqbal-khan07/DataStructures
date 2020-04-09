import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Apr 8, 2020.
 */
public class TopoSort {
	
	public static ArrayList<Node> Kahns(final DirectedGraph graph){
		ArrayList<Node> ordering = new ArrayList<>();
		HashMap<Node, Integer> inDegree = new HashMap<>();
		for(Node n: graph.getAllNodes()) {
			inDegree.put(n, 0);
		}
		
		for(Node n: graph.getAllNodes()) {
			for(Node neighbour: n.getEdges()) {
				int currCount = inDegree.get(neighbour);
				inDegree.put(neighbour, ++currCount);
			}
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		for(Node n: inDegree.keySet()) {
			if(inDegree.get(n) == 0) {
				queue.add(n);
			}
		}
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			ordering.add(curr);
			for(Node neighbour: curr.getEdges()) {
				int currCount = inDegree.getOrDefault(neighbour, 0);
				inDegree.put(neighbour, --currCount);
			}
			
			for(Node n: curr.getEdges()) {
				if(inDegree.get(n) == 0) {
					queue.add(n);
				}
			}
		}
		return ordering;
	}

	public static ArrayList<Node> mDFS(final DirectedGraph graph){
		Stack<Node> stack = new Stack<>();
		HashSet<Node> visited = new HashSet<>();
		
		for(Node n: graph.getAllNodes()) {
			dfs(n, visited, stack);
		}
	
		ArrayList<Node> output = new ArrayList<>();
		while(!stack.empty()) {
			output.add(stack.pop());
		}
		
		return output;
	}
	
	private static void dfs(Node curr, HashSet<Node> visited, Stack<Node> outputStack) {
		
		for(Node neighbour: curr.getEdges()) {
			if(!visited.contains(neighbour)) {
				dfs(neighbour, visited, outputStack);
			}
		}
		visited.add(curr);
		outputStack.add(curr);
					
	} 
	
}
