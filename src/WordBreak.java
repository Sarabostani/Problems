import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
	public static void run() {
		List<String> dict = Arrays.asList(new String[] {"leet", "code"});
		assert wordBreak("leetcode", dict) == true;
		dict = Arrays.asList(new String[] {"aaaa", "aaa"});
		assert wordBreak("aaaaaaa", dict) == true;
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break; // next i
				}
			}
		}
		
		return dp[s.length()];
	}
}
