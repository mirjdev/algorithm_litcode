package solution.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

// 94 https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class Solution {

    public static void main(String[] args) {
        //[1,null,2,3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> integers = inorderTraversal(root);
        System.out.println("integers = " + integers);
    }

    //рекурсивно добавляем левые и правые элементы
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> integers = new ArrayList<>();

        //сначала пройдемся по левой ветке
        if (root.left != null) { // спускаемся по левой ветке
            integers.addAll(inorderTraversal(root.left));
        }
        // кейс когда левый пустой, и надо добавить
        integers.add(root.val);

        if (root.right != null) {
            integers.addAll(inorderTraversal(root.right));
        }

        return integers;
    }
}
