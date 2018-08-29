import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static void preOrderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	
	public static void levelTraverse(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			if (node != null) {				
				System.out.print(node.val + " ");
				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
			}
		}
	}
}