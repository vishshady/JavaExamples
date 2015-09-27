package algorithms;

public class TowerOfHanoi {

	public void hanoi(int n, String from, String to, String aux) {
		if (n == 1) {
			System.out.printf("Move Disk %d from %s to %s\n", n, from, to);
			return;
		}
		hanoi(n - 1, from, aux, to);
		System.out.printf("Move Disk %d from %s to %s\n", n, from, to);
		hanoi(n-1, from, to, aux);

	}

	public static void main(String[] args) {
		TowerOfHanoi t = new TowerOfHanoi();
		t.hanoi(3, "A", "C", "B");

	}

}
