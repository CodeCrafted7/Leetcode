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
    public TreeNode dfs(TreeNode root,HashSet<Integer> dl,List<TreeNode> forest){
        if(root==null)
            return root;
        root.left = dfs(root.left,dl,forest);
        root.right = dfs(root.right,dl,forest);
        if(!dl.contains(root.val))
            return root;

        if(root.left!=null)
            forest.add(root.left);

        if(root.right!=null)
            forest.add(root.right);

        root.left=null;
        root.right=null;
        return null;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: to_delete)
            set.add(i);
        List<TreeNode> forest = new ArrayList<>();
        root = dfs(root,set,forest);
        if(root!=null)
            forest.add(root);
        return forest;
    }
}
