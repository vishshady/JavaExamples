package algorithms;

import java.util.Arrays;
import java.util.Random;

public class PseudoRandom {

	public static void main(String[] args) {
		int[] i = new int[10];
		Random r = new Random(System.currentTimeMillis());
		for (int j = 0; j < i.length; j++)
			i[j] = r.nextInt(100);
		int[] orig = Arrays.copyOf(i, i.length);
		System.out.println("Arrays equals before sort : "
				+ Arrays.equals(i, orig));
		System.out.println("Original : " +  Arrays.toString(i));
		System.out.println("Cpy : " + Arrays.toString(orig));
		Arrays.sort(orig);
		System.out.println("Arrays equals after sort : "
				+ Arrays.equals(i, orig));
		System.out.println("Original : " +  Arrays.toString(i));
		System.out.println("Cpy : " + Arrays.toString(orig));

	}
}
