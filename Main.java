
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
		
		AVLTreeIter<Integer> AVLtree = new AVLTreeIter<>();
		BinaryTreeRec<Integer> binaryRecTree = new BinaryTreeRec<>();
		BinaryTreeIter<Integer> binaryIterTree = new BinaryTreeIter<>();
		int[] arr = Utils.getRandomArray(10);
		long start = System.currentTimeMillis();
		for(int num: arr) {
//			System.out.println("Inserting: " + num);
			AVLtree.insertIter(num);			
		}
		
		long finish = System.currentTimeMillis();
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
 	}
}
