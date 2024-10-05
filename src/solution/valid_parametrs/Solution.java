package solution.valid_parametrs;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
public class Solution {
//    char[] charsOpen = {'(', '{', '['};
//    char[] charsClose = {')', '}', ']'};

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        //пройдемся по строке
        for (int i = 0; i < s.length(); i++) {
            // если открывающая скобка, тогда добавил ее закрывающую в стек
            if (s.charAt(i) == '(') {
                stack.push(')'); //добавляем в шапку закрывающую скобку, которую проверим потом
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) { //stack.pop() извлечем и проверим
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        System.out.println(isValid(s1));

        String s2 = "([])";
        System.out.println(isValid(s2));
    }
    /*
    * Example 1:
        Input: s = "()"
        Output: true
        Example 2:
        Input: s = "()[]{}"
        Output: true
        Example 3:
        Input: s = "(]"
        Output: false
        Example 4:
        Input: s = "([])"
        Output: true
    * */
}
