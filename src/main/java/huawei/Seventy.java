package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 计算日期到天数转换
 */
public class Seventy {
    public static int getAllDay(int year, int month, int day) {
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //判断闰年
        if (year % 4 == 0) daysOfMonth[1] = 29;
        int total = 0;
        for (int i = 0; i < month - 1; i++) {
            total += daysOfMonth[i];
        }
        total += day;
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] ins = line.split(" ");
            int year = Integer.parseInt(ins[0]);
            int month = Integer.parseInt(ins[1]);
            int day = Integer.parseInt(ins[2]);
            System.out.println(getAllDay(year, month, day));
        }

    }
}
