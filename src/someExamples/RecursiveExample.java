package someExamples;

public class RecursiveExample {

	// Calculate the factorial of a given number
	static int factorial(int n) {
		return (n == 1) ? 1 : factorial(n - 1) * n;
	}

	public static void main(String args[]) {
		int number = 4;
		System.out.printf("Facotial of %d is %d", number, factorial(number));
	}
}
