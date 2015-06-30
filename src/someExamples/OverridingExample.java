package someExamples;

public class OverridingExample {

	public static void main(String[] args) {
		Currency c;
		India i =new India(100);
		c = i;
		c.value();
		c = new USA(100);
		c.value();

	}

}
