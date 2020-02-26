
/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Feb 20, 2020.
 */
public class BinaryTreeIter <T extends Comparable<? super T>> {
	private Node<T> root;
	
	public void insertIter(T data) {
		Node<T> curr = root;
		if(root == null) {
			this.root = new Node<T>(data);
		}
		while(curr != null) {
			if(curr.left == null && curr.data.compareTo(data) >= 0) {
				curr.left = new Node<T>(data);
				break;
			}else if(curr.right == null && curr.data.compareTo(data) < 0){
				curr.right = new Node<T>(data);	
				break;
			}
			curr = getNextCurr(curr, data);
		}
	}
		
	public void removeIter(T data) {
		// finding the parent node of the node to be removed
		Node<T> curr = root;
		while(curr != null) {
			// if data to be removed is in root
			if(curr == root && curr.data.compareTo(data) == 0) {
				if(curr.right == null && curr.left == null) {
					this.root = null;
				}else {
					Node<T> current = curr;
					removeNodeWithTwoChild(current);
					return;	
				}
			}else if(curr.left != null && curr.left.data.compareTo(data) == 0) {
				Node<T> current = curr.left;
				if(current.right == null || current.left == null) {
					removeleafNode(curr, data);
				}else {
					removeNodeWithTwoChild(current);
				}
			}else if(curr.right != null && curr.right.data.compareTo(data) == 0) {
				Node<T> current = curr.right;
				if(current.right == null || current.left == null) {
					removeleafNode(curr, data);
				}else {
					removeNodeWithTwoChild(current);
				}	
			}else {
				curr = getNextCurr(curr, data);
			}		
		}
	}

	private void removeNodeWithTwoChild(Node<T> current) {
		Node<T> minNodeParent = minValueNodeParent(current.right);
		minNodeParent = minNodeParent == null ? current: minNodeParent;
		current.data = minNodeParent.left.data;
		removeleafNode(minNodeParent, minNodeParent.left.data);
		
	}
	
	private void removeleafNode(Node<T> curr, T data) {
		Node<T> current;
		if(curr.right != null && curr.right.data.compareTo(data) == 0) {
			current = curr.right;
			curr.right = (current.right == null) ? current.left : current.right;
		}else if(curr.left != null && curr.left.data.compareTo(data) == 0){
			current = curr.left;
			curr.left = (current.right == null) ? current.left : current.right;
		}
	}
	
	// return the parent node of RightMostNode
	private Node<T> minValueNodeParent(Node<T> curr){
		Node<T> minNode = curr;
		if(curr.left == null) return null;
		while(curr.left != null) {
			if(curr.left.left == null) minNode = curr;
			curr = curr.left;
		}
		return minNode;
	}
	
	private Node<T> getNextCurr(Node<T> curr, T data){
		Node<T> nextCurr;
		if(curr.data.compareTo(data) >= 0) {
			nextCurr = curr.left;
		}else {
			nextCurr = curr.right;
		}
		return nextCurr;
	}
	
	public T findMaxIter() {
		return findMaxIter(root);
	}
	
	private T findMaxIter(Node<T> current) {
		if(root == null) return null;
		Node<T> curr = current;
		while(curr.right != null) {
			curr = curr.right;
		}
		return curr.data;
	}
	
	public T findMinIter() {
		return findMinIter(root);
	}
	
	private T findMinIter(Node<T> current) {
		if(root == null) return null;
		Node<T> curr = current;
		while(curr.left != null) {
			curr = curr.left;
		}
		return curr.data;
	}
	
	public T findNextIter(T data) {
		Node<T> curr = root;
		T next = null;
		while(curr != null) {
			if(curr.data.compareTo(data) > 0) {
				curr = curr.left;
			}else if(curr.data.compareTo(data) < 0) {
				curr = curr.right;
			}else {
				if(curr.right != null) {
					return findMaxIter(curr.right);
				}else {
					return searchNextFromRoot(data);
				}
			}
		}
		return next;
	}
	
	private T searchNextFromRoot(T data) {
		Node<T> curr = root;
		T next = null;
		while(curr != null) {
			if(curr.data.compareTo(data) > 0) {
				next = curr.data;
				curr = curr.left;
			}else if(curr.data.compareTo(data) < 0) {
				curr = curr.right;
			}else {
				return next;
			}	
		}
		return next;
	}
	
	public T findPrevIter(T data) {
		Node<T> curr = root;
		T prev = null;
		while(curr != null) {
			if(curr.data.compareTo(data) > 0) {
				curr = curr.left;
			}else if(curr.data.compareTo(data) < 0) {
				curr = curr.right;
			}else {
				if(curr.left != null) {
					return findMinIter(curr.left);
				}else {
					return searchPrevFromRoot(data);
				}
			}
		}
		return prev;
	}
	
	private T searchPrevFromRoot(T data) {
		Node<T> curr = root;
		T prev = null;
		while(curr != null) {
			if(curr.data.compareTo(data) > 0) {
				curr = curr.left;
			}else if(curr.data.compareTo(data) < 0) {
				prev = curr.data;
				curr = curr.right;
			}else {
				return prev;
			}	
		}
		return prev;
	}
}
