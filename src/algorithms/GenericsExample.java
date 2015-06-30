package algorithms;

public class GenericsExample<A, B> {
	A a;
	B b;

	GenericsExample(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A getA() {
		return a;
	}

	public B getB() {
		return b;
	}

	public static void main(String[] args) {
		GenericsExample<String, Integer> g = new GenericsExample<String, Integer>(
				"Vishwas", 25);
		System.out.println(g.getA() + " " + g.getB());
		
		GenericsExample<String,Double> g1 = new GenericsExample<String, Double>(
				"Vishwas", 25.7);
		System.out.println(g1.getA() + " " + g1.getB());

	}

}
