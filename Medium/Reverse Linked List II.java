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
   public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        for(int i = 0;i<m-1;i++) pre = pre.next;
        ListNode start = pre.next;
        for(int i = 0;i<n-m;i++){
            ListNode then = start.next;
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
        }
        return dummy.next;
    }
}
