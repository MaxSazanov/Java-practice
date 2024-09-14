package theory.map;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        HashMap<Integer, Integer> frequencyDictionary = new HashMap<>();
        for (String arg : args) {
            Integer num = Integer.parseInt(arg);
            if (frequencyDictionary.containsKey(num)) {
                frequencyDictionary.put(num, frequencyDictionary.get(num) + 1);
            }
            else {
                frequencyDictionary.put(num, 1);
            }
        }
        System.out.println(frequencyDictionary);
    }
}
