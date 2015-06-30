package algorithms;

public class TestProgressions {

	public static void main(String[] args) {
		Progression pro = new FibonacciProgression(4, 6);
		pro.printProgression(10);

		long n = 10;
		long first = 4, second = 6;

		/* Explanation without interface */
		long prev = second - first;
		System.out.print(" " + first);

		for (int i = 1; i <= n; i++) {
			long temp = prev;
			prev = first;
			second = temp + prev;
			System.out.print(" " + second);
			first = second;
		}
		System.out.println();
		System.out.print(" " + 0);
		for (int i = 1; i <= n; i++) {
			System.out.print(" " + TestProgressions.fib(i));
		}
		System.out.println();

		// My way
		int current = 0;
		int next = 1;

		for (int i = 1; i <= 10; i++) {
			System.out.print(current + " ");
			current = current + next;
			next = current - next;
		}

		System.out.println();

	}

	/* Using recursion */
	public static long fib(long n) {
		return n < 2 ? n : fib(n - 1) + fib(n - 2);
	}
}
