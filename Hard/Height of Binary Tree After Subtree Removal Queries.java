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
    int max;
    public int[] treeQueries(TreeNode root, int[] q) {
        int left[] = new int[100001];
        int right[] = new int[100001];
        max=0;
        leftheight(root,left,0);
        max=0;
        rightheight(root,right,0);
        for(int i=0;i<q.length;i++){
            q[i] = Math.max(left[q[i]], right[q[i]]);
        }
        return q;
    }
    public void leftheight(TreeNode root,int left[], int d){
        if(root == null) return;
        left[root.val] = max;
        max = Math.max(max,d);
        leftheight(root.left,left,d+1);
        leftheight(root.right,left,d+1);
    }
    public void rightheight(TreeNode root,int right[], int d){
        if(root == null) return;
        right[root.val] = max;
        max = Math.max(max,d);
        rightheight(root.right,right,d+1);
        rightheight(root.left,right,d+1);
    }
}
