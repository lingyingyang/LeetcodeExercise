package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串加解密
 */
public class TwentyNine {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bf.readLine()) != null) {
            String str1 = Encrypt(str);
            System.out.println(str1);
            str = bf.readLine();
            String str2 = unEncrypt(str);
            System.out.println(str2);
        }
    }

    private static String Encrypt(String line) {
        char[] cha = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cha) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') {
                    sb.append('A');
                } else {
                    sb.append((char) (c + 1 - 32));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') {
                    sb.append('a');
                } else {
                    sb.append((char) (c + 32 + 1));
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '9') {
                    sb.append('0');
                } else {
                    sb.append(c - 48 + 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    private static String unEncrypt(String line) {
        char[] cha = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cha) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a') {
                    sb.append('Z');
                } else {
                    sb.append((char) (c - 1 - 32));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'A') {
                    sb.append('z');
                } else {
                    sb.append((char) (c + 32 - 1));
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '0') {
                    sb.append('9');
                } else {
                    sb.append(c - 48 - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
