import java.util.Arrays;

public class LongestPalindrome {
	public static void run() {
		assert isPalindrome("bab", 0, 2);
		assert longestPalindrome("babad").equals("bab");
		assert longestPalindrome("acbbdad").equals("dad");
		assert longestPalindrome("abacdcbaacaaebad").equals("aacaa");
		assert longestPalindrome("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd").
		equals("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
		assert longestPalindrome("").equals("");
	}

	private static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		
		if (isPalindrome(s, 0, s.length() - 1)) {
			return s;
		}

		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (i != j && dp[i][j] == 0 && isPalindrome(s, i, j)) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = -1;
				}
			}
		}
		
		int maxDistance = Integer.MIN_VALUE;
		int low = 0, high = 0;

		for (int i = 0; i < dp.length; i++) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (dp[i][j] == 1 && j - i > maxDistance) {
					low = i;
					high = j;
					maxDistance = j - i;
				}
			}
		}

		return s.substring(low, high + 1);
	}

	private static boolean isPalindrome(String s, int i, int j) {
		if (i > j) {
			return true;
		}
		
		if (s.charAt(i) != s.charAt(j)) {
			return false;
		}
		
		return isPalindrome(s, i + 1, j - 1);
	}
}
