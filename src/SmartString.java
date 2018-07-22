
public class SmartString {
	public static String reverse(String str, boolean recursive) {
		if (recursive) {
			return recReverse(str);
		}
		
		char[] buffer = new char[str.length()];
		int i = str.length() - 1;
		for (char c : str.toCharArray()) {
			buffer[i--] = c;
		}
		
		return new String(buffer);
	}
	
	private static String recReverse(String str) {
		// base case
		if (str.length() == 1) {
			return str;
		}
		// append the first char to the reverse of rest
		return recReverse(str.substring(1)) + str.charAt(0);
		
	}
	
	public static boolean areAnagrams(String str1, String str2) {
		// alphanumeric lower case strings
		str1 = str1.toLowerCase().trim().replace(" ", "");
		str2 = str2.toLowerCase().trim().replace(" ", "");
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] count1 = new int[255];
		int[] count2 = new int[255];
		for (char c : str1.toCharArray()) {
			count1[(int)c] += 1;
		}
		
		for (char c : str2.toCharArray()) {
			count2[(int)c] += 1;
		}
		
//		printCharCount(count1);
//		printCharCount(count2);
		
		for (int i = 0; i < 50; i++) {
			if (count1[i] != count2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPalindrome(String str) {
		if (str.length() <= 1) {
			return true;
		}
		
		return str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome(str.substring(1, str.length() - 1));
	}
	
	/*private static void printCharCount(int[] count) {
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				System.out.println(String.format("%c %d", i, count[i]));
			}
		}
	}*/
}
