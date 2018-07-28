import java.util.Stack;

public class WordSearch {
	public static void run() {
		char[][] board = { 
				{ 'A', 'B', 'C', 'E' }, 
				{ 'S', 'F', 'C', 'S' }, 
				{ 'A', 'D', 'E', 'E' } 
				};
		System.out.println(exist(board, "ABCE"));
		System.out.println(exist(board, "ABCD"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "FCCB"));
		char[][] board2 = {{'a','a'}};
		System.out.println(exist(board2, "a"));
		System.out.println(exist(board2, "aaa"));
		
		char[][] board3 = {
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}
				};
		System.out.println("board 3 " + exist(board3, "ABCESEEEFS"));
		
		char[][] board4 = {
				{'A','A','A','A'},
				{'A','A','A','A'},
				{'A','A','A','A'},
				};
		System.out.println("board4 " + exist(board4, "AAAAAAAAAAAAA"));
	}

	private static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length ; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) 
						&& existRec(board, word, i, j, new boolean[board.length][board[0].length])) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean existRec(char[][] board, String word, int row, int col, boolean[][] visited) {
		if (word.length() == 0) {
			return true;
		}
		
		
		if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
			return false;
		}
		
		if (word.charAt(0) != board[row][col] || visited[row][col]) {
			return false;
		}
		
		boolean found = false;;
		
		// current letter matches
		if (board[row][col] == word.charAt(0) && !visited[row][col]) {
			visited[row][col] = true;
			found = existRec(board, word.substring(1), row - 1, col, visited) 
					|| existRec(board, word.substring(1), row + 1, col, visited)
					|| existRec(board, word.substring(1), row, col - 1, visited)
					|| existRec(board, word.substring(1), row, col + 1, visited);

		}
		
		visited[row][col] = false;
		return found;
	}
}
