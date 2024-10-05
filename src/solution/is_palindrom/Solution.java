package solution.is_palindrom;

//https://leetcode.com/problems/palindrome-number/description/
public class Solution {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(1221);
        System.out.println("palindrome = " + palindrome);
    }

    static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
