import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Feb 25, 2020.
 */
public class Sorts {
	public static <T extends Comparable<? super T>> ArrayList<T> sort(ArrayList<T> input){
		BinaryTreeRec<T> tree = new BinaryTreeRec<>();
		for(T num: input) {
			// The recurssive implementation of tree has the method to sort
			tree.insertRec(num);
		}
		return tree.sort();
	}
}
