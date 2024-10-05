package solution.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 94 https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class Solution2 {

    public static void main(String[] args) {
        //[1,null,2,3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> integers = inorderTraversal(root);
        System.out.println("integers = " + integers);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
       while (cur != null || !stack.isEmpty()) {
           while (cur != null){
               stack.push(cur);
               cur = cur.left;
           }
           cur = stack.pop();
           integers.add(cur.val);
           cur = cur.right;
       }
       return integers;
    }
}
