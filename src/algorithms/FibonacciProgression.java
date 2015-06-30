package algorithms;

/**
 * The Rule is xn = xn-1 + xn-2
 * 
 * where:
 * 
 * xn is term number "n" xn-1 is the previous term (n-1) xn-2 is the term before
 * that (n-2)
 * 
 * @author Vishshady
 *
 */
public class FibonacciProgression extends Progression {
	protected long prev;

	public FibonacciProgression() {
		this(0, 1);
	}

	public FibonacciProgression(long first, long second) {
		super(first);
		prev = second - first;
	}

	protected void advance() {
		long temp = prev;
		prev = current;
		current += temp;
	}
}
