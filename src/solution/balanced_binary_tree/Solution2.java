package solution.balanced_binary_tree;

import lib.TreeNode;

// 110 https://leetcode.com/problems/balanced-binary-tree/description/
public class Solution2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(20),
//                null,
                new TreeNode(30,
                        null, new TreeNode(40)));
        boolean balanced = isBalanced(root);
        System.out.println("balanced = " + balanced);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int i = depthHelper(root);
        System.out.println("i = " + i);
        return i != -1;
    }

    /*
            1
                  1 2    +1 = 3
           / \
         20   30  0 1    +1 = 2
        /  \ /  \
                  40
                 0  0    +1
  --------------------------------------------

            1
                  0 2
           / \
              30  0 1    +1 = 2
             /  \
                  40
                 0  0    +1
    * */
    private static int depthHelper(TreeNode root) {
        if (root == null) return 0; // дошли до конца - 0 , +1 прибавим в return
        //System.out.println("root = " + root);
        int left = depthHelper(root.left);
        if (left < 0) {
            return left;
        }
        int right = depthHelper(root.right);
        if (right < 0) {
            return right;
        }
        // если в какой-то момент разница стала больше чем 1, вернем отрицательное число
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}
