public class Fibbonacci {
	public static void run(boolean dp) {
		// x_i = x_i-1 + x_i-2
		int n = 70;
		long startTime, endTime;
		if (dp) {
			startTime = System.currentTimeMillis();
			System.out.println(dpFib(n, new long[n]));
			endTime = System.currentTimeMillis();
			System.out.println(String.format("DP executed in %d milliseconds", endTime - startTime));			
		}
		else {			
			startTime = System.currentTimeMillis();
			System.out.println(fibonacci(n));
			endTime = System.currentTimeMillis();
			System.out.println(String.format("Executed in %d milliseconds", endTime - startTime));
		}


	}

	private static long fibonacci(int n) {
		if (n <= 2) {
			return 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private static long dpFib(int n, long[] record) {
		if (n <= 2) {
			record[n - 1] = 1;
			return 1;
		}

		if (record[n - 1] > 0) {
			return record[n - 1];
		}

		record[n - 1] = dpFib(n - 1, record) + dpFib(n - 2, record);
		return record[n - 1];
	}
}
