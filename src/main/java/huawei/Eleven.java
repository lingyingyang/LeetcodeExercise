package huawei;

import java.util.Scanner;

/**
 * 数字颠倒
 */
public class Eleven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            for (int i = s.length() - 1; i >= 0; i--) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
    }
}
