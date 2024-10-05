package remove_element;

import java.util.Arrays;

//27 https://leetcode.com/problems/remove-element/description/
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        System.out.println(removeElement(arr, 3));
    }
    // 0, 1, 2, 3, 4
    // 0, 2, 3, 4, _

    // 0, 1, 1, 3, 4
    // 0, 3, 4, _, _
    public static int removeElement1(int[] nums, int val) {
        int k = 0; // число элементов не val
        int swapLast = nums.length - 1; // может понадобиться, если подряд будет идти много элементов одинаковых
        for (int i = 0, j = nums.length - 1; i < nums.length; i++) {
            // когда найдем первый элемент с начала, найдем элемент с конца который можем переместить в начало
            if (nums[i] == val && i < swapLast) {
                //ищем первый элемент с конца который, переместим в начало
                while (nums[j] == val && j > i) {
                    swapLast = --j;
                }
                nums[i] = nums[swapLast];
                nums[swapLast] = val;
            }
            if (nums[i] != val) {
                k++;
            }
            // System.out.println("i = " + i + " _ " + Arrays.toString(nums));
        }

        //System.out.println("Final arr = " + Arrays.toString(nums));
        return k;
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
            System.out.println("arr = " + Arrays.toString(nums));
        }
        System.out.println("Final arr = " + Arrays.toString(nums));
        return index;
    }
}
