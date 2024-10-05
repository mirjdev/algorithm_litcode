package solution.minimum_depth_of_binary_tree;

import lib.TreeNode;

// Simple DFS
// 111 https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class Solution2DFS {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1,
////                new TreeNode(20),
//                null,
//                new TreeNode(30,
//                        new TreeNode(35), new TreeNode(40)));

        TreeNode root = new TreeNode(1,
                new TreeNode(20, new TreeNode(21), new TreeNode(22)),
                new TreeNode(30));
        int i = minDepth__dfs(root);
        System.out.println("i = " + i);
    }

    /*
            1
                  1 2    +1 = 3
           / \
         20   30  0 1    +1 = 2
        /  \ /  \
                  40
                 0  0    +1

     */
    public static int minDepth__dfs(TreeNode root) {
        if (root == null)
            return 0;
        return depth(root);
    }

    private static int depth(TreeNode root) {
        if (root == null)
            return (int) 1e9;
        if (root.left == null && root.right == null)
            return 1;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return 1 + Math.min(leftDepth, rightDepth);
    }

}
