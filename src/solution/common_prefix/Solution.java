package solution.common_prefix;

//https://leetcode.com/problems/longest-common-prefix/description/
public class Solution {
    public static void main(String[] args) {
        String[] sArr = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(sArr);
        System.out.println("s = " + s);
    }

    public static String longestCommonPrefix(String[] strs) {
        //Найти самый длинный префикс, из слов всех массивов
        //если первая итерация успешная, найти самое короткое слово
        StringBuilder tmp = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        for (int i = 0; i < minLength; i++) {
            var firstChar = strs[0].charAt(i);
            //пока каждый равен, тогда ок, иначе вернем tmp
            for (String str : strs) {
                if (firstChar != str.charAt(i)) {
                    return tmp.toString();
                }
            }
            tmp.append(firstChar);
        }
        return tmp.toString();
    }
}
