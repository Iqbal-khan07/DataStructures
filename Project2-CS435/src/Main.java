import java.util.ArrayList;
import java.util.Random;

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
		
		Graph g = new Graph();
		int[] nums = {0, 1, 2 , 3, 4, 5, 6, 7, 8, 9};
		Node[] nodes = new Node[10];
		Node node;
		int i=0;
		for(int num: nums) {
			g.addNode(node = new Node(num));
			nodes[i++] = node;
		}
		
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
		
		ArrayList<Node> path = GraphSearch.DFSIter(g, nodes[0], nodes[9]);
		System.out.println(path);
		ArrayList<Node> path1 = GraphSearch.DFSRec(g, nodes[0], nodes[9]);
		System.out.println(path1);
		
		ArrayList<Node> path2 = GraphSearch.BFTIter(g);
		System.out.println(path2);
		ArrayList<Node> path3 = GraphSearch.BFTRec(g);
		System.out.println(path3);

		Graph linkedList = Main.createLinkedList(1000);
		ArrayList<Node> list = Main.BFTIterLinkedList(linkedList);
		ArrayList<Node> list1 = Main.BFTRecLinkedList(linkedList);
		System.out.println(list);
		
	}
	
	public static Graph createRandomUnweightedGraphIter(int n) {
		Graph g = new Graph();
		
		Random rand = new Random();
		Node[] nodes = new Node[n];
		Node node;
		
		for(int i=0; i<n; i++) {
			g.addNode(node = new Node(i));
			nodes[i] = node;
		}
		
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
		Graph g = new Graph();
		Node[] nodes = new Node[n];
		Node node;
		
		for(int i=-1, j=0; j < n; i++, j++) {
			g.addNode(node = new Node(j));
			nodes[j] = node;
			if(j>0) {
				g.addDirectedEdge(nodes[i], nodes[j]);
			}
		}
		
		return g;
	}
	
	public static ArrayList<Node> BFTRecLinkedList(final Graph graph){
		return GraphSearch.BFTRec(graph);
	}
	
	public static ArrayList<Node> BFTIterLinkedList(final Graph graph){
		return GraphSearch.BFTIter(graph);
	}
}
