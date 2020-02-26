
/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Feb 19, 2020.
 */
public class Node <T extends Comparable<? super T>> {
	T data;
	Node<T> left;
	Node<T> right;
	
	public Node(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
