class Solution {
    static String str = "";
    
    public String tree2str(TreeNode root) {
        str="";
        help(root);
        return str;
    }
    
    public static void help(TreeNode root){
        if(root==null) return;
        str+=root.val;
        if(root.left != null || root.right!=null){
            str+='(';
            help(root.left);
            str+=')';
        }
        if(root.right!=null){
            str+='(';
            help(root.right);
            str+=')';
        }
    }
}
