package someExamples;

/* Example for '?' operator*/
public class Operands {
	public static void main(String args[]) {
		int a = 100, b = 120;
		Operands o = new Operands();

		System.out.printf("greater value among %d , %d is ", a, b);
		System.out.println(o.greater(a, b));
	}

	//Returns the greater value
	int greater(int a, int b) {
		// if (b > a) condition is true return b , else (b>a) condition is false and return a
		return b > a ? b : a;
	}
}
