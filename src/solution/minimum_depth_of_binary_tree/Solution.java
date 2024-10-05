package solution.minimum_depth_of_binary_tree;

import lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 111 https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(20),
//                null,
                new TreeNode(30,
                        new TreeNode(35), new TreeNode(40)));
        int i = minDepth(root);
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
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int min = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Queue<TreeNode> qNext = new LinkedList<>();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) continue;
            if (node.left != null) {
                qNext.add(node.left);
            }
            if (node.right != null) {
                qNext.add(node.right);
            }
            if (node.left == null && node.right == null) {
                return min;
            }
            if (q.isEmpty() && !qNext.isEmpty()) {
                q = new LinkedList<>(qNext);
                qNext.clear();
                min++;
            }
        }
        return min;
    }

}
