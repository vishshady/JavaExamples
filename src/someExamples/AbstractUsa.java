package someExamples;

public class AbstractUsa extends AbstractCurrency {

	public AbstractUsa(int currency) {
		super(currency);
	}

	@Override
	void value() {
		System.out.printf("USA DOllar for " + value + " is " + value / .65
				+ " $");

	}

}
