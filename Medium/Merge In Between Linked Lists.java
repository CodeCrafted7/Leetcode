class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPrev = list1;
        int i = 0;
        while (i < a-1) {
            aPrev = aPrev.next;
            i++;
        }
        ListNode bNext = list1;
        int j = 0;
        while (j <= b) {
            bNext = bNext.next;
            j++;
        }

        ListNode temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }

        aPrev.next = list2;
        temp.next = bNext;

        return list1;
    }
}
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
