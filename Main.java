
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
//		BinaryTreeRec<Integer> tree = new BinaryTreeRec<>();
//		Integer[] data = {20, 8, 22, 4, 12, 10, 14};
//		for(Integer num: data) {
//			tree.insertRec(num);
//		}
//		System.out.print("Insertions Done\n");
////		tree.removeRec(2);
//		
////		for(Integer num: data) {
////			tree.removeRec(num);
////
////		}
//		
//		System.out.print("Removals Done\n");
//		System.out.println("Max: " + tree.findMaxRec());
//		System.out.println("Min: " + tree.findMinRec());
//		int element = 14;
//		System.out.println("Next: " + tree.findNextRec(element));
//		System.out.println("Prev: " + tree.findPrevRec(element));
		
//		BinaryTreeIter<Integer> tree = new BinaryTreeIter<>();
//		Integer[] data = {20, 8, 22, 4, 12, 10, 14};
//		for(Integer num: data) {
//			tree.insertIter(num);
//		}
//		tree.removeIter(35);
//		System.out.print("Insertions Done\n");
//		for(Integer num: data) {
//			tree.removeIter(num);
//		}
//		System.out.print("Removals Done\n");
//		System.out.println("Max: " + tree.findMaxIter());
//		System.out.println("Min: " + tree.findMinIter());
//		int element = 8;
//		System.out.println("Next: " + tree.findNextIter(element));
//		System.out.println("Prev: " + tree.findPrevIter(element));
		
		int[] arr = Utils.getRandomArray(10);
		int[] arr1 = Utils.getSortedArray(10);
		for(Integer num: arr) {
			System.out.printf("%d ", num);
		}
		System.out.println();
		for(Integer num: arr1) {
			System.out.printf("%d ", num);
		}
		
	}

}
