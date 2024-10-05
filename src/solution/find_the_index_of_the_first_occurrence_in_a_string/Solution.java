package solution.find_the_index_of_the_first_occurrence_in_a_string;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class Solution {
    public static void main(String[] args) {
        //"mississippi", needle = "sad"
        char[] charArray = "mississippi".toCharArray();
        int i = strStr("mississippi", "sipp");
        System.out.println("i = " + i);
        int i1 = "mississippi".indexOf("sipp");
        System.out.println("i1 = " + i1);
    }

    public static int strStr(String haystack, String needle) {
        char first = needle.charAt(0);
        char last = needle.charAt(needle.length() - 1);
        main:
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == first && (haystack.length() >= i + needle.length() && haystack.charAt(i + needle.length() - 1) == last)) {
                //проверить всю строку целиком
                //не проверям первый и последние элементы, так как проверили их выше
                for (int j = i + 1, k = 1; j < i + needle.length() - 1; j++, k++) {
                    if (haystack.charAt(j) != needle.charAt(k)) {
                        continue main;
                    }
                }
                return i;
            }
        }
        return -1;
    }
}
