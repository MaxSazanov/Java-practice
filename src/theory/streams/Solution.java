package theory.streams;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(multiply(list1));
        List<String> list2 = Arrays.asList("bbbb", "Aaadf", "BBaA", "A");
        System.out.println(startsWithA(list2));
        List<Person> list3 = Arrays.asList(new Person("max", 19), new Person("gleb", 6), new Person("sanj", 27));
        System.out.println(above18(list3));
        List<String> list4 = Arrays.asList("bbbb", "bbbb", "A", "bbbb");
        System.out.println(unique(list4));
        List<Student> list5 = Arrays.asList(new Student("max", 5), new Student("gleb", 4), new Student("sanj", 3));
        System.out.println(averageGrade(list5));
        List<String> list6 = Arrays.asList("bbbb", "Aaadf", "BBaA", "A");
        System.out.println(uniqueChars(list6));
    }

    public static List<Integer> multiply(List<Integer> list) {
        return list.stream().map(x -> x * 2).toList();
    }
    public static List<String> startsWithA(List<String> list) {
        return list.stream().filter(x -> x.startsWith("A")).toList();
    }
    public static List<Person> above18(List<Person> list) {
        return list.stream().filter(x -> x.age > 18).toList();
    }
    public static List<String> unique(List<String> list) {
        return list.stream().distinct().toList();
    }
    public static double averageGrade(List<Student> list) {
        OptionalDouble averageGrade = list.stream().mapToInt(x -> x.grade).average();
        return averageGrade.isPresent() ? averageGrade.getAsDouble() : 0.0;
    }
    public static List<Character> uniqueChars(List<String> list) {
        return list.stream().flatMap(x -> x.chars().mapToObj(ch -> (char) ch)).distinct().toList();
    }
}