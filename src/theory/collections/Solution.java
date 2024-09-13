package theory.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            nums.add((int) (Math.random() * 100 % 20));
        }

        Iterator<Integer> iter = nums.iterator();
        while (iter.hasNext()) {
            if (iter.next() % 2 == 0) {
                iter.remove();
            }
        }
        System.out.println(nums);
        TreeSet<Integer> set = new TreeSet<>(nums);
        System.out.println(set);
    }
}