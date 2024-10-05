package remove_duplicates_from_sorted_array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class Solution {
    public static int removeDuplicates(int[] nums) {
        //нужно отсортировать массив, и вывести дубликаты
        if (nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        int pos;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                pos = ++cnt;
                //2переместим на место 1
                nums[pos] = nums[i];
            }
            printArr(nums);
        }
        ++cnt;
        for (int i = cnt; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println("================");
        printArr(nums);
        return cnt;
    }

    private static void printArr(int[] nums) {
        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + " - ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
/*
* for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
* */
    /*
    * public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        nums = Arrays.copyOf(nums, length * 2);
        int prev = -1;
        int count = 0;
        int pos = length;
        for (int i = 0; i < length; i++) {
            // если уже было, не добавляем в конец
            if (nums[i] == prev) {
                count++;
            } else {
                nums[pos] = nums[i];
                pos++;
            }
            prev = nums[i];
        }
        nums = Arrays.copyOfRange(nums, length, nums.length);
        return length - count;
    }
    * */
}
