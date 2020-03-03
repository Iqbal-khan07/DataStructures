import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Feb 19, 2020.
 */
public class BinaryTreeRec <T extends Comparable<? super T>>{
	private Node<T> root;
	
	public void insertRec(T data) {
		insert(data, root);
	}

	private void insert(T data, Node<T> curr) {
		if(root == null) {
			root = new Node<T>(data);
			return; 
		}
	
		if(curr.data.compareTo(data) >= 0 && curr.left == null){
			curr.left = new Node<T>(data);
		}else if(curr.data.compareTo(data) < 0 && curr.right == null) {
			curr.right = new Node<T>(data);
		}else{
			if(curr.data.compareTo(data) >= 0) {
				insert(data, curr.left);
			}else {
				insert(data, curr.right);
			}
		}
	}
	
	public ArrayList<T> sort(){
		ArrayList<T> out = new ArrayList<>();
		inOrder(root, out);
		return out;
	}
	
	private void inOrder(Node<T> curr, ArrayList<T> out) {
		if(curr != null) {
			inOrder(curr.left, out);
			out.add(curr.data);
			inOrder(curr.right, out);
		}
	}
	
	public void removeRec(T data) {
		root = remove(root, data);
	}
	
	private Node<T> remove(Node<T> curr, T data) {
		// Tree is empty
		if(root == null) return null;
		// if the data is in the left subtree
		if(curr.data.compareTo(data) > 0) {
			curr.left = remove(curr.left, data);
		// if the data is in the right subtree
		}else if(curr.data.compareTo(data) < 0) {
			curr.right = remove(curr.right, data);
		}else {
			// if node has one or no child
			if(curr.left == null || curr.right == null) {
				return (curr.left == null) ? curr.right:curr.left;
			}else {
			// if node has two children
				Node<T> minNode = minValueNode(curr.right);
				curr.data = minNode.data;
				curr.right = remove(curr.right, curr.data); 
			}
		}
		return curr;
	}
	
	private Node<T> minValueNode(Node<T> curr) {
		if(curr.left == null) return curr;
		return minValueNode(curr.left);
	}
		
	public T findMaxRec() {
		return findMaxNode(root).data;
	}
	
	private Node<T> findMaxNode(Node<T> curr) {
		if(root == null) return null;
		if(curr.right == null) return curr;
		return findMaxNode(curr.right);
	}
	
	public T findMinRec() {
		return findMinNode(root).data;
	}
	
	private Node<T> findMinNode(Node<T> curr) {
		if(root == null) return null;
		if(curr.left == null) return curr;
		return findMinNode(curr.left);
	}
	
	public T findNextRec(T data) {
		return findNextRec(root, data);
	}
	
	private T findNextRec(Node<T> curr, T data) {
		if(curr.data.compareTo(data) > 0) {
			return findNextRec(curr.left, data);
		}else if(curr.data.compareTo(data) < 0) {
			return findNextRec(curr.right, data);
		}else {
			if(curr.right != null) {
				return findMinNode(curr.right).data;
			}else {
				return searchNextFromRoot(root, data, null);	
			}
		}
	}
	
	private T searchNextFromRoot(Node<T> curr, T data, T succ) {
		if(curr.data.compareTo(data) > 0) {
			return searchNextFromRoot(curr.left, data, curr.data);
		}else if(curr.data.compareTo(data) < 0) {
			return searchNextFromRoot(curr.right, data, succ);
		}else {
			return succ;
		}	
	}
	
	public T findPrevRec(T data) {
		return findPrevRec(root, data);
	}
	
	private T findPrevRec(Node<T> curr, T data) {
		if(curr.data.compareTo(data) > 0) {
			return findPrevRec(curr.left, data);
		}else if(curr.data.compareTo(data) < 0) {
			return findPrevRec(curr.right, data);
		}else {
			if(curr.left != null) {
				return findMaxNode(curr.left).data;
			}else {
				return searchPrevFromRoot(root, data, null);	
			}
		}
	}
	
	private T searchPrevFromRoot(Node<T> curr, T data, T prev) {
		// if node is greater than data
		if(curr.data.compareTo(data) > 0) {
			return searchPrevFromRoot(curr.left, data, prev);
		}else if(curr.data.compareTo(data) < 0) {
			return searchPrevFromRoot(curr.right, data, curr.data );
		}else {
			return prev;
		}	
	}
	

	
}
