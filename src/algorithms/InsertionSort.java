package algorithms;

public class InsertionSort {

	public static char[] insert(char[] c) {
		for (int i = 1; i < c.length; i++) {
			char curr = c[i];
			int k = i;
			while (k > 0 && c[k - 1] > curr) {
				c[k] = c[k - 1];
				k--;
			}
			c[k] = curr;
		}
		return c;
	}

	public static void main(String[] args) {
		char[] myChar = { 'A', 'B', 'D', 'Z', 'A', 'F', 'Z' };
		for (char i : InsertionSort.insert(myChar))
			System.out.print(i + " ");

	}

}
