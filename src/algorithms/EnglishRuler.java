package algorithms;
/**
--- 0
- 
-- 
- 
--- 1
- 
-- 
- 
--- 2

 * @author Vishshady
 *
 */
public class EnglishRuler {

	public static void drawRuler(int inch, int majorLength) {
		drawLine(majorLength, 0);
		for (int i = 1; i <= inch; i++) {
			drawInterval(majorLength-1);
			drawLine(majorLength, i);
		}
	}

	private static void drawInterval(int i) {
		if (i >= 1) {
			drawInterval(i - 1);
			drawLine(i);
			drawInterval(i - 1);
		}
	}

	private static void drawLine(int majorLength, int label) {
		for (int i = 0; i < majorLength; i++)
			System.out.print("-");
		System.out.printf(" %d\n", label);
	}

	private static void drawLine(int majorLength) {
		for (int i = 0; i < majorLength; i++)
			System.out.print("-");
		System.out.printf(" \n");
	}

	public static void main(String[] args) {
		drawRuler(2, 3);
	}

}
