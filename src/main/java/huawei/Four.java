package huawei;

import java.util.Scanner;

/**
 * 字符串分隔
 */
public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            print(s);
        }
    }

    private static void print(String s) {
        if (s.length() > 8) {
            String remain = s.substring(8);
            s = s.substring(0, 8);
            System.out.println(s);
            print(remain);

        } else if (s.length() > 0) {
            s += "0000000";
            s = s.substring(0, 8);
            System.out.println(s);
        }
    }
}
