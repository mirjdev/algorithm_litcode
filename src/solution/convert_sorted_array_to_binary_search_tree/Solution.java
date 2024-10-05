package solution.convert_sorted_array_to_binary_search_tree;

import lib.TreeNode;

// 108 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class Solution {


    public static void main(String[] args) {
        int[] arr = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        TreeNode node = sortedArrayToBST(arr);
        System.out.println(node);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int s, int e) {
        //найти середину, создать для нее вершину
        if (s > e) {
            return null;
        }
        // рекурсивно вставлять левые / правые листы
        int mid = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        //System.out.println("node = " + node);
        node.left = helper(nums, s, mid - 1);
        node.right = helper(nums, mid+1, e);
        return node;
    }

}
