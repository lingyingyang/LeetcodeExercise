package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class ThirtyFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] in = str.toCharArray();
            Arrays.sort(in);
            for (char c : in) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
