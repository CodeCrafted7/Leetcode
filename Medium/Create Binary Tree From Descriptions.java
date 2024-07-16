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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for(int dis[] : descriptions)
        {
            if(!map.containsKey(dis[0]))
                map.put(dis[0], new TreeNode(dis[0]));
            
            if(!map.containsKey(dis[1]))
                map.put(dis[1], new TreeNode(dis[1]));
            if(dis[2]==1)
                map.get(dis[0]).left = map.get(dis[1]);
            else
                map.get(dis[0]).right = map.get(dis[1]);
            set.add(dis[1]);
        }
        for(int dis[] : descriptions)
        {
            if(!set.contains(dis[0]))
                return map.get(dis[0]);
        }
        return null;
    }
}
