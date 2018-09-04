
public class KthSmallestMatrix {
	public static void run() {
		assert kthSmallest(new int[][] { { 1, 5, 13 }, { 10, 11, 23 }, { 12, 13, 25 } }, 3) == 10;
	}

	public static int kthSmallest(int[][] matrix, int k) {
		int count = k - 1;
		int i = 0, j = 0;
		while (count > 0) {
			if (j < matrix[0].length - 1) {

			}
			
			if (i < matrix.length - 1) {
				if (matrix[i][j + 1] < matrix[i + 1][0]) {
					j++;
				} else {
					i++;
					j = 0;
				}
			}
			count--;
		}

		return matrix[i][j];
	}
}
