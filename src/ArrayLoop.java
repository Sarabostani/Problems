
public class ArrayLoop {
	public static void run() {
		System.out.println(circularArrayLoop(new int[] {2, -1, 1, 2, 2}));
		System.out.println(circularArrayLoop(new int[] {-1, 2}));
	}

	private static boolean circularArrayLoop(int[] nums) {
		int i = 0;
		int j = 0;
		int loopTimes = 0;
		int tick = 0;
		/*
		 * i
		 * j       
		 * 2 -1 1 2 2
		 * 
		 * */
		while (loopTimes < 4) {
			if ( i == j && loopTimes > 0) {
				return true;
			}
			
			if (i + nums[i] >= 0) {
				i = (i + nums[i]) % nums.length;
			}
			else {
				i = Math.abs(nums.length + i + nums[i]) % nums.length;
			}
			
			if (tick % 2 == 1) {
				
			}
		}
		
		return false;
	}
}
