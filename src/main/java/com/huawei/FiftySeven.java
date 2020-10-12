package com.huawei;

import java.util.Scanner;

/**
 * 查找组成一个偶数最接近的两个素数
 */
public class FiftySeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int in = sc.nextInt();
            sc.nextLine();
            int mid = in / 2;
            int low = mid;
            int high = mid;
            while (low > 1 && high < in) {
                if (isPrimeNumber(low) && isPrimeNumber(high)) {
                    System.out.println(low);
                    System.out.println(high);
                    break;
                }
                low--;
                high++;
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
