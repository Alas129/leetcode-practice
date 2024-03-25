import javax.swing.tree.TreeNode;

public class FlattenBInaryTreeToLinkedlist {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        TreeNode ans;
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            ans = new TreeNode(root.val);
            TreeNode ans1 = ans;
            helper(root);

            root.left = null;
            root.right = ans1.right;

        }

        void helper(TreeNode root) {
            if (root == null) {
                return;
            }

            ans.val = root.val;
            if (root.left != null) {
                ans.right = new TreeNode();
                ans.left = null;
                ans = ans.right;
                helper(root.left);
            }
            if (root.right != null) {
                ans.right = new TreeNode();
                ans.left = null;
                ans = ans.right;
                helper(root.right);
            }
        }
    }
}
