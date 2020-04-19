import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Arrays;


public class Main {



	public static void main(String[] args) {

		/////// Diakstra ////////
		
		WeightedGraph g = Main.testWeightedGraph();
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		HashMap<Node, Integer> map = GraphSearch.dijkstras(nodes[0]);
		
		////////////////// Breadth First Traversal and Depth First Search //////////////// 
		
		UndirectedGraph g1 = Main.testUndirectedGraph();
		HashSet<Node> set1 = g.getAllNodes();
		Node[] nodes1 = new Node[set1.size()];
		nodes1 = g.getAllNodes().toArray(nodes1);
		Arrays.sort(nodes1);
		
		ArrayList<Node> path = GraphSearch.DFSIter(nodes1[0], nodes1[9]);
		System.out.println(path);
		ArrayList<Node> path1 = GraphSearch.DFSRec(nodes1[0], nodes1[9]);
		System.out.println(path1);
	
		ArrayList<Node> path2 = GraphSearch.BFTIter(g1);
		System.out.println(path2);
		ArrayList<Node> path3 = GraphSearch.BFTRec(g1);
		System.out.println(path3);

		Graph linkedList = GraphUtils.createLinkedList(10000);
		ArrayList<Node> list = Main.BFTIterLinkedList(linkedList);
		ArrayList<Node> list1 = Main.BFTRecLinkedList(g1);
		System.out.println(list);
		System.out.println(list1);
		
		////////////   A* Algoritm ////////////

		// The implementation there and it works and very thing
		
		
		/// TOPOSORT /////

		DirectedGraph g2 = Main.testDAGGaph();
		
		HashSet<Node> set2 = g2.getAllNodes();
		Node[] nodes2 = new Node[set2.size()];
		nodes2 = g.getAllNodes().toArray(nodes2);
		Arrays.sort(nodes2);
	

//		DirectedGraph g1 = Main.createRandomDAGIter(10000);
		ArrayList<Node> output = TopoSort.Kahns(g2);
		ArrayList<Node> output1 = TopoSort.mDFS(g2);
		
		System.out.println(output);
		System.out.println(output1);
		
		
	}
	
	public static DirectedGraph testDAGGaph() {
		DirectedGraph g = new DirectedGraph();
		String[] nums = {"A","B","C","D","E", "F", "G"};
		
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
		
		return g;
		
	}
	
	public static UndirectedGraph testUndirectedGraph() {
		UndirectedGraph g = new UndirectedGraph();
		String[] nums = { "0" , "1" , "2" , "3" , "4" , "5" , "6", "7", "8", "9", "10"};
						
		for(String str: nums) {
			g.addNode(str);
		}
		
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		g.addUndirectedEdge(nodes[0], nodes[2]);
		g.addUndirectedEdge(nodes[1], nodes[2]);
		g.addUndirectedEdge(nodes[2], nodes[3]);
		g.addUndirectedEdge(nodes[2], nodes[4]);
		g.addUndirectedEdge(nodes[3], nodes[4]);
		g.addUndirectedEdge(nodes[4], nodes[5]);
		g.addUndirectedEdge(nodes[5], nodes[6]);
		g.addUndirectedEdge(nodes[6], nodes[7]);
		g.addUndirectedEdge(nodes[7], nodes[8]);
		g.addUndirectedEdge(nodes[8], nodes[9]);
		
		return g;
	}
	
	public static WeightedGraph testWeightedGraph() {
		WeightedGraph g = new WeightedGraph();
		String[] nums = {"A","B","C","D","E","F","G"};
	
		for(String str: nums) {
			g.addNode(str);
		
		}
		
		HashSet<Node> set = g.getAllNodes();
		Node[] nodes = new Node[set.size()];
		nodes = g.getAllNodes().toArray(nodes);
		Arrays.sort(nodes);
		
		g.addWeightedEdge(nodes[0], nodes[1], 2);
		g.addWeightedEdge(nodes[0], nodes[2], 4);
		g.addWeightedEdge(nodes[0], nodes[5], 5);
		g.addWeightedEdge(nodes[0], nodes[3], 7);
		
		g.addWeightedEdge(nodes[1], nodes[0], 2);
		g.addWeightedEdge(nodes[1], nodes[3], 6);
		g.addWeightedEdge(nodes[1], nodes[4], 3);
		g.addWeightedEdge(nodes[1], nodes[6], 8);
		
		g.addWeightedEdge(nodes[2], nodes[0], 4);
		g.addWeightedEdge(nodes[2], nodes[5], 6);
		
		g.addWeightedEdge(nodes[3], nodes[0], 7);
		g.addWeightedEdge(nodes[3], nodes[1], 6);
		g.addWeightedEdge(nodes[3], nodes[5], 10);
		g.addWeightedEdge(nodes[3], nodes[6], 6);
		
		g.addWeightedEdge(nodes[4], nodes[1], 3);
		g.addWeightedEdge(nodes[4], nodes[6], 7);
		
		g.addWeightedEdge(nodes[5], nodes[2], 6);
		g.addWeightedEdge(nodes[5], nodes[3], 10);
		g.addWeightedEdge(nodes[5], nodes[0], 5);
		g.addWeightedEdge(nodes[5], nodes[6], 6);
		
		g.addWeightedEdge(nodes[6], nodes[1], 8);
		g.addWeightedEdge(nodes[6], nodes[3], 6);
		g.addWeightedEdge(nodes[6], nodes[4], 7);
		g.addWeightedEdge(nodes[6], nodes[5], 6);

		return g;
		
	}
	
	public static ArrayList<Node> BFTRecLinkedList(final Graph graph){
		return GraphSearch.BFTRec(graph);
	}
	
	public static ArrayList<Node> BFTIterLinkedList(final Graph graph){
		return GraphSearch.BFTIter(graph);
	}
}
