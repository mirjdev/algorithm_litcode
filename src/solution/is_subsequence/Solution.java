package solution.is_subsequence;

//https://leetcode.com/problems/is-subsequence/description/
public class Solution {

    // Последовательность должна соблюдаться
    // должна соблюдаться длина
    // Нужно ввести
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int startAt = 0; //позиция в t, при каждом совпадении будем идти от нее, если не нашлось то false, нашлось, то запомним
        int count = 0;
        //пройтись циклом по s
        for (int i = 0; i < sArr.length; i++) {
            for (int j = startAt; j < tArr.length; j++) {
                char c = tArr[j];
                if (sArr[i] == tArr[j] && startAt <= j) {
                    startAt = j+1;
                    count++;
                    break;
                }
            }
            if (count != i+1) {
                return false;
            }
        }
        //System.out.println("count = " + count);
        return count == s.length();
    }
}


class Start {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.isSubsequence() = " + solution.isSubsequence("axc", "ahbgdc"));
    }
    /*
* Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

* */
}
