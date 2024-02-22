class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode n, int x) {
        if (n == null) return 0;
        x = (x << 1) | n.val;
        if (n.left == null && n.right == null) return x;
        return dfs(n.left, x) + dfs(n.right, x);
    }
}
