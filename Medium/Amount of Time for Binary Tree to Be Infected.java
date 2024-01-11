class Solution {
    public int amountOfTime(TreeNode root, int start) {
        int[] res = new int[]{0};
        dfs(root, start, res);
        return res[0];
    }
    
    private int dfs(TreeNode root, int start, int[] res) {
        if (root == null) return 0;
        int left = dfs(root.left, start, res);
        int right = dfs(root.right, start, res);
        if (root.val == start) { // 1. base case
            int temp = Math.max(Math.abs(left), Math.abs(right));
            res[0] = Math.max(res[0], temp);
            return 0;
        }
        if (left > 0 || (root.left != null && root.left.val == start)) {
            int sum = left + Math.abs(right) + 1;
            res[0] = Math.max(res[0], sum);
            return left + 1;
        } else if (right > 0 || (root.right != null && root.right.val == start)) {
            int sum = right + Math.abs(left) + 1;
            res[0] = Math.max(res[0], sum);
            return right + 1;
        } 
        int sum = Math.max(Math.abs(left), Math.abs(right));
        return -sum - 1;
    }
}
