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
        ListNode curr = head;
        ListNode prv = null;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next =  prv;
            prv = curr;
            curr = temp;
        } 
        return prv ;
    }
}