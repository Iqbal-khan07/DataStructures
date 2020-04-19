
import java.util.HashMap;
import java.util.Stack;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Feb 28, 2020.
 */

public class AVLTreeIter<T extends Comparable<? super T>> extends BinaryTreeIter<T>{
	private HashMap<Node<T>, Integer[]> bfs = new HashMap<>(); 
	private Node<T> flagged = null;
	
	public AVLTreeIter() {
		super();
	}
	
	@Override
	public void insertIter(T data) {
		Node<T> curr = root;
		Integer[] heights = {0, 0};
		
		// inserting into the tree
		if(root == null) {
			this.root = new Node<T>(data);
			bfs.put(root, heights);
			return;
		}
		
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);
		while(curr != null) {
			if(curr.left == null && curr.data.compareTo(data) >= 0) {
				curr.left = new Node<T>(data);
				bfs.put(curr.left, heights);
				break;
			}else if(curr.right == null && curr.data.compareTo(data) < 0){
				curr.right = new Node<T>(data);	
				bfs.put(curr.right, heights);
				break;
			}
			curr = getNextCurr(curr, data);
			stack.push(curr);
		}		
		
		// calculating the height of each node from the bottom and on the way up rotating
		updateAndBalance(stack);
		
	}
	
	private void updateAndBalance(Stack<Node<T>> stack) {
		Node<T> curr = null;
		while(!stack.isEmpty()) {
			curr = stack.pop();
			if(curr != null) {
				if(flagged != null) {
					balance(curr);
					flagged = null;
				}
				
				int lheight = (curr.left != null) ? height(curr.left):0;
				int rheight = (curr.right != null) ? height(curr.right):0;
				if(Math.abs(BF(lheight, rheight)) > 1) {
					flagged = curr;
				}
				updateHeights(curr, lheight, rheight);
			}
		}
		// if imbalance is on the root
		if(flagged != null) {
			balanceRoot(root);
			flagged = null;
		}
		
	}
	
	private void balanceRoot(Node<T> parent) {
		Node<T> current = parent;
			
		int BF_current = BF(current);
		if(BF_current > 0) {
			int BF_current_left = BF(current.left);
			//rotate right
			if(BF_current_left >= 0) {
				root = rotateRight(current);
			//rotate left right
			}else {
				root.left = rotateLeft(current.left);
				root = rotateRight(current);
			}
		}else if(BF_current < 0) {
			int BF_current_right = BF(current.right);
			//rotate left
			if(BF_current_right <= 0) {
				root = rotateLeft(current);
			//rotate right left
			}else {
				root.right = rotateRight(current.right);
				root = rotateLeft(current);
			}
		}
	}
	
	private void balance(Node<T> parent) {
		Node<T> current = null;
		boolean left = false;
		
		if(parent.right != null && Math.abs(BF(parent.right)) > 1) {
			current = parent.right;
			left = false;
		}else if(parent.left != null && Math.abs(BF(parent.left)) > 1){
			current = parent.left;
			left = true;
		}
		
		int BF_current = BF(current);
		if(BF_current > 0) {
			int BF_current_left = BF(current.left);
			//rotate right
			if(BF_current_left >= 0) {
				if(left) {
					parent.left = rotateRight(current);
				}else {
					parent.right = rotateRight(current);
				}
				
			//rotate left right
			}else {
				current.left = rotateLeft(current.left);
				if(left) {
					parent.left = rotateRight(current);
				}else {
					parent.right = rotateRight(current);
				}
				
			}
		}else if(BF_current < 0) {
			int BF_current_right = BF(current.right);
			//rotate left
			if(BF_current_right <= 0) {
				if(left) {
					parent.left = rotateLeft(current);
				}else {
					parent.right = rotateLeft(current);
				}
				
			//rotate right left
			}else {
				current.right = rotateRight(current.right);
				if(left) {
					parent.left = rotateLeft(current);
				}else {
					parent.right = rotateLeft(current);
				}
			}
		}
	}
		
	private Node<T> rotateRight(Node<T> curr) {
		Node<T> oldRoot = curr;
		Node<T> temp = curr.left.right;
		curr = curr.left;
		curr.right = oldRoot;
		curr.right.left = temp;
		
		// updating the heights
		updateLeftHeight(curr.right, getHeight(temp)+1);
		updateRightHeight(curr, getHeight(curr.right)+1);
		
		return curr;
				
	}

	public Node<T> rotateLeft(Node<T> curr) { 
		Node<T> oldRoot = curr;
		Node<T> temp = curr.right.left;
		curr = curr.right;
		curr.left = oldRoot;
		curr.left.right = temp;
		
		// updating the heights
		updateRightHeight(curr.left, getHeight(temp)+1);
		updateLeftHeight(curr, getHeight(curr.left)+1);
		return curr;
	}	
	
	// helper function based on which side of tree we go to search
	private void updateHeights(Node<T> node, int lheight, int rheight) {
		Integer[] heights = bfs.get(node);
		heights[0] = lheight;
		heights[1] = rheight;
		bfs.put(node, heights);
	}
	
	private void updateLeftHeight(Node<T> node, int lheight) {
		Integer[] heights = bfs.get(node);
		heights[0] = lheight;
		bfs.put(node, heights);
	}
	
	private void updateRightHeight(Node<T> node, int rheight) {
		Integer[] heights = bfs.get(node);
		heights[1] = rheight;
		bfs.put(node, heights);
	}
	

	private int height(Node<T> node) {
		Integer[] heights = bfs.get(node);
		return Math.max(heights[0], heights[1]) + 1;
	}
	
	private int getHeight(Node<T> node) {
		if(node != null ) {
			Integer[] heights = bfs.get(node);
			return Math.max(heights[0], heights[1]);
		}
		return -1;
	}

	@Override
	public void removeIter(T data) {
		// finding the parent node of the node to be removed
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);
		Node<T> curr = root;
		while(curr != null) {
			// if data to be removed is in root
			if(curr == root && curr.data.compareTo(data) == 0) {
				if(curr.right == null && curr.left == null) {
					this.root = null;
				}else if(curr.right == null || curr.left == null){
					removeleafNode(curr, data);
				}else {
					Node<T> current = curr;
					removeNodeWithTwoChild(current, curr);
					return;	
				}
			}else if(curr.left != null && curr.left.data.compareTo(data) == 0) {
				Node<T> current = curr.left;
				if(current.right == null || current.left == null) {
					removeleafNode(curr, data);
				}else {
					removeNodeWithTwoChild(current, curr);
				}
			}else if(curr.right != null && curr.right.data.compareTo(data) == 0) {
				Node<T> current = curr.right;
				if(current.right == null || current.left == null) {
					removeleafNode(curr, data);
				}else {
					removeNodeWithTwoChild(current, curr);
				}	
			}else {
				curr = getNextCurr(curr, data);
				stack.push(curr);
			}		
		}
		
		updateAndBalance(stack);
	}
	
	private void removeNodeWithTwoChild(Node<T> current, Node<T> parent) {
		Node<T> minNodeParent = minValueNodeParent(current.right);
		minNodeParent = (minNodeParent == null) ? current: minNodeParent;
		if(minNodeParent == current) {
			current.data = current.right.data;
			removeleafNode(minNodeParent, minNodeParent.right.data);	
		}else {
			current.data = minNodeParent.left.data;
			removeleafNode(minNodeParent, minNodeParent.left.data);	
		}
		
		
		updateAndBalanceRightLeftSide(current, parent);
	}
	
	private void updateAndBalanceRightLeftSide(Node<T> curr, Node<T> parent) {
		Stack<Node<T>> stack = new Stack<>();
		if(curr != parent) {
			stack.push(parent);
		}
		
		stack.push(curr);
		if(curr.right != null) {
			curr = curr.right;
			stack.push(curr);
			while(curr.left != null) {
				curr = curr.left;
				stack.push(curr);
			}
		}
		updateAndBalance(stack);
	}
		
	private int BF(Node<T> node) {
		Integer[] heights = bfs.get(node);
		return heights[0] - heights[1];
	}
	
	private int BF(int left, int right) {
		return left - right;
	}
	
}
