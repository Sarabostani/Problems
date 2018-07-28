import java.util.Stack;

public class SimpleCalc {
	public static void run() {
		System.out.println(calculate("33+2*4"));
		System.out.println(calculate("4*2+3"));
		System.out.println(calculate("  3 / 2 * 4"));
		System.out.println(calculate("2*13 + 6"));
	}

	private static int calculate(String s) {
		Stack<Integer> nums = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		StringBuilder sb = new StringBuilder();
		boolean higherPrec = false;

		for (char c : s.toCharArray()) {
			if (c - '0' >= 0 && c - '0' <= 9) {
				sb.append(c);
			} else if (c == '-' || c == '+') {
				int n = Integer.parseInt(sb.toString());
				if (higherPrec) {
					highPrecCalc(nums, ops, sb);
					higherPrec = false;
				} else {
					nums.push(n);
				}
				sb.setLength(0);
				ops.push(c);
			} else if (c == '*' || c == '/') {
				if (higherPrec) {
					highPrecCalc(nums, ops, sb);
				}
				else {					
					higherPrec = true;
					nums.push(Integer.parseInt(sb.toString()));
					sb.setLength(0);
					ops.push(c);
				}
			}
		}

		if (sb.length() > 0) {
			nums.push(Integer.parseInt(sb.toString()));
		}

		while (!ops.empty()) {
			int a = nums.pop();
			int b = nums.pop();
			int op = ops.pop();
			if (op == '-') {
				nums.push(b - a);
			} else if (op == '+') {
				nums.push(a + b);
			}
			else if(op == '*') {
				nums.push(a * b);
			}
			else if (b != 0){
				nums.push(a / b);
			}
			else {
				nums.push(Integer.MAX_VALUE);
			}
		}

		return nums.peek();

	}
	
	private static void highPrecCalc(Stack<Integer> nums, Stack<Character> ops, StringBuilder sb) {
		int n = Integer.parseInt(sb.toString());
		int a = nums.pop();
		char op = ops.pop();
		if (op == '*') {
			nums.push(n * a);
		} else if (op == '/') {
			if (n != 0) {
				nums.push(a / n);
			}
		}
	}
}
