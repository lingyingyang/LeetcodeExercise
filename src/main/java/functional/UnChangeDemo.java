package functional;

import java.util.Arrays;

public class UnChangeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).map(x -> x + 1).forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
