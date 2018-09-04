import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public static void run() {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		
		List<Interval> merged = merge(intervals);
		printIntervals(merged);
		
		List<Interval> intervals2 = new ArrayList<Interval>();
		intervals2.add(new Interval(1,3));
		intervals2.add(new Interval(2,6));
		printIntervals(merge(intervals2));
		
		List<Interval> intervals3 = new ArrayList<Interval>();
		intervals3.add(new Interval(1,4));
		intervals3.add(new Interval(2,3));
		printIntervals(merge(intervals3));
		
		intervals3.add(new Interval(2,6));
		intervals3.add(new Interval(2,6));
		printIntervals(merge(intervals3));
	}
	
	private static void printIntervals(List<Interval> intervals) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Interval i : intervals) {
			sb.append("[");
			sb.append(i.start);
			sb.append(",");
			sb.append(i.end);
			sb.append("]");
		}
		sb.append("]");
		
		System.out.println(sb.toString());
	}
	
	private static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1) {
			return intervals;
		}
		Interval[] intervalsArray = new Interval[intervals.size()];
		intervals.toArray(intervalsArray);
		
		Arrays.sort(intervalsArray, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		
		List<Interval> merged = new ArrayList<Interval>();
		Interval current = intervalsArray[0];
		for (int i = 1; i < intervalsArray.length; i++) {
			Interval next = intervalsArray[i];
			
			if (current.end >= next.start) {
				if (current.end >= next.end)
					current = new Interval(current.start, current.end);
				else
					current = new Interval(current.start, next.end);
					
			}
			else {
				merged.add(current);
				current = next;
			}			
		}
		
		merged.add(current);
		
		return merged;
	}
}
