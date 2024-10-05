package solution.minimum_depth_of_binary_tree;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

// Simple BFS
// 111 https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class Solution2BFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(20, new TreeNode(7), new TreeNode(15)),
                new TreeNode(30, null, new TreeNode(40)));
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
        if (root == null)
            return 0;
        int minDepth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null)
                    return minDepth;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return 0;
    }

}
