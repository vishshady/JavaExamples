package someExamples;

public class AbstractIndia extends AbstractCurrency {

	AbstractIndia(int value) {
		super(value);
	}

	@Override
	void value() {
		System.out.printf("Indian Rupee for " + value + " is " + value* 65
				+ " INR");
	}

}
