package someExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class LambdasCollectionMax {

	public static void main(String[] args) {
		ArrayList<MyClass> a = new ArrayList<MyClass>();
		a.add(new MyClass(1));
		a.add(new MyClass(6));
		a.add(new MyClass(1));
		a.add(new MyClass(8));
		a.add(new MyClass(9));
		a.add(new MyClass(7));

		MyClass max = Collections.max(a, LambdasComparator::compareBy);

		System.out.println("Max value is : "+max.getValue());
		
		Function<Integer, String> covertToString = (n) -> String.valueOf("Converted " + n) ;
		
					System.out.printf("Convert int %d to string %s ",5,covertToString.apply(5));
	}
	
	
}
