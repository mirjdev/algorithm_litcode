package solution.valid_anagram;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//242 https://leetcode.com/problems/valid-anagram/description/
public class Solution {
    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagarat");
        System.out.println("anagram = " + anagram);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Long> sMap = Arrays.stream(s.split(""))
                .map(s1 -> s1.charAt(0))
                .collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));

        Map<Character, Long> tMap = Arrays.stream(t.split(""))
                .map(s1 -> s1.charAt(0))
                .collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));

        return sMap.equals(tMap);
    }
}
