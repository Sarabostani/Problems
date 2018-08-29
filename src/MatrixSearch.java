
public class MatrixSearch {
	public static void run() {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(searchMatrix(matrix, 5));
		System.out.println(searchMatrix(matrix, 20));
		System.out.println(searchMatrix(new int[][] { { 1, 2, 3 } }, -1));
		System.out.println(searchMatrix(new int[][] { { 1 }, {2} , {3} } , 2));
		System.out.println(searchMatrix(new int[][] {} , 2));
		System.out.println(searchMatrix(new int[][] {{}} , 2));
		System.out.println(searchMatrix(new int[][] {{-5}} , -5));
		System.out.println(searchMatrix(new int[][] {{2}, {4}} , 4));
		System.out.println(searchMatrix(new int[][] {{-1}, {-1}} , -1));
		System.out.println(searchMatrix(new int[][] {{55}, {6}} , 6));
		System.out.println(searchMatrix(new int[][] {{1,4}, {2,5}} , 2));
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0] == null) {
			return false;
		}
		
		if (matrix.length == 1 && matrix[0].length == 0) {
			return false;
		}
		
		int ax = 0, bx = matrix[0].length > 0 ? matrix[0].length - 1 : 0;
		int midx = (bx + ax) / 2;
		int ay = 0, by = matrix.length > 0 ? matrix.length - 1 : 0;
		int midy = (by + ay) / 2;
		
		if (matrix[0].length == 1) {
			if (target == matrix[ay][0] || target == matrix[by][0] || target == matrix[midy][0]) {
				return true;
			}
			while (by - ay > 1) {
				if (target == matrix[ay][0] || target == matrix[by][0] || target == matrix[midy][0]) {
					return true;
				}
				
				if (target < matrix[midy][0]) {
					by = midy;
					midy = (ay + by)/2;
				}
				
				if (target > matrix[midy][0]) {
					ay = midy;
					midy = (ay + by)/2;
				}
			}
			
			return false;
		}
		
		if (target == matrix[midy][midx] || target == matrix[ay][ax] || target == matrix[ay][bx] ||
				target == matrix[by][ax] || target == matrix[by][bx]) {
			return true;
		}
		
		while(bx - ax > 1 || by - ay > 1) {
			if (target == matrix[midy][midx] || target == matrix[ay][ax] || target == matrix[ay][bx] ||
					target == matrix[by][ax] || target == matrix[by][bx]) {
				return true;
			}
			
			if (target < matrix[midy][midx]) {
				bx = midx;
				by = midy;
			}
			
			if (target > matrix[midy][midx]) {
				ax = midx;				
				ay = midy;
			}
			
			midx = (bx + ax)/2;
			midy = (by + ay)/2;
		}
		return false;
	}
}
