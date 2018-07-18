import java.util.Arrays;

public class KthLargest {
	int k;
	int[] nums;
	
	public static void run() {
		int[] arr = new int[] {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, arr);
		System.out.println(kthLargest.add(3));		   // returns 4
		System.out.println(kthLargest.add(5));   // returns 5
		System.out.println(kthLargest.add(10));  // returns 5
		System.out.println(kthLargest.add(9));   // returns 8
		System.out.println(kthLargest.add(4));   // returns 8
	}
	
	public KthLargest(int k, int[] nums) {
		Arrays.sort(nums);
		this.k = k;
		this.nums = nums;
	}

	public int add(int val) {
		int[] newNums = new int[nums.length+1];
		for (int i=0; i < nums.length; i++) {
			newNums[i] = nums[i];
		}
		newNums[nums.length] = val;
		Arrays.sort(newNums);
		
		nums = newNums;
		return nums[nums.length - k];
	}
}
