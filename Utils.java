import java.util.HashSet;
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
		Random rand = new Random();
		Set<Integer> set = new HashSet<Integer>();
		int inserted = 0;
		while(inserted < n) {
			int newNum = rand.nextInt(n);
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
}
