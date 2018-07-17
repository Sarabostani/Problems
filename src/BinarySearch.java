
public class BinarySearch {
	public static void run() {
		System.out.println(search(new int[] {-1,0,3,5,9,12}, -1));
	}

	private static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int mid = (high - low)/2;
		
		while (high > low) {
			if (nums[low] == target) {
				return low;
			}
			if (nums[high] == target) {
				return high;
			}
			if (nums[mid] == target) {
				return mid;
			}
			else if (target > nums[mid]) {
				low = mid;
			}
			else {
				high = mid;
			}
			
			mid = low + (high - low)/2;
		}
		
		return -1;
	}
}
