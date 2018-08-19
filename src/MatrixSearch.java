
public class MatrixSearch {
	public static void run() {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(searchMatrix(matrix, 5));
		System.out.println(searchMatrix(matrix, 20));
		System.out.println(searchMatrix(new int[][] { { 1, 2, 3 } }, -1));
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
		int aX = 0, bX = matrix[0].length - 1;
		bX = bX >= 0 ? bX : 0;
		int midX = (bX - aX) / 2;
		int aY = 0, bY = matrix.length - 1;
		bY = bY >= 0 ? bY : 0;
		int midY = (bY - aY) / 2;
		while (bX - aX > 1 || bY - aY > 1) {
			System.out.print(aX+","+bX+"\n");
			if (target == matrix[midX][midY] || target == matrix[aX][aY] || target == matrix[bX][aY]) {
				return true;
			}
			if (target < matrix[midX][midY]) {
				bY = midY;
				bX = midX;
				midX = (bX - aX) / 2;
				midY = (bY - aY) / 2;
			}
			if (target > matrix[midX][midY]) {
				aX = midX;
				aY = midY;
				midX = aX + (bX - aX) / 2;
				midY = aY + (bY - aY) / 2;
			}

		}

		return false;
	}
}
