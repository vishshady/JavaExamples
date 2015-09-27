package someExamples;

import someExamples.MyMath;
import someExamples.Reverse;

public class Lambda {
	static MyValue v1 = () -> 1234;

	static int operator(MyMath m, int a, int b) {
		return m.value(a, b);
	}

	public static void main(String[] args) {

		// Call the lambda object from class body
		System.out.println(v1.getValue());

		MyMath add = (a, b) -> a + b;
		MyMath substract = (a, b) -> a - b;
		MyMath multiply = (a, b) -> a * b;
		MyMath divide = (a, b) -> a / b;
		int a = 10;
		int b = 5;
		System.out.printf("Add operation for %d %d is %d ", a, b,
				add.value(a, b));
		System.out.printf("\nSubstract operation for %d %d is %d ", a, b,
				substract.value(a, b));
		System.out.printf("\nMultiply operation for %d %d is %d ", a, b,
				multiply.value(a, b));
		System.out.printf("\nDivide operation for %d %d is %d ", a, b,
				divide.value(a, b));
		// Demonstrate lambdas with generic interface

		Reverse<String> r = (s) -> {
			int i;
			String str = "";
			for (i = s.length() - 1; i >= 0; i--) {
				str += s.charAt(i);
			}
			return str;
		};

		Reverse<Integer> factorial = (n) -> {
			int i = 0;
			for (int j = 1; j <= n; j++)
				i = j * n;
			return i;
		};

		System.out.println(r.value("Vishwas"));
		System.out.println(factorial.value(5));

		// Demonstrates passing lambdas variable as arguments to a function
		MyMath modulus = (x, y) -> x % y;

		System.out
				.println("Demonstrates passing lambdas variable as arguments to a function Modulus: "
						+ operator(modulus, 12, 5));

		// Demonstrates passing lambdas as arguments to a function

		System.out
				.println("Demonstrates passing lambdas as arguments to a function Modulus: "
						+ operator((x, y) -> x % y, 25, 4));

	}
}