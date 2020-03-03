package huawei;

import java.util.Scanner;

/**
 * 单词倒排
 */
public class ThirtyOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] in = str.split("\\s+");

            if (in.length < 2) System.out.println(in[0]);
            int left = 0;
            int right = in.length - 1;
            while (left < right) {
                swap(in, left++, right--);
            }
            for (String s : in) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static void swap(String[] in, int left, int right) {
        String tmp = in[left];
        in[left] = in[right];
        in[right] = tmp;
    }
}
