import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindDuplicates {
	public static void Run() {
		List<Integer> list = Arrays.asList(4, 3, 2, 7, 8, 2, 3, 1);
		System.out.println(findDuplicates(list));
	}

	private static List<Integer> findDuplicates(List<Integer> nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 0);
			}
		}
		
		List<Integer> duplicates = new ArrayList<Integer>();
		for(Integer i : map.keySet()) {
			if(map.get(i) > 0) {
				duplicates.add(i);
			}
		}
		
		return duplicates;
	}
}
