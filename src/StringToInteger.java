
public class StringToInteger {
	public static void run() {
		System.out.println(myAtoi("-234 hi"));
		System.out.println(myAtoi(""));
		System.out.println(myAtoi("    "));
		System.out.println(myAtoi("   -42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("3.21"));
		System.out.println(myAtoi(".21"));
		System.out.println(myAtoi("  -0012a42"));
		
	}

	private static int myAtoi(String str) {
		str = str.trim();
		if (str.equals("")) {
			return 0;
		}
		str = str.split(" ")[0];
		if (str.contains(".")) {
			str = str.split("\\.")[0];
		}
		if (!isNum(str) || str.equals("")) {
			return 0;
		}
		
		char[] reversed = reverse(str);
		
		long number = 0;
		int exp = 0;
		
		for (char c : reversed) {
			number += (c - '0') * Math.pow(10, exp++);
			if (number >= Integer.MAX_VALUE) {
				number = Integer.MAX_VALUE + 1;
				break;
			}
		}
		
		return ( str.charAt(0) == '-' ? (int)-number : (int)number );
	}
	
	private static boolean isNum(String str) {
		if (str.length() == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			i++;
		}
		
		for (; i < str.length(); i++) {
			if (!isNumChar(str.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	private static char[] reverse(String str) { 
		char[] reversed = new char[( str.charAt(0) == '-' || str.charAt(0) == '+' ? str.length() - 1: str.length())];
		int i = reversed.length - 1;
		for (char c : str.toCharArray()) {
			if (c == '-' || c == '+') {
				continue;
			}
			reversed[i--] = c;
		}
		
		return reversed;
	}
	
	private static boolean isNumChar(char c) {
		return c >= '0' && c <= '9';
	}
}
