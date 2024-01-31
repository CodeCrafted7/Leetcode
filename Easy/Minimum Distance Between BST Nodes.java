class Solution {
public int minDiffInBST(TreeNode root) {
	int[] minDiff = {Integer.MAX_VALUE};
	inorder(root, minDiff, new int[]{-1});
	return minDiff[0];
}

private void inorder(TreeNode root, int[] minDiff, int[] prev) {
	if (root == null)
		return;
	inorder(root.left, minDiff, prev);
	if (prev[0] != -1)
		minDiff[0] = Math.min(minDiff[0], root.val - prev[0]);
	prev[0] = root.val;
	inorder(root.right, minDiff, prev);
}
};
