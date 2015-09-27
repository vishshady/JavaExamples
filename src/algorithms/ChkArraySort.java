package algorithms;

import java.util.Arrays;

public class ChkArraySort {

	static boolean chk(int[] i, int index) {
		if (i.length == 1 || index < 2)
			return true;
		return (i[index - 1] < i[index - 2]) ? false : chk(i, index - 1);

	}

	public static void main(String[] args) {
		int[] i = { 0, 2, 3, 2 };
		System.out.println(chk(i, 2));
	}

}
