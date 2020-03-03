package huawei;

import java.util.Scanner;

/**
 * 密码验证合格程序
 */
public class Twenty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int[] conditionals = {0, 0, 0, 0};
            if (str.length() < 9)
                System.out.println("NG");
            else {
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if (ch >= '0' && ch <= '9') {
                        conditionals[0] = 1;
                    } else if (ch >= 'a' && ch <= 'z') {
                        conditionals[1] = 1;
                    } else if (ch >= 'A' && ch <= 'Z') {
                        conditionals[2] = 1;
                    } else {
                        conditionals[3] = 1;
                    }
                }
                int count = 0;
                for (int num : conditionals) {
                    count += num;
                }
                if (count < 3) {
                    System.out.println("NG");
                } else {
                    System.out.println(hasSubstring(str));
                }
            }
        }
    }

    private static String hasSubstring(String str) {
        for (int i = 0; i < str.length() - 3; i++) {
            String str1 = str.substring(i, i + 3);
            String str2 = str.substring(i + 3, str.length());
            if (str2.contains(str1))
                return "NG";
        }
        return "OK";
    }
}