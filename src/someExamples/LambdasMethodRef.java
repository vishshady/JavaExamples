package someExamples;

public class LambdasMethodRef {

	public static void main(String[] args) {
		HighTemp[] ht = { new HighTemp(45), new HighTemp(35), new HighTemp(35),
				new HighTemp(54), new HighTemp(35), new HighTemp(43) };
		int count = 0;

		// Method reference
		count = HighTempRef.counter(ht, HighTemp::sameTemp, new HighTemp(35));
		System.out
				.println("<Method Ref> 35 C temperature days for last week : "
						+ count);

		count = HighTempRef.counter(ht, HighTemp::lessTemp, new HighTemp(45));
		System.out
				.println("<Method Ref> Less than 45 C temperature days for last week : "
						+ count);

		// Classic Lambda

		count = HighTempRef.counter(ht, (a, b) -> {
			return a.h1 == b.h1;
		}, new HighTemp(35));
		System.out
				.println("<Classic Lambda> 35 C temperature days for last week : "
						+ count);

		count = HighTempRef
				.counter(ht, (a, b) -> a.h1 < b.h1, new HighTemp(45));
		System.out
				.println("<Classic Lambda> Less than 45 C temperature days for last week : "
						+ count);
	}
}
