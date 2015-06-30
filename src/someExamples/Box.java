package someExamples;

public class Box {
	public int i;
	public int j;
	private String s = "This is private";

	Box() {
		System.out.println(s);
	}

	void box() {
		System.out.printf("Box class add %d %d is % d\n", i, j, (i + j));
	}
}
