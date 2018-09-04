import java.util.Arrays;

public class LargestIncreasingSubseq {

	public static void run() {
		int[] nums1 = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[] nums2 = { 10, 9, 2, 5, 3, 4 };
		int[] nums3 = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
		int[] nums4 = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		System.out.println(lengthOfLIS(nums1));
		System.out.println(lengthOfLIS(nums2));
		System.out.println(lengthOfLIS(nums3));
		System.out.println(lengthOfLIS(nums4));
		System.out.println(lengthOfLIS(new int[] { 0 }));
	}

	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];

		int count = 1;
		int max = 0;
		int curmax = 0;
		for (int i = 0; i < nums.length; i++) {
			count = 1;
			curmax = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dp[j] > curmax) {
					count = 1 + dp[j];
					curmax = dp[j];
				}
			}
			dp[i] = count;
			if (count > max) {
				max = count;
			}
		}
		
		return max;
	}
}
