import java.util.Arrays;

public class JumpGame {
	public static void run() {
		System.out.println(canJump(new int[] {2,3,1,1,4}));
		System.out.println(canJump(new int[] {3,2,1,0,4}));
		System.out.println(canJump(new int[] {0}));
		System.out.println(canJump(new int[] {2,0}));
	}
	
	private static enum Index{
		GOOD, BAD, UNKNOWN
	}
	private static boolean canJump(int[] nums) {
		Index[] status = new Index[nums.length];
		Arrays.fill(status, Index.UNKNOWN);
		int leftMostGood = status.length - 1;
		status[status.length - 1] = Index.GOOD;
		for (int i = status.length - 2 ; i >= 0; i--) {
			if (nums[i] >= leftMostGood - i) {
				status[i] = Index.GOOD;
				leftMostGood = i;
			}
			else {
				status[i] = Index.BAD;
			}
		}
		
		return status[0] == Index.GOOD ? true : false;
	}
	

}
