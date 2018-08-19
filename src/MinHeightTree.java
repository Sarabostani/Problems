import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeightTree {
	public static void run() {
		int[][] edges1 = new int[][] {{1, 0}, {1, 2}, {1, 3}};
		
		assert findMinHeightTrees(0, edges1).contains(1) : "should've been true";
	}
	
	private static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		// build the adjacency list
		
		for (int i = 0 ; i < edges.length; i++) {
			if (!adjList.containsKey(edges[i][0])) {
				adjList.put(edges[i][0], new ArrayList<Integer>());
			}
			
			if (!adjList.containsKey(edges[i][1])) {
				adjList.put(edges[i][1], new ArrayList<Integer>());
			}
			
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}
		
		List<Integer> minHeights = new ArrayList<>();
		
		minHeights.add(height(adjList, 0, new ArrayList<>()));
		return minHeights;
	}
	
	private static int height(Map<Integer, List<Integer>> adjList, int root, List<Integer> visited) {
		int height = 0;
		for (int n : visited) {
			if (!adjList.containsKey(root) || adjList.get(root).size() == 0) {
				return 0;
			}
			if (adjList.get(root).contains(n)) {
				return 1;
			}			
			visited.add(root);
			height += height(adjList, n, visited);
		}
		
		return height;
	}
}
