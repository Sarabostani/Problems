
public class MaximumTree {

    public static void Run() {
        TreeNode root = constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
        TreeNode.preOrderTraverse(root);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int[] leftArray = new int[maxIndex];
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = nums[i];
        }

        int[] rightArray = new int[nums.length - maxIndex - 1];
        for (int i = 0, j = maxIndex + 1; j < nums.length; i++, j++) {
            rightArray[i] = nums[j];
        }

        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(leftArray);
        root.right = constructMaximumBinaryTree(rightArray);

        return root;

    }

}
