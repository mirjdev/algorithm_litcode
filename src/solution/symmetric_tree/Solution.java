package solution.symmetric_tree;

//101 https://leetcode.com/problems/symmetric-tree/description/
public class Solution {
    public static void main(String[] args) {
        //root = [1,2,2,3,4,4,3]
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(3), new TreeNode(4)));

        boolean symmetric = isSymmetric(treeNode);
        System.out.println("symmetric = " + symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public static boolean isSameTree(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null || p1.val != p2.val) {
            return false;
        }

        return isSameTree(p1.left, p2.right) && isSameTree(p1.right, p2.left);
    }
}
