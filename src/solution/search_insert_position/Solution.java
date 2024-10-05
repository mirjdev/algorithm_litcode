package search_insert_position;

//35 https://leetcode.com/problems/search-insert-position/description/
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int i = searchInsert(arr, 0);
        System.out.println("i = " + i);
    }

    //    Example 1:
//
//    Input: nums = [1,3,5,6], target = 5
//    Output: 2
//    Example 2:
//
//    Input: nums = [1,3,5,6], target = 2
//    Output: 1
//    Example 3:
//
//    Input: nums = [1,3,5,6], target = 7
//    Output: 4
    //вернуть позицию найденного элемента в массиве или предполагаемое место
    public static int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int mid;
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            //  0 +  3 - 0 / 2
            //  3 +  7 - 3 / 2
            mid = s + (e - s) / 2;
            System.out.println("start:  " + s + ", end: " + e);
            System.out.println("mid:  " + mid);
            if (nums[mid] < target) {
                s = mid + 1;
            } else if (nums[mid] > target) {
                e = mid - 1;
                ans = mid;
            } else {
                return mid;
            }
        }
        return ans;
    }
//
//    public static int searchInsert(int[] nums, int target) {
//        boolean found = false;
//        int position = -1;
//        int middle;
//        int start = 0;
//        int end = nums.length - 1;
//        if (target < nums[start]) {
//            return 0;
//        } else if (target > nums[end]) {
//            return ++end;
//        }
//        while (!found) {
//            middle = (end + start) / 2; // вычислить позицию средины элемента
////            System.out.println("middle = " + middle);
//            if (nums[middle] == target) {
//                position = middle;
//                found = true;
//            } else if (end - start == 1) {
//                return (middle + 1);
//            } else if (nums[middle] > target) {
//                end = middle;
//            } else if (nums[middle] < target) {
//                start = middle;
//            }
//
//        }
//        return position;
//    }
}
