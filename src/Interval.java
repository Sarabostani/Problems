import java.util.List;

public class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString() {
		return String.format("[%d, %d]", start, end);
	}
	
	boolean equals(Interval a){
		return a.start == start && a.end == end;
	}
	
	static boolean equals(Interval a, Interval b) {
		return a.start == b.start && a.end == b.end;
	}
	
	static boolean areEqualIntervals(List<Interval> int1, List<Interval> int2) {
		if (int1.size() != int2.size()) return false;
		
		for (int i = 0 ; i < int1.size(); i++) {
			if (!Interval.equals(int1.get(i), int2.get(i))) {
				return false;
			}
		}
		
		return true;
	}
	
}
