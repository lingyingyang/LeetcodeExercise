package huawei;

import java.util.Scanner;

/**
 * 统计每个月兔子的总数
 */
public class ThirtySeven {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int monthCount = Integer.parseInt(line);
            System.out.println(getTotalCount(monthCount));
        }
    }

    public static int getTotalCount(int monthCount) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < monthCount; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
