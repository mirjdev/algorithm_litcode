package merge_sorted_array;

import java.util.Arrays;

// 88 https://leetcode.com/problems/merge-sorted-array/
public class Solution {
    public static void main(String[] args) {
/*
* Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
* */
//        int[] nums1 = {1, 2, 7, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        //нули только для того что бы уместились
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i]; // слили два массива
        }
//        Arrays.sort(nums1);
        for (int i = 0, j = m; i < nums1.length; i++) {
            //текущий элемент меньше, чем элемент из второй части, то поменяем их местами
            if (nums1[i] > nums1[j]) {
                nums1[j] = nums1[i];
            }
        }
        System.out.println("Arrays.toString(nums1) = " + Arrays.toString(nums1));
    }

    //    int[] nums1 = {1, 2, 7, 0, 0, 0};
//    int[] nums2 = {2, 5, 6};
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // позиция массива 1 с конца
        int p2 = n - 1; // позиция массива 2 с конца
        int i = m + n - 1;  // общая длина массива
        //Начинаем перебор с конца. В конец будем ставить самый большой элемент, для этого и нужен хвост в массиве, забитый нулями
        //пока есть элементы p2
        while (p2 >= 0) {
            // если самый большой элемент, первой коллекции больше, самого большого второй, то переставим его в самый конец
            // p1 >= 0 не выйти за массив, если первый пустой
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }
        System.out.println("Arrays.toString(nums1) = " + Arrays.toString(nums1));
    }

}
