package algorithms;

/**
 * Tic Tac Toe game. Its two player game. In a 3 * 3 board, put 'X' and 'O'
 * mark. Winner is decided if any of the mark makes a line either vertically or
 * horizontally or diagonally.
 * 
 * @author Vishshady
 *
 */
public class TicTacToe {
	int[][] board = new int[3][3];
	public final int EMPTY = 0;
	public int player;
	public final int X = 1, O = -1;

	public TicTacToe() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = EMPTY;
		player = X;
	}

	public void mark(int i, int j) throws IllegalArgumentException {
		if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
			throw new IllegalArgumentException("Invalid board position");
		if (board[i][j] != EMPTY)
			throw new IllegalArgumentException("Board position occupied");
		board[i][j] = player;
		player = -player;
	}

	public boolean isWin(int mark) {
		return (board[0][0] + board[0][1] + board[0][2] == 3 * mark
				|| board[1][0] + board[1][1] + board[1][2] == 3 * mark
				|| board[2][0] + board[2][1] + board[2][2] == 3 * mark
				|| board[0][1] + board[1][1] + board[2][1] == 3 * mark
				|| board[0][2] + board[1][2] + board[2][2] == 3 * mark || board[0][0]
				+ board[1][0] + board[2][0] == 3 * mark);
	}

	public int winner() {
		if (isWin(X))
			return X;
		else if (isWin(O))
			return O;
		else
			return 0;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				switch (board[i][j]) {
				case X:
					sb.append("X");
					break;
				case O:
					sb.append("O");
					break;
				case EMPTY:
					sb.append(" ");
					break;
				}
				if (j < 2)
					sb.append("|");
			}
			if (i < 2)
				sb.append("\n-----\n");
		}
		return sb.toString();
	}

	public String displayWinner(int winner) {
		String[] stat = { "O Wins", "Tied", "X Wins" };
		return stat[1 + winner];
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		// X move ************** //Y move
		game.mark(1, 1);
		/***/
		game.mark(1, 0);
		game.mark(0, 2);
		/***/
		game.mark(2, 0);
		game.mark(0, 0);
		/***/
		game.mark(2, 2);
		System.out.println(game);
		System.out.println(game.displayWinner(game.winner()));
		game.mark(0, 1);
		/***/
		game.mark(1, 2);
		System.out.println(game);
		System.out.println(game.displayWinner(game.winner()));
	}

}
