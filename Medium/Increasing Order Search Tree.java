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
    
       static TreeNode temp=null;
       static TreeNode newroot=null;
    
    public TreeNode increasingBST(TreeNode root) {
        temp=null;
        
        inorder(root);
        
        return newroot;    
      }
    
    public static void inorder(TreeNode root){
        
        if(root==null) return;
        
        inorder(root.left);
        
        if(temp==null){
            TreeNode nn=new TreeNode(root.val);
            temp=nn;
            newroot=nn;
        }else{
            TreeNode nn1=new TreeNode(root.val);
            temp.right=nn1;
            temp=nn1;
        }
        
        inorder(root.right);
        
    }
}
