package algorithms;

import java.util.stream.IntStream;

/**
 * Worst case O(n) Best Case O(log n)
 * 
 * @author Vishshady
 *
 */
public class BinarySearch {

	public static boolean binarySearch(int[] val, int key, int low, int high) {
		if (low > high)
			return false;
		else {
			int mid = (low + high) / 2;
			if (val[mid] == key)
				return true;
			if (val[mid] > key)
				return binarySearch(val, key, low, mid - 1);
			if (val[mid] < key)
				return binarySearch(val, key, mid + 1, high);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(binarySearch(IntStream.range(0, 10).toArray(), 0, 0,
				9));
int a = -10;
int b= -1;
a = a+b;
b = a-b;
a = a-b;
System.out.printf("%d %d",a,b);
	}

}
