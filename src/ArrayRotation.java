
public class ArrayRotation {
	public static void run() {
		System.out.println(isRotated(new int[] {1, 2, 3, 4}, new int[] {3, 4, 1, 2}));
		System.out.println(isRotated(new int[] {1}, new int[] {3}));
		System.out.println(isRotated(new int[] {1}, null));
		System.out.println(isRotated(new int[] {1}, new int[] {}));
		System.out.println(isRotated(new int[] {1}, new int[] {1}));
		System.out.println(isRotated(new int[] {2,2,3}, new int[] {3,2,2}));
	}
	
	private static boolean isRotated(int[] arr1, int[] arr2) {
		// find the first index that matches, start comparing by rotation
		if (arr1 == null || arr2 == null || arr1.length != arr2.length || arr1.length == 0 || arr2.length == 0) {
			return false;
		}
		
		int j = 0;
		for (; j < arr2.length; j++) {
			if (arr2[j] == arr1[0]) {
				break;
			}
		}

		
		// in case first element of arr1 didn't match any element return false
		if (j == arr2.length || arr2[j] != arr1[0]) {
			return false;
		}
		
		// first element is a match, check other elements
		for (int i = 1; i < arr1.length; i++) {
			j = (j + 1) % arr2.length;
			if (arr1[i] != arr2[j]) {
				return false;
			}
		}
		
		return true;
	}
}
