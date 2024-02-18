/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
      private Map<Integer, DataNode> map = new HashMap<>();
    
    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(root, x, y, null, 0);
        if (map.get(x).depth == map.get(y).depth && 
            map.get(x).parent != map.get(y).parent) return true;
        return false;
    }
    
    private void traverse(TreeNode root, int x, int y, Integer parent, int depth) {
        if (root == null || map.size() == 2) return;
        if (root.val == x || root.val == y) map.put(root.val, new DataNode(depth, parent));    
        traverse(root.left, x, y, root.val, depth + 1);
        traverse(root.right, x, y, root.val, depth + 1);
    }
    
    private static class DataNode {
        private int depth;
        private Integer parent;
        public DataNode(int depth, Integer parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }
}
