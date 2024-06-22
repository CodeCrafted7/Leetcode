/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> l = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root==null)
        {
            return l;
        }
        q.add(root);
        while(q.isEmpty()==false)
        {
            int count = q.size();
            ArrayList<Integer> a = new ArrayList<>();
            while(count!=0)
            {
                Node curr = q.remove();
                a.add(curr.val);
                for(int i=0;i<curr.children.size();i++)
                {
                    q.add(curr.children.get(i));
                }
                --count;
            }
            l.add(a);
        }
        return l;
    }
}
