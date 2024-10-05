package solution.index_two_sum;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum/
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int sum = 9;
        int[] ints = twoSum(arr, sum);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
