class Solution {
    public int longestPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return longestPath;
    }
    
    public int longestPath(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lheight = longestPath(root.left);
        int rheight = longestPath(root.right);
        
        longestPath = Math.max(longestPath, lheight + rheight);
        
        return Math.max(lheight, rheight) + 1;
    }
}
