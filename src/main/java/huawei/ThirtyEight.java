package huawei;

import java.util.Scanner;

/**
 * 求小球落地5次后所经历的路程和第5次反弹的高度
 */
public class ThirtyEight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            double initHeight = sc.nextDouble();
            double sum = 0;
            double currentHeight = initHeight;
            for (int i = 0; i < 5; i++) {
                sum += currentHeight;
                currentHeight /= 2;
                if (i != 4) sum += currentHeight;
            }
            System.out.println(sum);
            System.out.print(currentHeight);
        }
    }
}
