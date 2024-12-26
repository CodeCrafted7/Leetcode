class Solution {
    static Integer[] largest = new Integer[10_001];
    int largestIdx = 0;
    
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return Arrays.asList(Arrays.copyOf(largest, largestIdx));
    }
    private void dfs(TreeNode node, int level) {
        if (node == null)  return;
        if (level >= largestIdx) {
            largestIdx = level + 1;
            largest[level] = node.val;
        } else
            largest[level] = Math.max(largest[level], node.val);
        dfs(node.left,  level + 1);
        dfs(node.right, level + 1);
    }
}
