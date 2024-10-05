package solution.maximum_depth_of_binary_tree;

import java.util.ArrayList;
import java.util.List;

// 104 https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class Solution2 {

    private static List<Integer> ints = new ArrayList<Integer>();
    private static int deep = 0;

    //Input: root = [3,9,20,null,null,15,7]
    public static void main(String[] args) {
//        lib.TreeNode root = new lib.TreeNode(3, new lib.TreeNode(9), new lib.TreeNode(20, new lib.TreeNode(15), new lib.TreeNode(7)));  //3
//        lib.TreeNode root = new lib.TreeNode(30, null, new lib.TreeNode(20));
//        lib.TreeNode root = new lib.TreeNode(0);
        TreeNode root = new TreeNode(1,
                new TreeNode(20),
//                null,
                new TreeNode(30,
                        null, new TreeNode(40)));
        int i = maxDepth(root);
        System.out.println("i = " + i);
    }


    private static int maxDepth(TreeNode root) {
        //
        if (root == null) return 0;
        System.out.println("root.val = " + root.val);
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //Спустились в самый низ, и вычисляем какая из ветвей самая большая к ней и прибавляем
        int i = Math.max(left, right) + 1;
        return i;
    }

    public static int dfs(TreeNode root, List<Integer> list) {
        if (root == null) return 0;
        int sum = root.val;
        list.add(sum);
        sum += dfs(root.left, list);
        sum += dfs(root.right, list);
        return sum;
    }

}
