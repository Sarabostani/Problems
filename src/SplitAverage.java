import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitAverage {
	public static void run() {
		System.out.println(splitArraySameAverage(new int[] { 3, 6, 7 }));
		// System.out.println(splitArraySameAverage(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
	}

	private static boolean splitArraySameAverage(int[] A) {
		return avgRec(A, 1, -1, 0, 0);
	}
	
	private static boolean avgRec(int[] A, double target, int count, int sum, int index) {
		if (index == A.length) {
			return false;
		}
		
		double avg = (double)sum/count;
		if (avg == target) {
			return true;
		}
		
		return avgRec(A, avg, count, sum, index + 1) || avgRec(A, avg, count + 1, sum + A[index], index + 1);
	}
}
