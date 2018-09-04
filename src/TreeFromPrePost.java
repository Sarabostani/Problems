import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeFromPrePost {
	public static void run() {
		constructFromPrePost(new int[] {1,2,4,5,3,6,7} , new int[] {4,5,2,6,7,3,1});
	}

	private static TreeNode constructFromPrePost(int[] pre, int[] post) {
		if (pre.length == 0) {
			return null;
		}
		
		return construct(pre, post, 0, post.length - 1);
	}
	
	private static TreeNode construct(int[] pre, int[] post, int i, int j) {
		if (i >= pre.length) {
			return null;
		}
		
		TreeNode root = new TreeNode(pre[i]);
		if (i >= j) {
			return root;
		}
		
		// size of the left branch
		int L = Arrays.asList(post).indexOf(pre[i + 1]) + 1;
		
		root.left = construct(pre, post, i + L, j + L);
		root.right = construct(pre, post, i + L + 1, j + 1);
		
		return root;
		
	}
}
