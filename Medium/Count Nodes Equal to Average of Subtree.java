class Solution {
    private int averageEqualsValueNodes = 0;

    public int averageOfSubtree(TreeNode root) {
        sumAndCount(root);
        return averageEqualsValueNodes;
    }


    private SumAndCount sumAndCount(TreeNode node) {
        if (node == null) return new SumAndCount(0, 0);

        SumAndCount left = sumAndCount(node.left);
        SumAndCount right = sumAndCount(node.right);

        int sum = left.sum() + right.sum() + node.val;
        int count = left.count() + right.count() + 1;

        if (sum / count == node.val)
            averageEqualsValueNodes++;

        return new SumAndCount(sum, count);
    }

    private record SumAndCount(int sum, int count) {}
}
