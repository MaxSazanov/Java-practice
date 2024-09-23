package algorithms.leetcode.t1403;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        while (console.hasNextInt()) {
            nums.add(console.nextInt());
        }
        System.out.println(minSubsequence(nums.stream().mapToInt(Integer::intValue).toArray()));
    }

    public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int notIncludedSum = Arrays.stream(nums).sum();
        int includedSum = 0;
        LinkedList<Integer> included = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0 && includedSum <= notIncludedSum; --i) {
            includedSum += nums[i];
            notIncludedSum -= nums[i];
            included.add(nums[i]);
        }
        return included;
    }
}
