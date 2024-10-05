package solution.climbing_stairs;

// 70 https://leetcode.com/problems/climbing-stairs/description/
public class Solution {

    public static void main(String[] args) {
        int result = climbStairs(5);
        System.out.println("result = " + result);
    }

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] memory = new int[n + 1];
        memory[0] = 0; //
        memory[1] = 1; // первый шаг
        memory[2] = 2; // второй шаг
        // нужен массив, для сохранения шагов которые уже были
        // следующий шаг будет суммой двух прошлых // типичные числа фибоначи
        for (int i = 3; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }
//f(n) = f(n-1) + f(n-2)
//    Input: n = 3
//    Output: 3
//    Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step

    /*
    4 шага - 5 вариантов
    1. 1 + 1 + 1 + 1  = 1
    2. 1 + 2 + 1 / 2 + 1 + 1 / 1 + 1 + 2
    3. 2 + 2
     */

    /*
    5 шагов
    1) 1+ 1 +1 +1 +1
    2)
    */
}
