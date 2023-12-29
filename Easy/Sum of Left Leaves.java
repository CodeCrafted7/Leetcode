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
    public int sumOfLeftLeaves(TreeNode root) {
    if(root==null)return 0;
    int[] my=new int[1];
    
    leftLeaf(root,my);
    
   return my[0];
    
}

public void leftLeaf(TreeNode root,int[] arr){
   
    if(root.left!=null && isLeaf(root.left)){
        
        arr[0]+=root.left.val;
    }
    if(root.left!=null)leftLeaf(root.left,arr);
    if(root.right!=null)leftLeaf(root.right,arr);
    
}
public boolean isLeaf(TreeNode root){
    return root.left==null && root.right==null;
}
}
