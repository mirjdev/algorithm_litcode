package search;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 7, -2, 15, 95, 154, 6, 8, 31,};
//        int[] arrSorted = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        int result1 = search1(arr, 6);
        System.out.println("result1 = " + result1);
        int result2 = search2(arr, 6);
        System.out.println("result2 = " + result2);
        int result3 = search3(arr, 31);
        System.out.println("result3 = " + result3);
    }


    static int search1(int[] arr, int target) {
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                position = i;
                break;
            }
        }
        return position;
    }

    static int search2(int[] arr, int target) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return Arrays.binarySearch(copy, target);
    }

    static int search3(int[] arr, int target) {
        Arrays.sort(arr);
        int position = -1;
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int middleElement;
        //0,1,2,3,4,5,6,7,8 ищем 3
        while (startIndex <= endIndex) { // пока начало меньше или равно конечному элементу
            middleElement = startIndex + (endIndex - startIndex) / 2;
            if (arr[middleElement] == target) {
                position = middleElement;
                return position;
            }
            //Нужно понять в какой половине искать дальше
            if (target < arr[middleElement]) {
                endIndex = middleElement - 1;
            }
            if (target > arr[middleElement]) {
                startIndex = middleElement + 1;
            }

        }
        return position;
    }
}
