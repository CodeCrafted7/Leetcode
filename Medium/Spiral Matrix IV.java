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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int mat[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(mat[i],-1);
        }
        int tr = 0,br = m-1,lc = 0,rc = n-1;

        while(head != null){

            for(int i=lc; i<=rc ;i++){
                if(head == null)
                    break;
                mat[tr][i] = head.val;
                head = head.next;
            }
            tr++;


            for(int i = tr;i<=br;i++){
                if(head == null)
                    break;
                mat[i][rc] = head.val;
                head = head.next;
            }
            rc--;

            for(int i=rc;i>=lc;i--){
                if(head == null)
                    break;
                mat[br][i] = head.val;
                head = head.next;
            }
            br--;

            for(int i = br; i>=tr ; i--){
                if(head == null)
                    break;
                mat[i][lc] = head.val;
                head = head.next;
            }
            lc++;
        }
        return mat;
    }
}
