package solution.min_element;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 9, 15, -2, 100, -10};
        System.out.println("arr1 = " + searchMinElementInArrayVer1(arr));
        System.out.println("arr2 = " + searchMinElementInArrayVer2(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + arr[i]);
        }
    }

    static int searchMinElementInArrayVer1(int[] arr) {
        int low = arr[0];
        for (int i : arr) {
            if (i < low) {
                low = i;
            }
        }
        return low;
    }

    static int searchMinElementInArrayVer2(int[] arr) {
        int[] copied = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copied);
        return copied[0];
    }

}
