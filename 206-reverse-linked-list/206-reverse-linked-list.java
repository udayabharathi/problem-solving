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
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next; // null (prev) X 1 (head) -> 2 (head.next / temp) -> 3 -> ...
            head.next = prev; // null (head.next / prev) <- 1 (head) X 2 (temp) -> 3 -> ...
            prev = head; // null (head.next) <- 1 (head / prev) X 2 (temp) -> 3 -> ...
            head = temp; // null <- 1 (prev) X 2 (head) -> 3 (head.next) -> ...
        }
        return prev;
    }
}