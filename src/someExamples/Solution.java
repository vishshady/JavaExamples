package someExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(in.readLine());

		for (int test = 0; test < tests; test++) {
			String sb = "";
			int n = Integer.parseInt(in.readLine());
			for (int i = n; i >= 0; i--) {
				if (i % 3 == 0 && (n - i) % 5 == 0) {
					if (i != 0)
						for (int j = 0; j < i; j=j*3)
							sb += "555";
					if ((n - i) != 0)
						for (int j = 0; j < (n - i); j=j*5)
							sb += "33333";
					break;
				}
			}

			if (sb == "")
				System.out.println("-1");
			else
				System.out.println(sb);
		}
	}

}
