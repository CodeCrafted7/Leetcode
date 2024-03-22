/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode ptr = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode nn = curr.next;
            curr.next = ptr;
            ptr = curr;
            curr  = nn;
        }
        head = ptr;
        return head;
    }
}
