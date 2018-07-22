
public class LocalMinima {
	public static void run() {
		allLocalMinima(new int[] { 9, 8, 5, 6, 10, 12, 9, 5, 3, 6, 16, 20 });
	}

	private static void allLocalMinima(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 && i + 1 < arr.length) {
				if (arr[i] < arr[i+1]) {
					sb.append(arr[i]);
					sb.append(" ");
				}
			}
			else if (i > 0 && i + 1 < arr.length && arr[i - 1] > arr[i] && arr[i] < arr[i+1]) {
				sb.append(arr[i]);
				sb.append(" ");
			}
			else if (i - 1 > 0 && i == arr.length - 1 && arr[i] < arr[i-1] ) {
				sb.append(arr[i]);
			}
		}
		
		System.out.println(sb.toString());
	}
}
