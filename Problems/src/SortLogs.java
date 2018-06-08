import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortLogs {
	public static void Run() {
		String[] logs = {"al 9 2 3 1", "g1 Act car", "zo4 4 7", "abl off KEY dog", "a8 act zoo"};


		System.out.println(Arrays.toString(sortLogs(logs)));
	}

	private static String[] sortLogs(String[] logs) {
		List<String> sortedLogs = new ArrayList<String>();

		List<String> stringLogs = new ArrayList<String>();
		List<String> numberLogs = new ArrayList<String>();

		// categorize logs
		for (String log : logs) {
			if (isNumberLog(log)) {
				numberLogs.add(log);
			} else {
				stringLogs.add(log);
			}
		}

		String[] sortedStringLogs = sortStringLogs(stringLogs);
		for(String log : sortedStringLogs) {
			sortedLogs.add(log);
		}
		
		for(String log : numberLogs) {
			sortedLogs.add(log);
		}
		
		return sortedLogs.toArray(new String[sortedLogs.size()]);
	}

	private static String[] sortStringLogs(List<String> stringLogs) {
		String log1, id1, log2, id2 = "";
		String[] sortedLogs = stringLogs.toArray(new String[stringLogs.size()]);
		for(int i = 0; i < sortedLogs.length; i++) {
			id1 = sortedLogs[i].substring(0, sortedLogs[i].indexOf(" "));
			log1 = sortedLogs[i].substring(sortedLogs[i].indexOf(" "));
			for(int j = i + 1; j < sortedLogs.length; j++) {
				id2 = sortedLogs[j].substring(0, sortedLogs[j].indexOf(" "));
				log2 = sortedLogs[j].substring(sortedLogs[j].indexOf(" "));
				
				// both logs are the same
				if (log1.compareTo(log2) == 0) {
					if(id1.compareTo(id2) > 0) {
						swap(sortedLogs, i, j);
					}
				}
				
				else if(log1.compareTo(log2) > 0) {
					swap(sortedLogs, i, j);
				}
			}
		}
		
		return sortedLogs;
	}

	private static void swap(String[] logs, int i, int j) {
		String tmp = logs[i];
		logs[i] = logs[j];
		logs[j] = tmp;
	}

	private static boolean isNumberLog(String log) {
		String digitStr = log.substring(log.indexOf(" ")).replace(" ", "");
		for (char digit : digitStr.toCharArray()) {
			if (!Character.isDigit(digit)) {
				return false;
			}
		}

		return true;
	}
}
