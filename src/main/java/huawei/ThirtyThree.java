package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 整数与IP地址间的转换
 */
public class ThirtyThree {
    public static void changeToNumber(String str) {
        String[] in = str.split("\\.");

        in[0] = Integer.toBinaryString(Integer.parseInt(in[0]));
        in[1] = Integer.toBinaryString(Integer.parseInt(in[1]));
        in[2] = Integer.toBinaryString(Integer.parseInt(in[2]));
        in[3] = Integer.toBinaryString(Integer.parseInt(in[3]));

        while (in[0].length() < 8) in[0] = "0" + in[0];
        while (in[1].length() < 8) in[1] = "0" + in[1];
        while (in[2].length() < 8) in[2] = "0" + in[2];
        while (in[3].length() < 8) in[3] = "0" + in[3];


        long sum = 0;
        for (String s : in) {
            for (int j = 0; j < in[0].length(); j++) {
                sum = sum * 2 + (s.charAt(j) - '0');
            }
        }
        System.out.println(sum);

    }

    public static void changeToAddress(String str) {
        long in = Long.parseLong(str);
        String binaryStr = Long.toBinaryString(in);
        String[] out = new String[4];
        out[0] = binaryStr.substring(0, binaryStr.length() - 3 * 8);
        out[1] = binaryStr.substring(out[0].length(), out[0].length() + 8);
        out[2] = binaryStr.substring(out[0].length() + out[1].length(), out[0].length() + out[1].length() + 8);
        out[3] = binaryStr.substring(binaryStr.length() - 8, binaryStr.length());

        System.out.print(Integer.valueOf(out[0], 2) + ".");
        System.out.print(Integer.valueOf(out[1], 2) + ".");
        System.out.print(Integer.valueOf(out[2], 2) + ".");
        System.out.println(Integer.valueOf(out[3], 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            changeToNumber(str);
            str = br.readLine();
            changeToAddress(str);
        }
    }
}
