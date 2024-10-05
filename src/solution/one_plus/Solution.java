package one_plus;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class Solution {
    public static void main(String[] args) {
        int[] source = {9, 9, 9, 9};
        int[] ints = plusOne0(source);
        Arrays.stream(ints).peek(System.out::println).toArray();
    }

    public static int[] plusOne0(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // основной кейс, прибавления +1
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // иначе проставляем последние число +1 в -> 0
            digits[i] = 0;
        }
        int[] ints = Arrays.copyOf(digits, digits.length + 1);
        ints[0] = 1;
        return ints;
    }

    public static int[] plusOne1(int[] digits) {
        //Нужно прибавить к последнему элементу массива +1, и вернуть массив
        // 9 = 1, 0, т.е. будет увеличение массива
        if (digits.length == 0) {
            return new int[0];
        }

        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        if (digits[digits.length - 1] == 9 && digits.length == 1) {
            digits[digits.length - 1]++;
            return new int[]{1, 0};
        }
        int[] ints = digits;
        recUpdate(true, ints.length - 1, ints);
        if (ints[0] == 10) {
            ints = Arrays.copyOf(ints, ints.length + 1);
            ints[0] = 1;
            ints[1] = 0;
        }
        return ints;
    }

    public static int[] recUpdate(boolean update, int index, int[] digits) {
        while (digits[index] == 10 || update) {
            update = false;
            if (digits[index] == 9) {
                digits[index] = 0;
                int i = digits[index - 1] + 1;
                digits[index - 1] = i;
                if (i < 10) {
                    update = false;
                }
            }
            if (digits[index] == 10 && index != 0) {
                digits[index] = 0;
                int i = digits[index - 1] + 1;
                digits[index - 1] = i;
                if (i == 9) {
                    update = false;
                    return digits;
                }
            }
            if (digits[index] == 10 && index == 0) {
                int[] ints = Arrays.copyOf(digits, digits.length + 1);
                ints[0] = 0;
                ints[1] = 0;
                return ints;
            }

            index--;
            if (digits.length - index > 0) {
                recUpdate(update, index, digits);
            }
        }
        return digits;
    }

}
