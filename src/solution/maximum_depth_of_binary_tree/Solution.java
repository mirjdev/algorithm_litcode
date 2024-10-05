package solution.maximum_depth_of_binary_tree;

import java.util.ArrayList;
import java.util.List;

// 104 https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class Solution {

    private static List<Integer> ints = new ArrayList<Integer>();
    private static int deep = 0;

    //Input: root = [3,9,20,null,null,15,7]
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(20),
                new TreeNode(30,
                        null, new TreeNode(40)));
        int i = maxDepth(root);
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
* */
    private static int maxDepth(TreeNode root) {
        //
        if (root == null) return 0;
        int left = maxDepth(root.left);
        System.out.println("left = " + left);
        int right = maxDepth(root.right);
        System.out.println("right = " + right);
        //Спустились в самый низ, и вычсиляем какая из ветвей самая большая к ней и прибавляем
        int i = Math.max(left, right) + 1;
        System.out.println("i = " + i);
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
