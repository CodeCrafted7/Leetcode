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
public class BSTIterator {

	private TreeNode curr;
    public BSTIterator(TreeNode root) {
		TreeNode prev;
		curr = root;
		while(curr != null){
			if(curr.left == null){
				curr = curr.right;
			}
			else{
				prev = curr.left;
				while(prev.right != null && prev.right != curr)
					prev = prev.right;

				if(prev.right == null){
					prev.right = curr;
					curr = curr.left;
				}
				else{
					curr = curr.right;
				}
			}
		}

		curr = root;
		while(curr != null && curr.left != null)
			curr = curr.left;
    }


    public boolean hasNext() {
		return curr != null;
    }
    
    public int next() {
		int result = curr.val;

		TreeNode next = curr.right;
		if(next == null)
			curr = next;
		else if(next.left == null || next.left.val > curr.val){
			curr = next;
			while(curr.left != null)
				curr = curr.left;
		}
		else{
			curr.right = null;
			curr = next;
		}

		return result;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
