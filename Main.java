import java.awt.List;
import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Feb 19, 2020.
 */
public class Main {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
//		Main.timeInvestigation(10000);
		AVLTreeIter<Integer> AVLtree = new AVLTreeIter<>();
		
		int[] arr1 = {5, 7, 6, 2, 1, 5, 8, 14};
		
		for(int num: arr1) {
			AVLtree.insertIter(num);			
		}
		AVLtree.removeIter(5);
		
		System.out.print("Done");
		
		
		


	}
	
	public static void timeInvestigation(int n) {
		long start, finish;
		AVLTreeIter<Integer> AVLtree = new AVLTreeIter<>();
		
		System.out.println("INSERTING RANDOM ELEMENTS");
		
		int[] arr1 = Utils.getRandomArray(n);
		
		start = System.currentTimeMillis();
		for(int num: arr1) {
			AVLtree.insertIter(num);			
		}
		
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in AVL");
		System.out.println("Time to insert in AVL: " + (finish - start) + "ms");
		
		BinaryTreeIter<Integer> binaryIterTree = new BinaryTreeIter<>();
		
		start = System.currentTimeMillis();
		for(int num: arr1) {
			binaryIterTree.insertIter(num);
		}
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in BinaryTreeIter");
		System.out.println("Time to insert in BinaryTreeIter: " + (finish - start) + "ms");
		
		System.out.println("Number of nodes visited in iter: " + binaryIterTree.visitedNodes() );
		System.out.println("Number of nodes visited in AVL: " + AVLtree.visitedNodes());
		////////////////////////////////////////////////////////////////////////////////////
		 
		AVLTreeIter<Integer> AVLtree1 = new AVLTreeIter<>();
		
		System.out.println("INSERTING SORTED ELEMENTS");
		
		int[] arr2 = Utils.getSortedArray(n);
		
		start = System.currentTimeMillis();
		for(int num: arr1) {
			AVLtree1.insertIter(num);			
		}
		
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in AVL");
		System.out.println("Time to insert in AVL: " + (finish - start) + "ms");
		
		BinaryTreeIter<Integer> binaryIterTree1 = new BinaryTreeIter<>();
		
		start = System.currentTimeMillis();
		for(int num: arr2) {
			binaryIterTree1.insertIter(num);
		}
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in BinaryTreeIter");
		System.out.println("Time to insert in BinaryTreeIter: " + (finish - start) + "ms");
		
		System.out.println("Number of nodes visited in iter: " + binaryIterTree1.visitedNodes() );
		System.out.println("Number of nodes visited in AVL: " + AVLtree1.visitedNodes());
	}
	
}
