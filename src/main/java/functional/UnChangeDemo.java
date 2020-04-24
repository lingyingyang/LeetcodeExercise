package functional;

import java.util.Arrays;

public class UnChangeDemo {
    /**
     * stream并没有改变arr的值
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).map(x -> x + 1).forEach(x -> {
            System.out.print(x + " ");
        });
        System.out.println();
        Arrays.stream(arr).forEach(x -> {
            System.out.print(x + " ");
        });
    }
}
