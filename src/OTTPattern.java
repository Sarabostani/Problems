
public class OTTPattern {
	public static void run() {

		assert find132pattern(new int[] { 1, 2, 3, 4 }) == false;
		assert find132pattern(new int[] { 3, 1, 4, 2 }) == true;
		assert find132pattern(new int[] { -1, 3, 2, 0 }) == true;
		assert find132pattern(new int[] { 1, 3, 2 }) == true;
		assert find132pattern(new int[] { 1, 2, 2 }) == false;
		assert find132pattern(new int[] { 1, 0, 1, -4, -3 }) == false;
		assert find132pattern(new int[] { 3, 5, 0, 3, 4 }) == true;
	}

	public static boolean find132pattern(int[] nums) {
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i - 1] < nums[i + 1] && nums[i] > nums[i + 1]) {
				return true;
			}
		}

		return false;
	}
}
