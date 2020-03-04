
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
		long start, finish;
		AVLTreeIter<Integer> AVLtree = new AVLTreeIter<>();
		BinaryTreeRec<Integer> binaryRecTree = new BinaryTreeRec<>();
		BinaryTreeIter<Integer> binaryIterTree = new BinaryTreeIter<>();
		int[] arr1 = Utils.getRandomArray(100000);
		int[] arr = Utils.getSortedArray(10);
		
		start = System.currentTimeMillis();
		for(int num: arr) {
			AVLtree.insertIter(num);			
		}
		
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in AVL");
		System.out.println("Time to insert in AVL: " + (finish - start) + "ms");
		start = System.currentTimeMillis();
		for(int num: arr) {
			binaryRecTree.insertRec(num);
		}
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in BinaryTreeRecursive");
		System.out.println("Time to insert in BinaryTreeRecursive: " + (finish - start) + "ms");
		start = System.currentTimeMillis();
		for(int num: arr) {
			binaryIterTree.insertIter(num);
		}
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in BinaryTreeIter");
		System.out.println("Time to insert in BinaryTreeIter: " + (finish - start) + "ms");
		
		System.out.println("Number of elements in iter: " + Utils.numOfNodes(binaryIterTree.root()));
		System.out.println("Number of elements in rec: " + Utils.numOfNodes(binaryRecTree.root()));
		System.out.println("Number of elements in AVL: " + Utils.numOfNodes(AVLtree.root()));
		
		System.out.println("Number of nodes visited in iter: " + binaryIterTree.visitedNodes() );
		System.out.println("Number of nodes visited in AVL: " + AVLtree.visitedNodes());
		
		System.out.println();
		System.out.println();

		start = System.currentTimeMillis();
		for(int num: arr1) {
			AVLtree.insertIter(num);			
		}
		
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in AVL");
		System.out.println("Time to insert in AVL: " + (finish - start) + "ms");
		start = System.currentTimeMillis();
		for(int num: arr1) {
			binaryRecTree.insertRec(num);
		}
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in BinaryTreeRecursive");
		System.out.println("Time to insert in BinaryTreeRecursive: " + (finish - start) + "ms");
		start = System.currentTimeMillis();
		for(int num: arr1) {
			binaryIterTree.insertIter(num);
		}
		finish = System.currentTimeMillis();
		System.out.println("Done Inserting in BinaryTreeIter");
		System.out.println("Time to insert in BinaryTreeIter: " + (finish - start) + "ms");
		
		System.out.println("Number of elements in iter: " + Utils.numOfNodes(binaryIterTree.root()));
		System.out.println("Number of elements in rec: " + Utils.numOfNodes(binaryRecTree.root()));
		System.out.println("Number of elements in AVL: " + Utils.numOfNodes(AVLtree.root()));
		
		System.out.println("Number of nodes visited in iter: " + binaryIterTree.visitedNodes() );
		System.out.println("Number of nodes visited in AVL: " + AVLtree.visitedNodes());

	}
	
}
