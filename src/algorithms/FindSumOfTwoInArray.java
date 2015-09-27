package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class FindSumOfTwoInArray {

	public static void main(String[] args) {
		int[] i = { 2, 6, 8, 1, 4, 0, -3, 5 };
		Set<Integer> set = new HashSet<Integer>();
		int sum = 3;
		for (int j : i) {
			int tar = sum - j;
			if(!set.contains(tar))
				set.add(j);
			else {
				System.out.printf("Found sum %d for %d %d",sum,j,tar);
				break;
			}

		}
		HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();
		h.put(12, 12);
	Set<Entry<Integer,Integer>> en=	h.entrySet();

	}

}
