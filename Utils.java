import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * TODO Put here a description of what this class does.
 *
 * @author USMAN.
 *         Created Feb 24, 2020.
 */
public class Utils {
	public static int[] getRandomArray(int n) {
		int[] array = new int[n];
		Random rand = new Random(1);
		Set<Integer> set = new HashSet<Integer>();
		int inserted = 0;
		while(inserted < n) {
			int newNum = rand.nextInt(5*n);
			if(!set.contains(newNum)) {
				array[inserted++] = newNum;
				set.add(newNum);
			}
		}
		rand.nextInt();
		return array;
	}
	
	public static int[] getSortedArray(int n) {
		int[] array = new int[n];
		for(int i=0, j=n-1; i < n; i++, j--) {
			array[i] = j;
		}
		return array;
	}
	
	public static <T extends Comparable<? super T>> int numOfNodes(Node<T> root) {
		if (root==null) 
	        return 0;  
	          
	        // Initialize empty queue. 
	        Queue<Node<T>> queue = new LinkedList<Node<T>>(); 
	          
	        // Do level order traversal starting from root 
	        queue.add(root); 
	          
	        int count=0; // Initialize count of full nodes 
	        while (!queue.isEmpty())  
	        { 
	  
	            Node<T> temp = queue.poll(); 
	   
	            // Enqueue left child  
	            if (temp.left != null)  
	            { 
	                queue.add(temp.left); 
	            } 
	  
	            // Enqueue right child  
	            if (temp.right != null)  
	            { 
	                queue.add(temp.right); 
	            } 
	        	count++; 
	      	  
	        } 
	        return count; 
	}
	
}
