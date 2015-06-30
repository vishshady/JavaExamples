package someExamples;

public class India extends Currency {

	public India(int currency) {
		super(currency);
	}

	void value() {
		System.out.printf("Indian Rupee for "+c+" is "+c*65+" INR");
	}
}
