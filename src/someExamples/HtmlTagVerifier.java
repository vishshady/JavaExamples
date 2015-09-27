package someExamples;

import java.util.Stack;

public class HtmlTagVerifier {

	public static boolean verify(String line) {
		Stack<String> stack = new Stack<>();
		int j = line.indexOf("<");
		while (j != -1) {
			int k = line.indexOf(">", j + 1);
			if (k == -1)
				return false;
			String tag = line.substring(j + 1, k);
			if (!tag.startsWith("/")) {
				if (tag.indexOf(" ") != -1)
					tag = tag.substring(0, tag.indexOf(" "));
				stack.push(tag);
			} else {
				if (stack.isEmpty())
					return false;
				tag = tag.indexOf(" ") != -1 ? tag.substring(1,
						tag.indexOf(" ")) : tag.substring(1);
				if (!tag.equals(stack.pop()))
					return false;
			}
			j = line.indexOf("<", k + 1);
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out
				.println(verify("<body>\n<center>\n<h1 id='vish'> The Little Boat </h1> </center>\n<p> The storm tossed the little boat like a cheap sneaker in an old washing machine. The three drunken fishermen were used to such treatment, of course, but not the tree salesman, who even as a stowaway now felt that he\nhad overpaid for the voyage. </p> <ol>\n<li> Will the salesman die? </li> <li> What color is the boat? </li> <li> And what about Naomi? </li> </ol>\n </body>"));
	}

}
