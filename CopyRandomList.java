import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



public class CopyRandomList {

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            // mapping old Node to new coppied Node
            HashMap<Node, Node> mapToNew = new HashMap<>();

            // traverse the old Node and map each node with a new Node.
            Node curr = head;
            while (curr != null) {
                mapToNew.put(curr, new Node(curr.val));
                curr = curr.next;
            }

            // Adding next and random node to the new copied Node
            curr = head;
            while (curr != null) {
                // mapToNew.get(curr) will get the new created Node.
                mapToNew.get(curr).next = mapToNew.get(curr.next);
                mapToNew.get(curr).random = mapToNew.get(curr.random);
                curr = curr.next;
            }

            return mapToNew.get(head);

        }
    }

    public static void main(String[] args) {

    }
}
