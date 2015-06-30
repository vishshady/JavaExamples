package someExamples;

public class InheritanceSubClassRefExample {
	// Super class variable can reference a sub class object
	public static void main(String[] args) {
		Box b = new Box();
		BoxPlain bp = new BoxPlain();
		bp.plain(10, 20);
		System.out.println("Before referencing the subclass object");
		b.box();
		b = bp;
		System.out.println("After Referencing");
		b.box();
	}

}
