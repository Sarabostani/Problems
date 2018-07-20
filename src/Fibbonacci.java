public class Fibbonacci {
	public static void run() {
		// x_i = x_i-1 + x_i-2
		int n = 40;
		long startTime = System.currentTimeMillis();
		System.out.println(fibonacci(n));
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Executed in %d milliseconds", endTime - startTime));

		startTime = System.currentTimeMillis();
		System.out.println(dpFib(n, new int[n]));
		endTime = System.currentTimeMillis();
		System.out.println(String.format("DP executed in %d milliseconds", endTime - startTime));

	}

	private static int fibonacci(int n) {
		if (n <= 2) {
			return 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private static int dpFib(int n, int[] record) {
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
