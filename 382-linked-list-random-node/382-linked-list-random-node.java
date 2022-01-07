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
    
    private Random random = new Random();
    private ListNode node;

    public Solution(ListNode head) {
        node = head;
    }
    
    public int getRandom() {
        int result = -1;
        ListNode temp = node;
        for (int i = 1; temp != null; i++) {
            if (random.nextInt(i) == i-1)
                result = temp.val;
            temp = temp.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */