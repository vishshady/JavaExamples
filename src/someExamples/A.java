package someExamples;

import java.io.IOException;

import javax.swing.text.NumberFormatter;

public class A {
	static void sum(int i) throws IOException {
		try {
			if (i == 0)
				throw new IOException();
			else if (i == 1)
				throw new NumberFormatException();
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.printf("some exception " + i + " " + e.toString());
			throw e;
		}

	}

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		sum(1);
	}

}
