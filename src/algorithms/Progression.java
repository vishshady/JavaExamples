package algorithms;

public class Progression {
	protected long current;

	public Progression() {
		this(0);
	}

	public Progression(long start) {
		current = start;
	}

	public long nextValue() {
		long current = this.current;
		advance();
		return current;
	}

	protected void advance() {
		current++;
	}

	public void printProgression(int n) {
		System.out.print(nextValue());
		for (int i = 1; i <= n; i++)
			System.out.print(" " + nextValue());
		System.out.println();
	}

}
