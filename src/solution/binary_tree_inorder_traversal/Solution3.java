package solution.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

// 94 https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class Solution3 {

    public static void main(String[] args) {
        //[1,null,2,3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), new TreeNode(4, null, new TreeNode(5))));
        List<Integer> integers = new ArrayList<>();
        integers = inorderTraversal(root, integers);
        System.out.println("integers = " + integers);
    }

    //рекурсивно добавляем левые и правые элементы
    public static List<Integer> inorderTraversal(TreeNode root, List<Integer> integers) {
        if (root == null) {
            return integers;
        }

        //сначала пройдемся по левой ветке
        if (root.left != null) { // спускаемся по левой ветке
            inorderTraversal(root.left, integers);
        }
        // кейс когда левый пустой, и надо добавить
        integers.add(root.val);
        System.out.println("integers = " + integers);

        if (root.right != null) {
            inorderTraversal(root.right, integers);
        }
//        integers.add(root.val);
//        System.out.println("integers = " + integers);
        return integers;
    }
}
