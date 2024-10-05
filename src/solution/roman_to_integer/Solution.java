package roman_to_integer;
//https://leetcode.com/problems/roman-to-integer/description/
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
public class Solution {
    static char[] allowedChars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static final Map<String, Integer> romans = new HashMap<>();

    static {
        romans.put("I", 1);
        romans.put("V", 5);
        romans.put("X", 10);
        romans.put("L", 50);
        romans.put("C", 100);
        romans.put("D", 500);
        romans.put("M", 1000);
    }

    public static int romanToInt2(String s) {
        //Сначала идут большие значения, потом меньшие, но есть исключения
        int acc = 0;
        for (int i = 0; i < s.length(); i++) {
            // Вычисляем сабстринг CMXCIV, нужно найти CM, найти самый большой элемент
            //   C  M      X    C    I   V
            // -100+1000, -10 + 100, -1 + 5
            //   0  1      2    3    4   5
            int maxElement = i + indexMaxElement(s.substring(i));
            if (i == i + maxElement) {
                acc = acc + romans.get(s.charAt(i) + "");
            } else {
                int end = maxElement;
                Integer tail = romans.get(s.charAt(end) + "");
                //взять последний элемент и вычитать значения, и вернуть результат
                String substring = s.substring(i, end);
                for (int j = 0; j < substring.length(); j++) {
                    tail = tail - romans.get(substring.charAt(j) + "");
                }
                acc = acc + tail;
                i = end;
            }
        }
//        System.out.println("acc = " + acc);
        return acc;
    }

    //Нужно вычислить для сложного кейса, когда будем вычитать
    //найти подстроку, с максимальным значением в конце
    public static int indexMaxElement(String s) {
        int next = 0;
        while (s.length() - 1 > next && romans.get(s.charAt(next) + "") < romans.get(s.charAt(next + 1) + "")) {
            next++;
        }
        return next;
    }

    public static void main(String[] args) {
//        int i = romanToInt("CMXCIV");
//        int i = romanToInt("MCMXCIV");
        int i = romanToInt("MCMXCIV");
        System.out.println("i = " + i);
    }

    public static int romanToInt(String s) {
        //проитерируемся с конца, если прошлый элемент больше, чем текущий, значит нужно отнять текущие значение
        // иначе прибавить
        int acc = 0, pref = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int vlv = Roman.valueOf(s.charAt(i) + "").vlv;
            if (vlv < pref) { // если прошлый элемент больше, чем текущий, значит нужно отнять текущие значение
                acc -= vlv;
            } else {
                acc += vlv;
            }
            pref = vlv;
        }
        return acc;
    }

    enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000),
        ;

        int vlv;

        Roman(int vlv) {
            this.vlv = vlv;
        }
    }

    public static boolean checkRoman(String s) {
        // Если дошли до конца разрешенного массива, и нет совпадений, кинем -1
        for (int i = 0; i < s.length(); i++) {
            int notAllowedMarker = -1;
            for (char allowedChar : allowedChars) {
                if (s.charAt(i) == allowedChar) {
                    notAllowedMarker = 0;
                    break;
                }
            }
            if (notAllowedMarker == -1) {
                System.out.println("Not allowed simbol = " + s.charAt(i));
                return false;
            }
        }
        return true;
    }

    public static boolean checkRoman2(String s) {
        Set<String> chars = new HashSet<>();
        for (char c : allowedChars) {
            chars.add(String.valueOf(c));
        }
        for (int i = 0; i < s.length(); i++) {
            if (!chars.contains(s.charAt(i) + "")) {
                System.out.println("Not allowed simbol = " + s.charAt(i));
                return false;
            }
        }
        return true;
    }
}
