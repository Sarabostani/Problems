import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
	public static void run() {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		
		printIntervals(intervals);
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
		if (intervals.size() <= 1){
	        return intervals;
	    }
	    
	    List<Interval> merged = new ArrayList<Interval>();
	    if (intervals.size() == 2) {
	    	return mergeIntervals(intervals.get(0), intervals.get(1));
	    }
	    
	    merged.addAll(merge(intervals.subList(0, intervals.size()/2)));
	    merged.addAll(merge(intervals.subList(intervals.size()/2, intervals.size())));
	    
	    return merged;
	}
	
	private static List<Interval> mergeIntervals(Interval a, Interval b){
		List<Interval> merged = new ArrayList<Interval>();
		// if there is overlap, merge based on value
		
		if ((a.start <= b.start && a.end >= b.start) || (b.start <= a.start && b.end >= a.start)) {
			merged.add(new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end)));
		}
    	
    	else {
    		merged.add(a);
    		merged.add(b);
    	}
		
		return merged;
	}
}
