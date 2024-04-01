import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    /**
     * Definition for a binary tree node.
     **/
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            List<Integer> path = new ArrayList<>();
            dfs(root, targetSum, 0, path, result);
            return result;
        }

        private void dfs(TreeNode node, int targetSum, int currentSum, List<Integer> path, List<List<Integer>> result) {
            if (node == null) {
                return;
            }

            currentSum += node.val;
            path.add(node.val);

            if (node.left == null && node.right == null) {
                if (currentSum == targetSum) {
                    result.add(new ArrayList<>(path));
                }
            } else {
                dfs(node.left, targetSum, currentSum, path, result);
                dfs(node.right, targetSum, currentSum, path, result);
            }

            path.remove(path.size() - 1);
        }
    }
}
