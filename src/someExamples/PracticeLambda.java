package someExamples;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import someExamples.MyMath;

public class PracticeLambda {
	ArrayList<Integer> i = new ArrayList<Integer>();

	public int calc(BiFunction<Integer, Integer, Integer> f, int a, int b) {
		return f.apply(a, b);
	}

	public ArrayList<Integer> getData() {
		for (int j = 0; j <= 10; j++)
			i.add(j);
		return i;
	}

	BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

	public int add(int a, int b) {
		return a + b;
	}

	public int add(int a) {
		return a + a;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int getOddNumbers() {
		return i.size();
	}

	public static void main(String[] args) {
	
	}
}
