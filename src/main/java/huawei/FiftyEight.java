package huawei;

import java.util.Scanner;

/**
 * 放苹果
 */
public class FiftyEight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int apple = sc.nextInt();
            int plate = sc.nextInt();
            System.out.println(helper(apple, plate));
        }
    }

    public static int helper(int apple, int plate) {
        if (apple == 0 || plate == 1) {
            return 1;
        } else if (apple < plate) {
            return helper(apple, apple);
        } else {
            return helper(apple, plate - 1) + helper(apple - plate, plate);
        }
    }
}
