package someExamples;

import java.util.regex.*;

public class RemoveDots {

	public static void main(String[] args) {
		String sentence = "Hi..My...Name.Is...Vishwas !";
		System.out.println(sentence.replaceAll("(\\w)(\\.+)(\\w)", "$1 $3"));
	}

	public static void regex(String regex, String input) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);

		while (m.find()) {
			if (m.group().length() != 0)
				System.out.println(m.group().trim());
		}
	}

}
