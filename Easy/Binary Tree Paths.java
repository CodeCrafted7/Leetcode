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
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null) {
        return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<String> path = new LinkedList<>();
    path.offer(root.val + "");
    queue.offer(root);
    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        String item = path.poll();
        if (cur.left == null && cur.right == null) {
            res.add(item);
        }
        if (cur.left != null) {
            queue.offer(cur.left);
            path.offer(item + "->" + cur.left.val + "");
        }
        if (cur.right != null) {
            queue.offer(cur.right);
            path.offer(item + "->" + cur.right.val + "");
        }
    }
    return res;
}
}
