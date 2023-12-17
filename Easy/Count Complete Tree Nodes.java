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
   public int countNodes(TreeNode root) {
    TreeNode temp = root;
    int height = -1;
    while(temp != null) {
        height++;
        temp = temp.left;
    }
    return count(root, height);
}

public int count(TreeNode node, int depth) {
    if(node == null) {
        return 0;
    }
    TreeNode temp = node.right;
    int rightHeight = 0;
    while(temp != null) {
        rightHeight++;
        temp = temp.left;
    }
    if(rightHeight == depth) {
        return (1 << depth) + count(node.right, rightHeight - 1);
    } else {
        return (1 << (depth - 1)) + count(node.left, depth - 1);
    }
}
}
