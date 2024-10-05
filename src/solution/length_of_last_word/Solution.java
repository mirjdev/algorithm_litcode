package solution.length_of_last_word;

//58 https://leetcode.com/problems/length-of-last-word/description/
public class Solution {
    public static void main(String[] args) {
        int i = lengthOfLastWord1("Hello World  ");
        System.out.println("i = " + i);
    }

    public static int lengthOfLastWord1(String s) {
        int firstCharPos = -1;
        int lastCharPos = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isAlphabetic(s.charAt(i))) {
                lastCharPos = i;
                break;
            }
        }
        if (lastCharPos != -1) {
            String substring = s.substring(0, lastCharPos + 1);
            for (int i = substring.length() - 1; i >= 0; i--) {
                if (!Character.isAlphabetic(substring.charAt(i))) {
                    firstCharPos = i;
                    break;
                }
            }
        }
        return lastCharPos - firstCharPos;
    }

    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}
