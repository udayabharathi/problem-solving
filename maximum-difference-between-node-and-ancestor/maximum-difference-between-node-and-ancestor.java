/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private int result = 0;
    
    public int maxAncestorDiff(TreeNode root) {
        result = 0;
        maxAncestorDiff(root, root.val, root.val);
        return result;
    }
    
    private void maxAncestorDiff(TreeNode root, int currMax, int currMin) {
        if (root == null) {
            return;
        }
        result = Math.max(result, Math.max(Math.abs(root.val - currMax), Math.abs(root.val - currMin)));
        maxAncestorDiff(root.left, Math.max(currMax, root.val), Math.min(currMin, root.val));
        maxAncestorDiff(root.right, Math.max(currMax, root.val), Math.min(currMin, root.val));
    }
}