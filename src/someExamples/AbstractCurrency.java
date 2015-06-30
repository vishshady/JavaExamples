package someExamples;

public abstract class AbstractCurrency {
	int value;

	AbstractCurrency(int value) {
		this.value = value;
	}
	
	//THis forces sub classes to implement this
	abstract void value();
}
