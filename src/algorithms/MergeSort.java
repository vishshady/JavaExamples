package algorithms;

import java.util.Arrays;

public class MergeSort {

	public static void merge(int[] s1, int[] s2, int[] s) {
		int i = 0;
		int j = 0;
		while (i + j < s.length) {
			if (j == s2.length || (i < s1.length && s1[i] < s2[j]))
				s[i + j] = s1[i++];
			else
				s[i + j] = s2[j++];
		}
	}

	public static void mergeSort(int[] s) {
		int n = s.length;
		if (n < 2)
			return;
		int mid = n / 2;
		int[] s1 = Arrays.copyOfRange(s, 0, mid);
		int[] s2 = Arrays.copyOfRange(s, mid, n);
		mergeSort(s1);
		mergeSort(s2);
		merge(s1, s2, s);
	}

	public static void main(String[] args) {
		int[] i = { 2,4,3,1};
		int[] j = { 2, 55, 12, 4, 7, 0, 1 };
		 mergeSort(i);
		 System.out.println(Arrays.toString(i));
//		quickSort(j);
//		System.out.println(Arrays.toString(j));

	}

	public static void quickSort(int[] s) {
		if (s.length < 2)
			return;
		int pivot = s[s.length - 1];
		int[] l = new int[s.length];
		int[] e = new int[s.length];
		int[] g = new int[s.length];
		int lIndex = 0, eIndex = 0, gIndex = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] < pivot)
				l[lIndex++] = s[i];
			else if (s[i] == pivot)
				e[eIndex++] = s[i];
			else
				g[gIndex++] = s[i];
		}
		l = Arrays.copyOf(l, lIndex);
		e = Arrays.copyOf(e, eIndex);
		g = Arrays.copyOf(g, gIndex);
		quickSort(l);
		quickSort(g);
		int count = 0;
		for (int lc : l)
			s[count++] = lc;
		for (int ec : e)
			s[count++] = ec;
		for (int gc : g)
			s[count++] = gc;
	}

}
