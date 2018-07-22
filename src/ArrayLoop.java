
public class ArrayLoop {
	public static void run() {
		System.out.println(circularArrayLoop(new int[] {2, -1, 1, 2, 2}));
		System.out.println(circularArrayLoop(new int[] {-1, 2}));
	}

	private static boolean circularArrayLoop(int[] nums) {
		int i = 0;
		int j = nums[0];
		
		while (i != j) {
			if ( i == j ) {
				return true;
			}
			
			if (i + nums[i] >= 0) {
				i = (i + nums[i]) % nums.length;
			}
			else {
				i = Math.abs(nums.length + i + nums[i]) % nums.length;
			}
		}
		
		return false;
	}
}
