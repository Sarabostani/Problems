public class SplitAverage {
	public static void run() {
		// System.out.println(splitArraySameAverage(new int[] { 3, 6, 7 }));
		// System.out.println(splitArraySameAverage(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
		System.out.println(splitArraySameAverage(new int[] { 3, 6, 5 }));
	}

	private static boolean splitArraySameAverage(int[] A) {
//		return avgRec(A, 5.5, 0, 0, A.length - 1);
		return subAvg(A, 5.5, 0, 0, A.length - 1, new int[] {2});
	}
	
	private static boolean subAvg(int[] A, double avg, int count, int sum, int index, int[] skip) {
		if (count > 0 && (double)sum/count == avg) {
			return true;
		}
		
		if (index < 0) {
			return false;
		}
		
		for (int i : skip) {
			if (i == index) {
				return subAvg(A, avg, count, sum, index - 1, skip);
			}
		}
		
		return subAvg(A, avg, count, sum, index - 1, skip) || subAvg(A, avg, count + 1, sum + A[index], index - 1, skip);
	}
}
