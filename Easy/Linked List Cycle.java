public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fastptr = head;
        ListNode slowptr = head;
        while(fastptr != null && fastptr.next != null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if(slowptr == fastptr)
                return true;
        }
        return false;
    }
}
