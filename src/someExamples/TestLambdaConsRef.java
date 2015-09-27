package someExamples;

public class TestLambdaConsRef {

	static <R, T> R conv(LambdaICons<R, T> i, T t) {
		return i.func(t);
	}

	public static void main(String[] args) {
	LambdaICons<LambdaConsRef<String>, String> my = LambdaConsRef::new;
	LambdaConsRef<String> cons = conv(my, "Become a MAn!");
	System.out.println(cons.getValue());

	}
}
