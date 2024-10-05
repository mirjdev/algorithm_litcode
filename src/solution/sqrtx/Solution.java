package solution.sqrtx;

//https://leetcode.com/problems/sqrtx/description/
public class Solution {
    public static void main(String[] args) {
        System.out.println("mySqrt(36) = " + mySqrt(2147395599));
        System.out.println("mySqrt(4) = " + mySqrt(4));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int start = 0;
        long end = x, ans = 0;
        //бинарный поиск, числа, умножение которого на себя, даст нам корень
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long x2mid = mid * mid;
            if (x2mid == x) {
                return (int) mid;
            } else if (x2mid > x) {
                end = (int) mid - 1;
            } else {
                start = (int) (mid + 1);
            }
        }
        return (int) end;
    }
}
