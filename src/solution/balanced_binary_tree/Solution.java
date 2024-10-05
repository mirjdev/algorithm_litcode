package solution.balanced_binary_tree;

import lib.TreeNode;

// 110 https://leetcode.com/problems/balanced-binary-tree/description/
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
//                new TreeNode(20),
                null,
                new TreeNode(30,
                        new TreeNode(35), new TreeNode(40)));
        boolean balanced = isBalanced(root);
        System.out.println("balanced = " + balanced);
    }

    public static boolean isBalanced(TreeNode root) {
        return isBalancedAndHeight(root) >= 0;
    }

    public static int isBalancedAndHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = isBalancedAndHeight(root.left);
        if (l < 0) {
            return l;
        }
        int r = isBalancedAndHeight(root.right);
        if (r < 0) {
            return r;
        }
        // если разница между плечами больше 1
        if (Math.abs(l-r) > 1) {
            return -Math.abs(l-r);
        }
        return Math.max(l, r) + 1;
    }

}
