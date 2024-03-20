/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  class SwapPairs_Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode secondNode = head.next;
        ListNode thirdNode = secondNode.next;

        secondNode.next = head;
        head.next = swapPairs(thirdNode);

        return secondNode;
    }
}

public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs_Solution solutio = new SwapPairs_Solution();

        //test
    }
}

