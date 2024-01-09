class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum=0;
        if(root==null)
            return sum;
        if(root.val>=low && root.val<=high)
            sum+=root.val;
        
        sum+=rangeSumBST(root.left,low,high);
        sum+=rangeSumBST(root.right,low,high);

        return sum;
    }
}
