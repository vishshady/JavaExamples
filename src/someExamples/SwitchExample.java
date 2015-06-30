package someExamples;

public class SwitchExample {
	SwitchExample(Operands o, int a, int b) {
		o.greater(a, b);
		System.out.printf("greater value among %d , %d is ", a, b);
		System.out.println(o.greater(a, b));
	}

	public static void main(String args[]) {

		// Passing an object to constructer example
		Operands o = new Operands();
		SwitchExample s = new SwitchExample(o, 10, 13);
		// Simple switch example
		s.showSwitch(5);
	}

	void showSwitch(int month) {
		switch (month) {
		case 1:
		case 2:
		case 3:
			System.out.println("Sprint Season");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("Summer Season");
			break;
		case 7:
		case 8:
		case 9:
			System.out.println("Rainy Season");
			break;
		case 10:
		case 11:
		case 12:
			System.out.println("Winter Season");
		}
	}
}
