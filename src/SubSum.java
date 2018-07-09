
public class SubSum {
	public static void run() {
		System.out.println(findSum(new int[] {2, 4, 6, 10, 12}, 16));
	}
	
	private static int findSum(int[] array, int sum) {
		return recSum(array, sum, array.length - 1);
	}
	
	private static int recSum(int[] array, int sum, int index) {
		if (sum == 0) {
			return 1;
		}
		else if(sum < 0) {
			return 0;
		}
		else if (index < 0) {
			return 0;
		}
		
		// if sum is smaller than the current item, continue
		if (sum < array[index]) {
			return recSum(array, sum, index - 1);
		}
		
		return recSum(array, sum, index - 1) + recSum(array, sum - array[index], index - 1);
	}
}
