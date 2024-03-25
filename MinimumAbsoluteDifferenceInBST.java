public class MinimumAbsoluteDifferenceInBST {
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
        int ans = 100000;
        int preVal = -1;

        void inorder(TreeNode root) {
            if (root == null) {
                return ;
            }
            inorder(root.left);
            if (preVal != -1) ans = Math.min(ans, root.val - preVal);
            preVal = root.val;
            inorder(root.right);
        }

        public int getMinimumDifference(TreeNode root) {
            inorder(root);
            return ans;
        }
    }
}
