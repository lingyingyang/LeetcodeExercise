package interview;

import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int maxLen = 0;
            int currLen = 0;
            int left = str.length() - 1;
            int right = str.length() - 1;
            String out = "";
            for (; left >= 0 && right >= 0; left--) {
                char currVal = str.charAt(left);
                System.out.println(String.format("currVal: %c", currVal));
                if ((currVal >= '0' && currVal <= '9') || currVal == '.') {
                    currLen++;
                } else {
                    String tmp = "";
                    if (currLen > maxLen) {
                        tmp = str.substring(left + 1, right);
                        System.out.println(tmp);
                        maxLen = currLen;
                    }
                    System.out.println(String.format("currLen: %d, maxLen: %d", currLen, maxLen));
                    System.out.println(String.format("tmp: %s", tmp));
                    right = left;
                    if (tmp.contains(".")) {
                        String[] outs = tmp.split("\\.");
                        int max = 0;
                        for (int i = outs.length - 1; i > 1; i--) {
                            if (outs[i].length() + outs[i - 1].length() > max) {
                                out = outs[i - 1] + "." + outs[i];
                                max = outs[i].length() + outs[i - 1].length();
                                maxLen = max;
                                currLen = 0;
                            }
                        }
                    }
                }
            }
            System.out.println(out);
        }
    }
    // a123.4567888abcd123.4567.890.123
}
