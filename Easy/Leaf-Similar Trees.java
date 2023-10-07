class Solution {
    public static ArrayList<Integer> preorder(ArrayList<Integer> list, TreeNode root){
        if(root == null) return list;
        
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        else{
        list = preorder(list, root.left);
        list = preorder(list, root.right);
        }
        return list;
    } 
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1= preorder(list1, root1);
        list2= preorder(list2, root2);
        return list1.equals(list2);
    }
}
