//    URL: https://leetcode.com/problems/sort-list/
//    Given the head of a linked list, return the list after sorting it in ascending order.
//    Example1:
//    Input: head = [4,2,1,3]
//    Output: [1,2,3,4]
//    Example 2:
//    Input: head = [-1,5,3,4,0]
//    Output: [-1,0,3,4,5]
//    Example 3:
//    Input: head = []
//    Output: []

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // split list to two part
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // sort each part
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // merge
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }
}
