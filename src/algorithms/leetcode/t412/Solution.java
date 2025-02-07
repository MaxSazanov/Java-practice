package algorithms.leetcode.t412;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            }
            else if (i % 5 == 0) {
                list.add("Buzz");
            }
            else if (i % 3 == 0) {
                list.add("Fizz");
            }
            else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(15));
    }
}
