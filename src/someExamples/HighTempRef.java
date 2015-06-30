package someExamples;

public class HighTempRef {
	// Counter for input array values matches the condition for compared value
	static <T> int counter(T[] t, MyFunc<T> f, T v) {
		int counter = 0;
		for (int j = 0; j < t.length; j++)
			if (f.value(t[j], v))
				counter++;
		return counter;
	}
}
