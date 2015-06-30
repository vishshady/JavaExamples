package someExamples;

public class AbstractExample {
	public static void main(String args[]) {
		AbstractCurrency ac;
		ac = new AbstractIndia(100);
		ac.value();
		ac = new AbstractUsa(100);
		ac.value();
	}
}
