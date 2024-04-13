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
    public TreeNode flatten(TreeNode root) {

        helper(root);

        System.out.println(arr);

        for(int i = 0;i<arr.size()-1;i++){
            arr.get(i).right = arr.get(i+1);
            arr.get(i).left = null;
        }

        arr.get(arr.size()-1).right = null;

        return arr.get(0);
    }

    public static List<TreeNode> arr = new ArrayList<>();

    public static void helper(TreeNode node){
        
        if(node == null){
            return;
        }
 
        System.out.print(node.val+" ");
        arr.add(node);
        helper(node.left);        
        helper(node.right);

    }
}
