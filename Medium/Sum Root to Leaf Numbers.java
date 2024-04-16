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
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return sum + root.val;
        
        return sumNumbers(root.left, (sum + root.val) * 10) + sumNumbers(root.right, (sum + root.val) * 10);
        
    }
}
