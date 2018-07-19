
public class DividendDivisor {
	public static void run() {
		System.out.println(divide(12, 2));
		System.out.println(divide(-8, 2));
		System.out.println(divide(-8, -5));
		System.out.println(divide(11, 5));
		System.out.println(divide(1, 1));
		System.out.println(divide(800, 200));
		System.out.println(divide(-2147483648, -1));
		System.out.println(divide(-2147483648, 1));
	}

	private static int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		
		int sign = 1;
		if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
			sign = 1;
		}
		else {
			sign = -1;
		}
		
		divisor = Math.abs(divisor);
		dividend = Math.abs(dividend);
		int max = Integer.MAX_VALUE;
		
		
		if (divisor == 1) {
			if (dividend - 1 >= max) {
				return (sign == 1 ? max : max + 1);
			}
			
			return dividend * sign;
		}
		
		if (dividend < divisor) {
			return 0;
		}
		
		int rem = dividend;
		int multiples = 0;
		
		while (rem >= divisor) {
			rem -= divisor;
			multiples++;
		}
		
		return multiples * sign;
	}
}
