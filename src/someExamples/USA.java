package someExamples;

public class USA extends Currency {

	public USA(int currency) {
		super(currency);
	}

	void value() {
		System.out.printf("USA DOllar for " + c + " is " + c / .65 + " $");
	}
}
