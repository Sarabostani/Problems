import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Islands {
	public static void run() {
		int[][] mat = new int[][] { 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1 }, 
				{ 1, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };

		System.out.println(numIslands(mat));
	}

	private static int numIslands(int[][] mat) {
		Set<String> visited = new HashSet<String>();
		Map<String, List<String>> adjList = new HashMap<String, List<String>>();
		
		String template = "(%d,%d)";
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					continue;
				}
				
				// check all cells surrounding the current one and add it to the list
				List<String> adjacents = new ArrayList<String>();
				// right
				checkCell(i, j + 1, mat, adjacents);
				// right down
				checkCell(i + 1, j + 1, mat, adjacents);
				// down
				checkCell(i + 1, j, mat, adjacents);
				// left down
				checkCell(i + 1, j - 1, mat, adjacents);
				// left
				checkCell(i, j - 1, mat, adjacents);
				// left up
				checkCell(i - 1, j - 1, mat, adjacents);
				// up
				checkCell(i - 1, j, mat, adjacents);
				// up right
				checkCell(i - 1, j + 1, mat, adjacents);

				adjList.put(String.format(template, i, j), adjacents);
			}
		}
		
		// at this point adjacency list is created
		// printAdjList(adjList);
		int count = 0;
		for (String node : adjList.keySet()) {
			if (visited.contains(node)) {
				continue;
			}
			traverse(adjList, node, visited);
			count++;
		}
		
		return count;
	}
	
	private static void traverse(Map<String, List<String>> adjList, String head, Set<String> visited) {
		if (visited.contains(head)) {
			return;
		}
		
		if (adjList.get(head).size() == 0) {
			return;
		}
		
		visited.add(head);
		for (String node : adjList.get(head)) {
			if (visited.contains(node)) {
				continue;
			}
			traverse(adjList, node, visited);
		}
	}
	
	private static void printAdjList(Map<String, List<String>> adjList) {
		for (String key : adjList.keySet()) {
			StringBuilder sb = new StringBuilder();
			sb.append(key);
			sb.append(" -> { ");
			for (String adj : adjList.get(key)) {
				sb.append(adj);
			}
			sb.append(" }");
			System.out.println(sb.toString());
		}
	}

	private static void checkCell(int row, int col, int[][] mat, List<String> adjacents) {
		if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length) {
			return;
		}

		if (mat[row][col] == 1) {
			adjacents.add(String.format("(%d,%d)", row, col));
		}
	}
}
