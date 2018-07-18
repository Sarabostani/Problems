import java.util.HashSet;
import java.util.Set;

public class PairsOfSum {
	private Set<String> entries;
	
	public void run(int[] nums, int sum) {
		entries = new HashSet<String>();
		printPairs(nums, 0, 1, sum);
		for (String entry: entries) {
			System.out.println(entry);
		}
	}

	private void printPairs(int[] nums, int prevIndex, int index, int sum) {
		if (index == nums.length || prevIndex == nums.length || prevIndex >= index) {
			return;
		}
		String pairs = String.format("(%d, %d)", nums[prevIndex], nums[index]);
		if (entries.contains(pairs)) {
			return;
		}
		if (nums[prevIndex] + nums[index] == sum) {
			entries.add(pairs);
			return;
		}

		printPairs(nums, prevIndex + 1, index + 1, sum);
		printPairs(nums, prevIndex, index + 1, sum);
		printPairs(nums, prevIndex + 1, index, sum);

	}

}
