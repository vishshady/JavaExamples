package someExamples;

public class LambdaConsRef<T> {
	T t;

	public LambdaConsRef(T t) {
		this.t = t;
	}
	
	T getValue(){
		return t;
	}

}
