
public class ItoB {
	public static void run() {
		System.out.println(toBinary(7));
		System.out.println(toBinary(2));
		System.out.println(toBinary(11));
		System.out.println(toBinary(131));
	}
	
	private static String toBinary(int n) {
		if (n == 1) {
			return "1";
		}
		if (n == 0) {
			return "0";
		}
		
		int num = n;
		StringBuilder sb = new StringBuilder();
		while (num >= 2) {
			sb.append(num % 2);
			num /= 2;
		}
		
		sb.append(num);
		return sb.reverse().toString();
	}
}
