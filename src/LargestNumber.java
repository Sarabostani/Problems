import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public static void run() {
		System.out.println(largestNumber(new int[] {5, 50, 54}));
		System.out.println(largestNumber(new int[] {0,0}));
		System.out.println(largestNumber(new int[] {1,1}));
		System.out.println(largestNumber(new int[] {999999998,999999997,999999999}));
	}

	private static String largestNumber(int[] nums) {
		String[] numbers = new String[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			numbers[i] = String.valueOf(nums[i] * 1);
		}
		
		Arrays.sort(numbers, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				long lval = Long.parseLong(arg0 + arg1);
				long rval = Long.parseLong(arg1 + arg0);
				
				return (int)(lval - rval) * -1;
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s : numbers) {
			sb.append(s);
		}
		
		// if all digits are zero, return zero
		String result = sb.toString();
		if (result.matches("[0]+")) {
			return "0";
		}
		
		return result;
	}

}
