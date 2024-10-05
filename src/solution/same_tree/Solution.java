package same_tree;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 100 https://leetcode.com/problems/same-tree/description/
public class Solution {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode tree2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("isSameTree(tree1, tree2) = " + isSameTree(tree1, tree2));
    }

    public static boolean isSameTree(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null){
            return true;
        }
        if (p1 == null || p2 == null || p1.val != p2.val){
            return false;
        }

        return isSameTree(p1.left,p2.left) && isSameTree(p1.right, p2.right);
    }
}
